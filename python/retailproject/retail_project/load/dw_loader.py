from datetime import datetime
from sqlalchemy import text
from utils.database import get_target_connection

def latest_staging_rows(staging_table, key_column):
    query = text(f"""
        SELECT s.*
        FROM {staging_table} s
        JOIN (
            SELECT {key_column}, MAX(etl_batch_id) AS max_batch_id
            FROM {staging_table}
            GROUP BY {key_column}
        ) x
          ON s.{key_column} = x.{key_column}
         AND s.etl_batch_id = x.max_batch_id
    """)
    with get_target_connection().connect() as connection:
        return connection.execute(query).mappings().all()

def load_dim_simple(
    source_table,
    staging_table,
    key_column,
    columns,
    dimension_table,
    dimension_key,
    batch_id=None,
):
    """
    Initial/current-state loader for non-SCD dimensions.
    Existing current records are left untouched.
    """
    rows = latest_staging_rows(staging_table, key_column)
    inserted = 0
    query = text(f"""
        INSERT INTO {dimension_table}
        ({", ".join(columns)}, effective_from, is_current, source_batch_id)
        SELECT {", ".join([f":{c}" for c in columns])},
               CURRENT_TIMESTAMP, TRUE, :batch_id
        WHERE NOT EXISTS (
            SELECT 1
            FROM {dimension_table}
            WHERE {dimension_key} = :key_value
              AND is_current = TRUE
        )
    """)
    engine = get_target_connection()
    with engine.begin() as connection:
        for row in rows:
            params = {c: row[c] for c in columns}
            params["batch_id"] = batch_id
            params["key_value"] = row[key_column]
            result = connection.execute(query, params)
            inserted += result.rowcount or 0
    return inserted

def scd2_load_dimension(
    staging_table,
    business_key,
    tracked_columns,
    dimension_table,
    dimension_columns,
    source_batch_id=None,
):
    """
    SCD Type 2 loader.
    A new version is inserted when any tracked attribute changes.
    The previous current version is expired.
    """
    rows = latest_staging_rows(staging_table, business_key)
    engine = get_target_connection()

    inserted = 0
    expired = 0

    select_current = text(f"""
        SELECT *
        FROM {dimension_table}
        WHERE {business_key} = :business_key
          AND is_current = TRUE
        LIMIT 1
    """)

    expire = text(f"""
        UPDATE {dimension_table}
        SET is_current = FALSE,
            effective_to = CURRENT_TIMESTAMP
        WHERE {business_key} = :business_key
          AND is_current = TRUE
    """)

    insert_sql = text(f"""
        INSERT INTO {dimension_table}
        ({", ".join(dimension_columns)},
         effective_from, effective_to, is_current, source_batch_id)
        VALUES
        ({", ".join([f":{c}" for c in dimension_columns])},
         CURRENT_TIMESTAMP, NULL, TRUE, :source_batch_id)
    """)

    with engine.begin() as connection:
        for row in rows:
            current = connection.execute(
                select_current,
                {"business_key": row[business_key]},
            ).mappings().first()

            changed = current is None

            if current is not None:
                for col in tracked_columns:
                    old = current.get(col)
                    new = row.get(col)
                    if str(old) != str(new):
                        changed = True
                        break

            if not changed:
                continue

            if current is not None:
                result = connection.execute(
                    expire,
                    {"business_key": row[business_key]},
                )
                expired += result.rowcount or 0

            params = {
                c: row[c]
                for c in dimension_columns
            }
            params["source_batch_id"] = source_batch_id

            connection.execute(insert_sql, params)
            inserted += 1

    return inserted, expired

def load_date_dimension():
    query = text("""
        INSERT INTO dim_date(
            date_sk, full_date, day_of_month, month_number,
            month_name, quarter_number, year_number,
            day_of_week, day_name, is_weekend
        )
        SELECT DISTINCT
            DATE_FORMAT(order_date, '%Y%m%d') + 0,
            order_date,
            DAY(order_date),
            MONTH(order_date),
            MONTHNAME(order_date),
            QUARTER(order_date),
            YEAR(order_date),
            DAYOFWEEK(order_date),
            DAYNAME(order_date),
            CASE
                WHEN DAYOFWEEK(order_date) IN (1,7)
                THEN TRUE ELSE FALSE
            END
        FROM stg_orders s
        WHERE s.order_date IS NOT NULL
          AND NOT EXISTS (
              SELECT 1
              FROM dim_date d
              WHERE d.full_date = s.order_date
          )
    """)
    with get_target_connection().begin() as connection:
        result = connection.execute(query)
        return result.rowcount or 0

def load_fact_sales(source_batch_id=None):
    query = text("""
        INSERT INTO fact_sales(
            order_item_id,
            order_id,
            date_sk,
            customer_sk,
            product_sk,
            quantity,
            unit_price,
            order_status,
            source_batch_id
        )
        SELECT
            oi.order_item_id,
            oi.order_id,
            DATE_FORMAT(o.order_date, '%Y%m%d') + 0,
            dc.customer_sk,
            dp.product_sk,
            oi.quantity,
            oi.unit_price,
            o.status,
            :source_batch_id
        FROM stg_order_items oi
        JOIN stg_orders o
          ON oi.order_id = o.order_id
        JOIN dim_customer dc
          ON dc.customer_id = o.customer_id
         AND dc.is_current = TRUE
        JOIN dim_product dp
          ON dp.product_id = oi.product_id
         AND dp.is_current = TRUE
        WHERE NOT EXISTS (
            SELECT 1
            FROM fact_sales f
            WHERE f.order_item_id = oi.order_item_id
        )
    """)
    with get_target_connection().begin() as connection:
        result = connection.execute(
            query, {"source_batch_id": source_batch_id}
        )
        return result.rowcount or 0

def load_fact_payments(source_batch_id=None):
    query = text("""
        INSERT INTO fact_payments(
            payment_id,
            order_id,
            date_sk,
            customer_sk,
            amount,
            payment_method,
            payment_status,
            source_batch_id
        )
        SELECT
            p.payment_id,
            p.order_id,
            DATE_FORMAT(o.order_date, '%Y%m%d') + 0,
            dc.customer_sk,
            p.amount,
            p.payment_method,
            p.payment_status,
            :source_batch_id
        FROM stg_payments p
        JOIN stg_orders o
          ON p.order_id = o.order_id
        LEFT JOIN dim_customer dc
          ON dc.customer_id = o.customer_id
         AND dc.is_current = TRUE
        WHERE NOT EXISTS (
            SELECT 1
            FROM fact_payments f
            WHERE f.payment_id = p.payment_id
        )
    """)
    with get_target_connection().begin() as connection:
        result = connection.execute(
            query, {"source_batch_id": source_batch_id}
        )
        return result.rowcount or 0

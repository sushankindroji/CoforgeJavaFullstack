import pytest
from sqlalchemy import text


# ============================================================
# SOURCE TABLES
# ============================================================

SOURCE_TABLES = {
    "categories": 8,
    "customers": 20,
    "departments": 5,
    "employees": 15,
    "products": 30,
    "orders": 45,
    "order_items": 110,
    "payments": 38,
}


# ============================================================
# 1. CONNECTION TESTS
# ============================================================

def test_source_connection(source_engine):

    with source_engine.connect() as connection:
        result = connection.execute(
            text("SELECT 1")
        ).scalar()

    assert result == 1


def test_target_connection(target_engine):

    with target_engine.connect() as connection:
        result = connection.execute(
            text("SELECT 1")
        ).scalar()

    assert result == 1


# ============================================================
# 2. SOURCE TABLE TESTS
# ============================================================

@pytest.mark.parametrize(
    "table_name",
    SOURCE_TABLES.keys()
)
def test_source_table_exists(source_engine, table_name):

    query = text("""
        SELECT COUNT(*)
        FROM information_schema.tables
        WHERE table_schema = 'intern_sql_training'
        AND table_name = :table_name
    """)

    with source_engine.connect() as connection:

        count = connection.execute(
            query,
            {"table_name": table_name}
        ).scalar()

    assert count == 1


@pytest.mark.parametrize(
    "table_name,minimum_count",
    SOURCE_TABLES.items()
)
def test_source_row_count(
    source_engine,
    table_name,
    minimum_count
):

    query = text(
        f"SELECT COUNT(*) FROM `{table_name}`"
    )

    with source_engine.connect() as connection:

        count = connection.execute(query).scalar()

    assert count >= minimum_count


# ============================================================
# 3. STAGING TABLE TESTS
# ============================================================

STAGING_TABLES = [
    "stg_categories",
    "stg_customers",
    "stg_departments",
    "stg_employees",
    "stg_products",
    "stg_orders",
    "stg_order_items",
    "stg_payments",
]


@pytest.mark.parametrize(
    "table_name",
    STAGING_TABLES
)
def test_staging_table_exists(
    target_engine,
    table_name
):

    query = text("""
        SELECT COUNT(*)
        FROM information_schema.tables
        WHERE table_schema = 'retail_dw'
        AND table_name = :table_name
    """)

    with target_engine.connect() as connection:

        count = connection.execute(
            query,
            {"table_name": table_name}
        ).scalar()

    assert count == 1


@pytest.mark.parametrize(
    "source_table,staging_table",
    [
        ("categories", "stg_categories"),
        ("customers", "stg_customers"),
        ("departments", "stg_departments"),
        ("employees", "stg_employees"),
        ("products", "stg_products"),
        ("orders", "stg_orders"),
        ("order_items", "stg_order_items"),
        ("payments", "stg_payments"),
    ]
)
def test_source_staging_reconciliation(
    source_engine,
    target_engine,
    source_table,
    staging_table
):

    with source_engine.connect() as source:

        source_count = source.execute(
            text(
                f"SELECT COUNT(*) FROM `{source_table}`"
            )
        ).scalar()

    with target_engine.connect() as target:

        staging_count = target.execute(
            text(
                f"SELECT COUNT(*) FROM `{staging_table}`"
            )
        ).scalar()

    assert staging_count >= source_count


# ============================================================
# 4. STAGING DATA QUALITY
# ============================================================

def test_customer_ids_not_null(target_engine):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM stg_customers
                WHERE customer_id IS NULL
            """)
        ).scalar()

    assert count == 0


def test_product_ids_not_null(target_engine):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM stg_products
                WHERE product_id IS NULL
            """)
        ).scalar()

    assert count == 0


def test_order_ids_not_null(target_engine):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM stg_orders
                WHERE order_id IS NULL
            """)
        ).scalar()

    assert count == 0


def test_order_item_quantity_positive(target_engine):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM stg_order_items
                WHERE quantity <= 0
            """)
        ).scalar()

    assert count == 0


def test_product_price_non_negative(target_engine):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM stg_products
                WHERE unit_price < 0
            """)
        ).scalar()

    assert count == 0


def test_payment_amount_non_negative(target_engine):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM stg_payments
                WHERE amount < 0
            """)
        ).scalar()

    assert count == 0


# ============================================================
# 5. ETL CONTROL TABLE TESTS
# ============================================================

def test_batch_control_exists(target_engine):

    with target_engine.connect() as connection:

        result = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM information_schema.tables
                WHERE table_schema = 'retail_dw'
                AND table_name = 'etl_batch_control'
            """)
        ).scalar()

    assert result == 1


def test_successful_batch_exists(target_engine):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM etl_batch_control
                WHERE status = 'SUCCESS'
            """)
        ).scalar()

    assert count > 0


# ============================================================
# 6. WATERMARK TESTS
# ============================================================

def test_watermark_table_exists(target_engine):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM information_schema.tables
                WHERE table_schema = 'retail_dw'
                AND table_name = 'etl_watermark'
            """)
        ).scalar()

    assert count == 1


def test_customer_watermark_exists(target_engine):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM etl_watermark
                WHERE table_name = 'customers'
            """)
        ).scalar()

    assert count == 1


# ============================================================
# 7. HASH / CHANGE DETECTION
# ============================================================

def test_hash_table_exists(target_engine):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM information_schema.tables
                WHERE table_schema = 'retail_dw'
                AND table_name = 'etl_record_hash'
            """)
        ).scalar()

    assert count == 1


def test_customer_hash_records_exist(target_engine):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM etl_record_hash
                WHERE table_name = 'customers'
            """)
        ).scalar()

    assert count > 0


# ============================================================
# 8. DIMENSION TESTS
# ============================================================

DIMENSION_TABLES = [
    "dim_date",
    "dim_category",
    "dim_customer",
    "dim_product",
    "dim_department",
    "dim_employee",
]


@pytest.mark.parametrize(
    "table_name",
    DIMENSION_TABLES
)
def test_dimension_exists(target_engine, table_name):

    query = text("""
        SELECT COUNT(*)
        FROM information_schema.tables
        WHERE table_schema = 'retail_dw'
        AND table_name = :table_name
    """)

    with target_engine.connect() as connection:

        count = connection.execute(
            query,
            {"table_name": table_name}
        ).scalar()

    assert count == 1


def test_current_customers_exist(target_engine):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM dim_customer
                WHERE is_current = TRUE
            """)
        ).scalar()

    assert count > 0


def test_current_products_exist(target_engine):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM dim_product
                WHERE is_current = TRUE
            """)
        ).scalar()

    assert count > 0


# ============================================================
# 9. SCD TYPE 2 TESTS
# ============================================================

def test_only_one_current_customer_version(target_engine):

    query = text("""
        SELECT customer_id
        FROM dim_customer
        WHERE is_current = TRUE
        GROUP BY customer_id
        HAVING COUNT(*) > 1
    """)

    with target_engine.connect() as connection:

        rows = connection.execute(query).fetchall()

    assert len(rows) == 0


def test_expired_customer_versions_have_end_date(
    target_engine
):

    query = text("""
        SELECT COUNT(*)
        FROM dim_customer
        WHERE is_current = FALSE
        AND effective_to IS NULL
    """)

    with target_engine.connect() as connection:

        count = connection.execute(query).scalar()

    assert count == 0


def test_scd2_customer_versions_have_effective_date(
    target_engine
):

    query = text("""
        SELECT COUNT(*)
        FROM dim_customer
        WHERE effective_from IS NULL
    """)

    with target_engine.connect() as connection:

        count = connection.execute(query).scalar()

    assert count == 0


# ============================================================
# 10. FACT TABLE TESTS
# ============================================================

def test_fact_sales_exists(target_engine):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM information_schema.tables
                WHERE table_schema = 'retail_dw'
                AND table_name = 'fact_sales'
            """)
        ).scalar()

    assert count == 1


def test_fact_payments_exists(target_engine):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM information_schema.tables
                WHERE table_schema = 'retail_dw'
                AND table_name = 'fact_payments'
            """)
        ).scalar()

    assert count == 1


def test_fact_sales_unique_order_items(target_engine):

    query = text("""
        SELECT COUNT(*)
        FROM (
            SELECT order_item_id
            FROM fact_sales
            GROUP BY order_item_id
            HAVING COUNT(*) > 1
        ) x
    """)

    with target_engine.connect() as connection:

        count = connection.execute(query).scalar()

    assert count == 0


def test_fact_payments_unique_payment_ids(
    target_engine
):

    query = text("""
        SELECT COUNT(*)
        FROM (
            SELECT payment_id
            FROM fact_payments
            GROUP BY payment_id
            HAVING COUNT(*) > 1
        ) x
    """)

    with target_engine.connect() as connection:

        count = connection.execute(query).scalar()

    assert count == 0


def test_fact_sales_quantity_positive(target_engine):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM fact_sales
                WHERE quantity <= 0
            """)
        ).scalar()

    assert count == 0


def test_fact_sales_price_non_negative(
    target_engine
):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM fact_sales
                WHERE unit_price < 0
            """)
        ).scalar()

    assert count == 0


def test_fact_payment_amount_non_negative(
    target_engine
):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM fact_payments
                WHERE amount < 0
            """)
        ).scalar()

    assert count == 0


# ============================================================
# 11. FACT REFERENTIAL INTEGRITY
# ============================================================

def test_sales_customer_foreign_keys(target_engine):

    query = text("""
        SELECT COUNT(*)
        FROM fact_sales f
        LEFT JOIN dim_customer c
          ON f.customer_sk = c.customer_sk
        WHERE c.customer_sk IS NULL
    """)

    with target_engine.connect() as connection:

        count = connection.execute(query).scalar()

    assert count == 0


def test_sales_product_foreign_keys(target_engine):

    query = text("""
        SELECT COUNT(*)
        FROM fact_sales f
        LEFT JOIN dim_product p
          ON f.product_sk = p.product_sk
        WHERE p.product_sk IS NULL
    """)

    with target_engine.connect() as connection:

        count = connection.execute(query).scalar()

    assert count == 0


def test_sales_date_foreign_keys(target_engine):

    query = text("""
        SELECT COUNT(*)
        FROM fact_sales f
        LEFT JOIN dim_date d
          ON f.date_sk = d.date_sk
        WHERE d.date_sk IS NULL
    """)

    with target_engine.connect() as connection:

        count = connection.execute(query).scalar()

    assert count == 0


# ============================================================
# 12. RECONCILIATION
# ============================================================

def test_reconciliation_view_exists(target_engine):

    query = text("""
        SELECT COUNT(*)
        FROM information_schema.views
        WHERE table_schema = 'retail_dw'
        AND table_name = 'vw_dw_reconciliation'
    """)

    with target_engine.connect() as connection:

        count = connection.execute(query).scalar()

    assert count == 1


def test_reconciliation_has_no_failures(target_engine):

    query = text("""
        SELECT COUNT(*)
        FROM vw_dw_reconciliation
        WHERE status = 'FAIL'
    """)

    with target_engine.connect() as connection:

        count = connection.execute(query).scalar()

    assert count == 0


# ============================================================
# 13. REPORTING VIEW TESTS
# ============================================================

REPORTING_VIEWS = [
    "vw_sales_report",
    "vw_monthly_sales",
    "vw_customer_sales",
    "vw_product_sales",
    "vw_payment_summary",
]


@pytest.mark.parametrize(
    "view_name",
    REPORTING_VIEWS
)
def test_reporting_view_exists(
    target_engine,
    view_name
):

    query = text("""
        SELECT COUNT(*)
        FROM information_schema.views
        WHERE table_schema = 'retail_dw'
        AND table_name = :view_name
    """)

    with target_engine.connect() as connection:

        count = connection.execute(
            query,
            {"view_name": view_name}
        ).scalar()

    assert count == 1


def test_sales_report_contains_data(target_engine):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM vw_sales_report
            """)
        ).scalar()

    assert count > 0


def test_monthly_sales_contains_data(target_engine):

    with target_engine.connect() as connection:

        count = connection.execute(
            text("""
                SELECT COUNT(*)
                FROM vw_monthly_sales
            """)
        ).scalar()

    assert count > 0


# ============================================================
# 14. BUSINESS TESTS
# ============================================================

def test_sales_amount_is_correct(target_engine):

    query = text("""
        SELECT COUNT(*)
        FROM fact_sales
        WHERE sales_amount <> quantity * unit_price
    """)

    with target_engine.connect() as connection:

        count = connection.execute(query).scalar()

    assert count == 0


def test_total_sales_is_not_negative(target_engine):

    query = text("""
        SELECT COALESCE(SUM(sales_amount), 0)
        FROM fact_sales
    """)

    with target_engine.connect() as connection:

        total = connection.execute(query).scalar()

    assert total >= 0


def test_total_payment_is_not_negative(target_engine):

    query = text("""
        SELECT COALESCE(SUM(amount), 0)
        FROM fact_payments
    """)

    with target_engine.connect() as connection:

        total = connection.execute(query).scalar()

    assert total >= 0

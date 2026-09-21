from load.dw_loader import (
    load_date_dimension,
    scd2_load_dimension,
    load_dim_simple,
    load_fact_sales,
    load_fact_payments,
)
from sqlalchemy import text
from utils.database import get_target_connection

def get_latest_batch_id():
    query = text(
        "SELECT MAX(batch_id) FROM etl_batch_control "
        "WHERE status='SUCCESS'"
    )
    with get_target_connection().connect() as c:
        return c.execute(query).scalar()

def run():
    batch_id = get_latest_batch_id()
    print("=" * 60)
    print("STAGING -> DATA WAREHOUSE")
    print("Source batch:", batch_id)
    print("=" * 60)

    date_rows = load_date_dimension()
    print(f"dim_date inserted: {date_rows}")

    # Simple dimensions
    category_rows = load_dim_simple(
        "categories", "stg_categories",
        "category_id",
        ["category_id", "category_name"],
        "dim_category", "category_id",
        batch_id,
    )
    print(f"dim_category inserted: {category_rows}")

    department_rows = load_dim_simple(
        "departments", "stg_departments",
        "department_id",
        ["department_id", "department_name"],
        "dim_department", "department_id",
        batch_id,
    )
    print(f"dim_department inserted: {department_rows}")

    # SCD Type 2 dimensions
    customer_inserted, customer_expired = scd2_load_dimension(
        "stg_customers",
        "customer_id",
        ["customer_name", "email", "city", "state"],
        "dim_customer",
        ["customer_id", "customer_name", "email", "city", "state"],
        batch_id,
    )
    print(
        f"dim_customer inserted={customer_inserted}, "
        f"expired={customer_expired}"
    )

    product_inserted, product_expired = scd2_load_dimension(
        "stg_products",
        "product_id",
        ["product_name", "category_id", "unit_price"],
        "dim_product",
        ["product_id", "product_name", "category_id", "unit_price"],
        batch_id,
    )
    # Category SK is resolved after insertion for the current product rows.
    with get_target_connection().begin() as connection:
        connection.execute(text("""
            UPDATE dim_product p
            JOIN stg_products s
              ON p.product_id = s.product_id
             AND p.is_current = TRUE
            JOIN dim_category c
              ON c.category_id = s.category_id
             AND c.is_current = TRUE
            SET p.category_sk = c.category_sk
            WHERE p.category_sk IS NULL OR p.category_sk <> c.category_sk
        """))
    print(
        f"dim_product inserted={product_inserted}, "
        f"expired={product_expired}"
    )

    employee_inserted, employee_expired = scd2_load_dimension(
        "stg_employees",
        "employee_id",
        ["employee_name", "department_id", "salary", "manager_id"],
        "dim_employee",
        ["employee_id", "employee_name", "department_id", "salary", "manager_id"],
        batch_id,
    )
    with get_target_connection().begin() as connection:
        connection.execute(text("""
            UPDATE dim_employee e
            JOIN stg_employees s
              ON e.employee_id = s.employee_id
             AND e.is_current = TRUE
            JOIN dim_department d
              ON d.department_id = s.department_id
             AND d.is_current = TRUE
            SET e.department_sk = d.department_sk
            WHERE e.department_sk IS NULL OR e.department_sk <> d.department_sk
        """))
    print(
        f"dim_employee inserted={employee_inserted}, "
        f"expired={employee_expired}"
    )

    sales_rows = load_fact_sales(batch_id)
    print(f"fact_sales inserted: {sales_rows}")

    payment_rows = load_fact_payments(batch_id)
    print(f"fact_payments inserted: {payment_rows}")

    print("=" * 60)
    print("DW LOAD COMPLETED")
    print("=" * 60)

if __name__ == "__main__":
    run()

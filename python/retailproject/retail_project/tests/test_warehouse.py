from sqlalchemy import text

def test_required_dw_tables_exist(target_engine):
    required = [
        "dim_date",
        "dim_category",
        "dim_customer",
        "dim_product",
        "dim_department",
        "dim_employee",
        "fact_sales",
        "fact_payments",
    ]

    with target_engine.connect() as c:
        for table in required:
            exists = c.execute(
                text("""
                    SELECT COUNT(*)
                    FROM information_schema.tables
                    WHERE table_schema='retail_dw'
                      AND table_name=:table_name
                """),
                {"table_name": table},
            ).scalar()
            assert exists == 1

def test_fact_sales_unique_order_items(target_engine):
    with target_engine.connect() as c:
        duplicate_count = c.execute(text("""
            SELECT COUNT(*)
            FROM (
                SELECT order_item_id
                FROM fact_sales
                GROUP BY order_item_id
                HAVING COUNT(*) > 1
            ) x
        """)).scalar()
        assert duplicate_count == 0

def test_fact_payments_unique_payment_ids(target_engine):
    with target_engine.connect() as c:
        duplicate_count = c.execute(text("""
            SELECT COUNT(*)
            FROM (
                SELECT payment_id
                FROM fact_payments
                GROUP BY payment_id
                HAVING COUNT(*) > 1
            ) x
        """)).scalar()
        assert duplicate_count == 0

def test_reconciliation_view(target_engine):
    with target_engine.connect() as c:
        failed = c.execute(text("""
            SELECT COUNT(*)
            FROM vw_dw_reconciliation
            WHERE status='FAIL'
        """)).scalar()
        assert failed == 0

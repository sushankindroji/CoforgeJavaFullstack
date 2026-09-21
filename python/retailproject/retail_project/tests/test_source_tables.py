from sqlalchemy import text

EXPECTED = {
    "categories": 8,
    "customers": 20,
    "departments": 5,
    "employees": 15,
    "products": 30,
    "orders": 45,
    "order_items": 110,
    "payments": 38,
}

def test_source_tables_exist(source_engine):
    with source_engine.connect() as c:
        for table in EXPECTED:
            exists = c.execute(
                text("""
                    SELECT COUNT(*)
                    FROM information_schema.tables
                    WHERE table_schema='intern_sql_training'
                      AND table_name=:table_name
                """),
                {"table_name": table},
            ).scalar()
            assert exists == 1

def test_source_counts_are_at_least_baseline(source_engine):
    with source_engine.connect() as c:
        for table, expected in EXPECTED.items():
            actual = c.execute(
                text(f"SELECT COUNT(*) FROM `{table}`")
            ).scalar()
            assert actual >= expected

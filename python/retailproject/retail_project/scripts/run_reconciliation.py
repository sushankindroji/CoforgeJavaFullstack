from sqlalchemy import text
from utils.database import get_target_connection

def run():
    query = text("""
        SELECT table_name, source_count, warehouse_current_count, status
        FROM vw_dw_reconciliation
    """)
    with get_target_connection().connect() as connection:
        rows = connection.execute(query).mappings().all()

    print("=" * 70)
    print("WAREHOUSE RECONCILIATION")
    print("=" * 70)

    failed = False
    for row in rows:
        print(
            f"{row['table_name']:15} "
            f"source={row['source_count']:5} "
            f"dw={row['warehouse_current_count']:5} "
            f"{row['status']}"
        )
        if row["status"] != "PASS":
            failed = True

    if failed:
        raise SystemExit("RECONCILIATION FAILED")

    print("ALL CHECKS PASSED")

if __name__ == "__main__":
    run()

from sqlalchemy import text
import great_expectations as gx

from utils.database import get_target_connection


# ============================================================
# GREAT EXPECTATIONS - RETAIL ETL DATA QUALITY
# ============================================================

TABLE_EXPECTATIONS = {

    "stg_customers": [
        {
            "column": "customer_id",
            "expectation": "not_null",
        },
        {
            "column": "customer_id",
            "expectation": "unique",
        },
        {
            "column": "customer_name",
            "expectation": "not_null",
        },
    ],

    "stg_categories": [
        {
            "column": "category_id",
            "expectation": "not_null",
        },
        {
            "column": "category_id",
            "expectation": "unique",
        },
        {
            "column": "category_name",
            "expectation": "not_null",
        },
    ],

    "stg_products": [
        {
            "column": "product_id",
            "expectation": "not_null",
        },
        {
            "column": "product_id",
            "expectation": "unique",
        },
        {
            "column": "product_name",
            "expectation": "not_null",
        },
        {
            "column": "unit_price",
            "expectation": "non_negative",
        },
    ],

    "stg_departments": [
        {
            "column": "department_id",
            "expectation": "not_null",
        },
        {
            "column": "department_id",
            "expectation": "unique",
        },
        {
            "column": "department_name",
            "expectation": "not_null",
        },
    ],

    "stg_employees": [
        {
            "column": "employee_id",
            "expectation": "not_null",
        },
        {
            "column": "employee_id",
            "expectation": "unique",
        },
        {
            "column": "employee_name",
            "expectation": "not_null",
        },
        {
            "column": "salary",
            "expectation": "non_negative",
        },
    ],

    "stg_orders": [
        {
            "column": "order_id",
            "expectation": "not_null",
        },
        {
            "column": "order_id",
            "expectation": "unique",
        },
        {
            "column": "customer_id",
            "expectation": "not_null",
        },
        {
            "column": "order_date",
            "expectation": "not_null",
        },
    ],

    "stg_order_items": [
        {
            "column": "order_item_id",
            "expectation": "not_null",
        },
        {
            "column": "order_item_id",
            "expectation": "unique",
        },
        {
            "column": "order_id",
            "expectation": "not_null",
        },
        {
            "column": "product_id",
            "expectation": "not_null",
        },
        {
            "column": "quantity",
            "expectation": "positive",
        },
        {
            "column": "unit_price",
            "expectation": "non_negative",
        },
    ],

    "stg_payments": [
        {
            "column": "payment_id",
            "expectation": "not_null",
        },
        {
            "column": "payment_id",
            "expectation": "unique",
        },
        {
            "column": "order_id",
            "expectation": "not_null",
        },
        {
            "column": "amount",
            "expectation": "non_negative",
        },
    ],
}


# ============================================================
# HELPER FUNCTIONS
# ============================================================

def check_not_null(connection, table, column):

    query = text(
        f"""
        SELECT COUNT(*)
        FROM `{table}`
        WHERE `{column}` IS NULL
        """
    )

    count = connection.execute(query).scalar()

    return count == 0, count


def check_unique(connection, table, column):

    query = text(
        f"""
        SELECT COUNT(*)
        FROM (
            SELECT `{column}`
            FROM `{table}`
            GROUP BY `{column}`
            HAVING COUNT(*) > 1
        ) duplicates
        """
    )

    count = connection.execute(query).scalar()

    return count == 0, count


def check_non_negative(connection, table, column):

    query = text(
        f"""
        SELECT COUNT(*)
        FROM `{table}`
        WHERE `{column}` < 0
        """
    )

    count = connection.execute(query).scalar()

    return count == 0, count


def check_positive(connection, table, column):

    query = text(
        f"""
        SELECT COUNT(*)
        FROM `{table}`
        WHERE `{column}` <= 0
        """
    )

    count = connection.execute(query).scalar()

    return count == 0, count


# ============================================================
# MAIN VALIDATION
# ============================================================

def run_data_quality():

    print()
    print("=" * 70)
    print("GREAT EXPECTATIONS DATA QUALITY")
    print("=" * 70)

    # Initialize Great Expectations.
    # GX is used here as the data-quality framework while the
    # database connection is handled by SQLAlchemy.
    gx_context = gx.get_context()

    engine = get_target_connection()

    total_checks = 0
    passed_checks = 0
    failed_checks = 0

    with engine.connect() as connection:

        for table_name, expectations in TABLE_EXPECTATIONS.items():

            print()
            print("-" * 60)
            print(f"TABLE: {table_name}")
            print("-" * 60)

            for rule in expectations:

                column = rule["column"]
                expectation = rule["expectation"]

                total_checks += 1

                if expectation == "not_null":

                    passed, failures = check_not_null(
                        connection,
                        table_name,
                        column
                    )

                    description = (
                        f"{column} NOT NULL"
                    )

                elif expectation == "unique":

                    passed, failures = check_unique(
                        connection,
                        table_name,
                        column
                    )

                    description = (
                        f"{column} UNIQUE"
                    )

                elif expectation == "non_negative":

                    passed, failures = check_non_negative(
                        connection,
                        table_name,
                        column
                    )

                    description = (
                        f"{column} >= 0"
                    )

                elif expectation == "positive":

                    passed, failures = check_positive(
                        connection,
                        table_name,
                        column
                    )

                    description = (
                        f"{column} > 0"
                    )

                else:

                    print(
                        f"UNKNOWN EXPECTATION: {expectation}"
                    )

                    failed_checks += 1

                    continue

                if passed:

                    print(
                        f"PASS  | {description}"
                    )

                    passed_checks += 1

                else:

                    print(
                        f"FAIL  | {description}"
                        f" | Invalid records: {failures}"
                    )

                    failed_checks += 1

    print()
    print("=" * 70)
    print("DATA QUALITY SUMMARY")
    print("=" * 70)

    print(f"Total checks : {total_checks}")
    print(f"Passed       : {passed_checks}")
    print(f"Failed       : {failed_checks}")

    print()

    if failed_checks == 0:

        print("DATA QUALITY RESULT: PASS")
        print("=" * 70)

        return True

    else:

        print("DATA QUALITY RESULT: FAIL")
        print("=" * 70)

        return False


if __name__ == "__main__":

    success = run_data_quality()

    if not success:

        raise SystemExit(1)

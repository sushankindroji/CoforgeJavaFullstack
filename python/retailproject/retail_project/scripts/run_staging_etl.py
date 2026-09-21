import traceback
from sqlalchemy import text

from config.table_config import TABLE_CONFIG
from extract.extractor import extract_table
from utils.database import get_target_connection
from utils.batch import create_batch, update_batch_status
from utils.metadata import add_metadata, update_etl_metadata
import pandas as pd


def load_to_staging(df, staging_table, batch_id):
    """
    Load a DataFrame into the target staging table.
    """

    df = add_metadata(df, batch_id)

    columns = list(df.columns)

    column_names = ", ".join(f"`{c}`" for c in columns)
    parameter_names = ", ".join(f":{c}" for c in columns)

    query = text(
        f"""
        INSERT INTO `{staging_table}`
        ({column_names})
        VALUES ({parameter_names})
        """
    )
    df = df.astype(object).where(pd.notna(df), None)

    records = df.to_dict(orient="records")

    engine = get_target_connection()

    with engine.begin() as connection:
        connection.execute(query, records)

    return len(records)


def run():

    print("=" * 70)
    print("RETAIL SOURCE -> STAGING ETL")
    print("=" * 70)

    batch_id = create_batch("SOURCE_TO_STAGING")

    print(f"Batch ID: {batch_id}")
    print()

    total_records = 0

    try:

        for config in TABLE_CONFIG:

            source_table = config["source_table"]
            staging_table = config["staging_table"]

            print("-" * 60)
            print(f"Processing: {source_table}")
            print(f"Staging   : {staging_table}")

            # Extract
            df = extract_table(source_table)

            print(f"Source records: {len(df)}")

            if df.empty:
                print("No records found.")
                continue

            # Load
            loaded = load_to_staging(
                df,
                staging_table,
                batch_id
            )

            print(f"Loaded records: {loaded}")

            # Update ETL watermark and record hashes
            with get_target_connection().begin() as connection:
                update_etl_metadata(
                    connection=connection,
                    df=df,
                    source_table=source_table,
                    primary_key=config["primary_key"],
                    watermark_column=config["watermark_column"],
                    batch_id=batch_id,
                )

            total_records += loaded

        update_batch_status(
            batch_id=batch_id,
            status="SUCCESS",
            records_processed=total_records
        )

        print()
        print("=" * 70)
        print("ETL COMPLETED SUCCESSFULLY")
        print(f"Batch ID      : {batch_id}")
        print(f"Total records : {total_records}")
        print("=" * 70)

    except Exception as exc:

        error_message = str(exc)

        print()
        print("=" * 70)
        print("ETL FAILED")
        print(f"Batch ID : {batch_id}")
        print(f"Error    : {error_message}")
        print("=" * 70)

        update_batch_status(
            batch_id=batch_id,
            status="FAILED",
            records_processed=total_records,
            error_message=error_message
        )

        traceback.print_exc()

        raise


if __name__ == "__main__":
    run()

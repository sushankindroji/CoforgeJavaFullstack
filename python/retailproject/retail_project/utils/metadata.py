from datetime import datetime
import hashlib
import json

from sqlalchemy import text


def add_metadata(df, batch_id):
    result = df.copy()
    result["etl_batch_id"] = batch_id
    result["etl_loaded_at"] = datetime.now()
    return result


def update_etl_metadata(
    connection,
    df,
    source_table,
    primary_key,
    watermark_column,
    batch_id,
):
    if df.empty:
        return

    hash_sql = text("""
        INSERT INTO etl_record_hash
            (table_name, record_key, row_hash, batch_id)
        VALUES
            (:table_name, :record_key, :row_hash, :batch_id)
        ON DUPLICATE KEY UPDATE
            row_hash = VALUES(row_hash),
            batch_id = VALUES(batch_id),
            updated_at = CURRENT_TIMESTAMP
    """)

    hash_records = []

    for _, row in df.iterrows():
        record = {}

        for column in df.columns:
            value = row[column]

            if hasattr(value, "isoformat"):
                value = value.isoformat()
            elif value is not None:
                value = str(value)

            record[column] = value

        payload = json.dumps(
            record,
            sort_keys=True,
            default=str,
        )

        row_hash = hashlib.sha256(
            payload.encode("utf-8")
        ).hexdigest()

        hash_records.append({
            "table_name": source_table,
            "record_key": str(row[primary_key]),
            "row_hash": row_hash,
            "batch_id": batch_id,
        })

    connection.execute(hash_sql, hash_records)

    watermark = df[watermark_column].max()

    if watermark is not None:
        watermark_sql = text("""
            INSERT INTO etl_watermark
                (table_name, last_watermark, batch_id)
            VALUES
                (:table_name, :last_watermark, :batch_id)
            ON DUPLICATE KEY UPDATE
                last_watermark = GREATEST(
                    last_watermark,
                    VALUES(last_watermark)
                ),
                batch_id = VALUES(batch_id),
                updated_at = CURRENT_TIMESTAMP
        """)

        connection.execute(
            watermark_sql,
            {
                "table_name": source_table,
                "last_watermark": int(watermark),
                "batch_id": batch_id,
            },
        )

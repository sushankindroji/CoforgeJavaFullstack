from sqlalchemy import text
from utils.database import get_target_connection
from utils.hash_utils import generate_row_hash

def get_existing_hash(table_name, record_key):
    query = text(
        "SELECT row_hash FROM etl_record_hash "
        "WHERE table_name=:table_name AND record_key=:record_key"
    )
    with get_target_connection().connect() as connection:
        row = connection.execute(
            query,
            {"table_name": table_name, "record_key": str(record_key)},
        ).fetchone()
    return None if row is None else row[0]

def detect_change(table_name, record_key, current_hash):
    previous_hash = get_existing_hash(table_name, record_key)
    if previous_hash is None:
        return "NEW"
    return "CHANGED" if previous_hash != current_hash else "UNCHANGED"

def save_hash(table_name, record_key, row_hash, batch_id):
    query = text(
        "INSERT INTO etl_record_hash("
        "table_name,record_key,row_hash,batch_id)"
        "VALUES(:table_name,:record_key,:row_hash,:batch_id)"
        "ON DUPLICATE KEY UPDATE "
        "row_hash=VALUES(row_hash), "
        "batch_id=VALUES(batch_id), "
        "updated_at=CURRENT_TIMESTAMP"
    )
    with get_target_connection().begin() as connection:
        connection.execute(
            query,
            {
                "table_name": table_name,
                "record_key": str(record_key),
                "row_hash": row_hash,
                "batch_id": batch_id,
            },
        )

def classify_dataframe(df, table_name, key_column, hash_columns):
    results = []
    for _, row in df.iterrows():
        key = row[key_column]
        row_hash = generate_row_hash(row, hash_columns)
        results.append(
            {
                "record_key": key,
                "row_hash": row_hash,
                "status": detect_change(
                    table_name, key, row_hash
                ),
            }
        )
    return results

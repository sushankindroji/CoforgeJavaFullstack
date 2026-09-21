from sqlalchemy import text
from utils.database import get_target_connection

def get_watermark(table_name):
    query = text(
        "SELECT last_watermark FROM etl_watermark "
        "WHERE table_name=:table_name"
    )
    with get_target_connection().connect() as connection:
        row = connection.execute(
            query, {"table_name": table_name}
        ).fetchone()
    return None if row is None else row[0]

def update_watermark(table_name, watermark_value, batch_id):
    query = text(
        "INSERT INTO etl_watermark(table_name,last_watermark,batch_id) "
        "VALUES(:table_name,:watermark_value,:batch_id) "
        "ON DUPLICATE KEY UPDATE "
        "last_watermark=VALUES(last_watermark), "
        "batch_id=VALUES(batch_id), "
        "updated_at=CURRENT_TIMESTAMP"
    )
    with get_target_connection().begin() as connection:
        connection.execute(
            query,
            {
                "table_name": table_name,
                "watermark_value": watermark_value,
                "batch_id": batch_id,
            },
        )

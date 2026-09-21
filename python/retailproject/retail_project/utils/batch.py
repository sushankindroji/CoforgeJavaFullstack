from sqlalchemy import text
from utils.database import get_target_connection

def create_batch(pipeline_name):
    query = text(
        "INSERT INTO etl_batch_control(pipeline_name,status) "
        "VALUES(:pipeline_name,'RUNNING')"
    )
    with get_target_connection().begin() as connection:
        return connection.execute(
            query, {"pipeline_name": pipeline_name}
        ).lastrowid

def update_batch_status(
    batch_id,
    status,
    records_processed=0,
    error_message=None,
):
    query = text(
        "UPDATE etl_batch_control "
        "SET status=:status, records_processed=:records_processed, "
        "error_message=:error_message, end_time=CURRENT_TIMESTAMP "
        "WHERE batch_id=:batch_id"
    )
    with get_target_connection().begin() as connection:
        connection.execute(
            query,
            {
                "batch_id": batch_id,
                "status": status,
                "records_processed": records_processed,
                "error_message": error_message,
            },
        )

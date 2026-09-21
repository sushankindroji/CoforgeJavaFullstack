import pandas as pd
from sqlalchemy import text
from utils.database import get_source_connection

def extract_table(source_table):
    query = text(f"SELECT * FROM `{source_table}`")
    return pd.read_sql(query, get_source_connection())

def extract_incremental(
    source_table,
    watermark_column,
    last_watermark,
):
    query = text(
        f"SELECT * FROM `{source_table}` "
        f"WHERE `{watermark_column}` > :last_watermark "
        f"ORDER BY `{watermark_column}`"
    )
    return pd.read_sql(
        query,
        get_source_connection(),
        params={"last_watermark": last_watermark},
    )

def extract_all_for_change_detection(source_table):
    return extract_table(source_table)

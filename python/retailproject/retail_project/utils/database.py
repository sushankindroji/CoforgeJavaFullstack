from sqlalchemy import create_engine
from config.settings import SOURCE_DB_URL, TARGET_DB_URL

_source_engine = None
_target_engine = None


def get_source_connection():
    global _source_engine
    if _source_engine is None:
        _source_engine = create_engine(SOURCE_DB_URL, pool_pre_ping=True)
    return _source_engine


def get_target_connection():
    global _target_engine
    if _target_engine is None:
        _target_engine = create_engine(TARGET_DB_URL, pool_pre_ping=True)
    return _target_engine

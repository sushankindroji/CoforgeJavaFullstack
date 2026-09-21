import pytest
from utils.database import get_source_connection, get_target_connection

@pytest.fixture(scope="session")
def source_engine():
    return get_source_connection()

@pytest.fixture(scope="session")
def target_engine():
    return get_target_connection()

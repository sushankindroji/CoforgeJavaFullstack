from sqlalchemy import text


def test_source_connection(source_engine):
    with source_engine.connect() as c:
        assert c.execute(text("SELECT 1")).scalar() == 1


def test_target_connection(target_engine):
    with target_engine.connect() as c:
        assert c.execute(text("SELECT 1")).scalar() == 1

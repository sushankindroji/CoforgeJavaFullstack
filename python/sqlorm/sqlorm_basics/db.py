from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker

DATABASE_URL = "mysql+pymysql://root:root@localhost:3306/sql_orm"

engine = create_engine(DATABASE_URL, echo=True)

Sessionlocal = sessionmaker(bind=engine, expire_on_commit=False)

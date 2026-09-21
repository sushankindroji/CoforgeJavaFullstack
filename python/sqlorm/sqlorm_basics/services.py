from models import User
from db import Sessionlocal
from sqlalchemy import select

# Insert Data


def create_user(name: str, email: str):
    with Sessionlocal() as session:
        user = User(name=name, email=email)
        session.add(user)
        session.commit()

# Fetch single user


def get_single_user(user_id: int):
    with Sessionlocal() as session:
        user = session.get(User, user_id)
        return user


# Get all Users
def get_all_users():
    with Sessionlocal() as session:
        stmt = select(User)
        users = session.scalars(stmt).all()
        return users

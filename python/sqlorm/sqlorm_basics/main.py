from models import create_table
from services import create_user, get_single_user, get_all_users
from sqlalchemy.exc import IntegrityError

# Create Table
create_table()

# Insert data (skip if email already exists)
users_to_create = [
    ("chandu", "chandu.purna@gmail.com"),
    ("ravi", "ravi@gmail.com"),
]

for name, email in users_to_create:
    try:
        create_user(name, email)
        print(f"Created user: {name}")
    except IntegrityError:
        print(f"User with email '{email}' already exists, skipping.")

# Fetch a single user by ID
print("\n--- Single User (id=1) ---")
print(get_single_user(1))

# Fetch all users
print("\n--- All Users ---")
for user in get_all_users():
    print(user)

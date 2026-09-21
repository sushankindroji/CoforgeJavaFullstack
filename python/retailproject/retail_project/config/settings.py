import os
from dotenv import load_dotenv

load_dotenv()

SOURCE_DB_URL = os.getenv("SOURCE_DB_URL")
TARGET_DB_URL = os.getenv("TARGET_DB_URL")

if not SOURCE_DB_URL:
    raise RuntimeError("SOURCE_DB_URL is missing from .env")

if not TARGET_DB_URL:
    raise RuntimeError("TARGET_DB_URL is missing from .env")

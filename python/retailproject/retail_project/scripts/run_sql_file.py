import sys
from pathlib import Path
from sqlalchemy import text
from utils.database import get_target_connection

def split_sql(sql_text):
    statements = []
    current = []
    for line in sql_text.splitlines():
        if line.strip().startswith("--"):
            continue
        current.append(line)
        if line.rstrip().endswith(";"):
            statement = "\n".join(current).strip()
            if statement:
                statements.append(statement[:-1])
            current = []
    tail = "\n".join(current).strip()
    if tail:
        statements.append(tail)
    return statements

def main():
    if len(sys.argv) != 2:
        raise SystemExit("Usage: python scripts/run_sql_file.py sql/file.sql")

    path = Path(sys.argv[1])
    sql = path.read_text(encoding="utf-8")
    statements = split_sql(sql)

    with get_target_connection().begin() as connection:
        for i, statement in enumerate(statements, 1):
            print(f"Executing statement {i}/{len(statements)}")
            connection.execute(text(statement))

    print(f"Completed: {path}")

if __name__ == "__main__":
    main()

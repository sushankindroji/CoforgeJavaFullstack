import hashlib

def generate_row_hash(row, columns):
    values = []
    for column in columns:
        value = row[column]
        if value is None:
            value = ""
        values.append(str(value))
    return hashlib.sha256("|".join(values).encode("utf-8")).hexdigest()

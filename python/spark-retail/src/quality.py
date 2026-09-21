from pyspark.sql import functions as F

def required_columns(df, required):
    return [c for c in required if c not in df.columns]

def duplicate_key_count(df, key):
    return df.groupBy(key).count().filter(F.col("count") > 1).count()

def null_count(df, column):
    return df.filter(F.col(column).isNull()).count()

def run_quality_report(customers, products, orders):
    return {
        "customers_rows": customers.count(),
        "products_rows": products.count(),
        "orders_rows": orders.count(),
        "customer_missing_columns": required_columns(
            customers, ["customer_id","customer_name","email","city","state"]),
        "product_missing_columns": required_columns(
            products, ["product_id","product_name","category","unit_price"]),
        "order_missing_columns": required_columns(
            orders, ["order_id","customer_id","product_id","order_date","quantity","unit_price"]),
        "duplicate_customer_keys": duplicate_key_count(customers, "customer_id"),
        "null_customer_email": null_count(customers, "email"),
        "null_customer_city": null_count(customers, "city"),
        "invalid_order_quantity": orders.filter(F.col("quantity") <= 0).count(),
        "invalid_order_price": orders.filter(F.col("unit_price") <= 0).count(),
    }

def assert_no_missing_columns(report):
    bad = {k:v for k,v in report.items() if k.endswith("missing_columns") and v}
    if bad:
        raise ValueError(f"Missing required columns: {bad}")

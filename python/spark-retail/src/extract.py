from pathlib import Path
from .schemas import CUSTOMER_SCHEMA, PRODUCT_SCHEMA, ORDER_SCHEMA

def read_csv(spark, path, schema):
    return (spark.read.option("header", True)
            .option("mode", "PERMISSIVE")
            .schema(schema)
            .csv(path))

def extract_all(spark, data_dir):
    d = Path(data_dir)
    return (
        read_csv(spark, str(d/"customers.csv"), CUSTOMER_SCHEMA),
        read_csv(spark, str(d/"products.csv"), PRODUCT_SCHEMA),
        read_csv(spark, str(d/"orders.csv"), ORDER_SCHEMA),
    )

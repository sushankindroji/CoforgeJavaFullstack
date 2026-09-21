from pyspark.sql import functions as F

def clean_customers(df):
    return (df.dropDuplicates(["customer_id"])
            .withColumn("customer_name", F.trim("customer_name"))
            .withColumn("email", F.lower(F.trim("email")))
            .withColumn("city", F.trim("city"))
            .withColumn("state", F.trim("state"))
            .fillna({"city":"UNKNOWN"}))

def clean_products(df):
    return (df.dropDuplicates(["product_id"])
            .withColumn("product_name", F.trim("product_name"))
            .withColumn("category", F.trim("category"))
            .filter(F.col("unit_price") > 0))

def clean_orders(df):
    return (df.dropDuplicates(["order_id"])
            .withColumn("order_date", F.try_to_date(F.col("order_date"), "yyyy-MM-dd"))
            .filter(F.col("order_date").isNotNull())
            .filter(F.col("quantity") > 0)
            .filter(F.col("unit_price") > 0)
            .withColumn("order_amount", F.col("quantity") * F.col("unit_price")))

def build_silver(customers, products, orders):
    c, p, o = clean_customers(customers), clean_products(products), clean_orders(orders)
    valid_orders = (o.join(c.select("customer_id"), "customer_id", "inner")
                     .join(p.select("product_id"), "product_id", "inner"))
    enriched = (valid_orders
                .join(c, "customer_id", "left")
                .join(p.drop("unit_price"), "product_id", "left"))
    return c, p, enriched

def build_gold(enriched):
    customer_sales = (enriched.groupBy("customer_id","customer_name","city","state")
        .agg(F.countDistinct("order_id").alias("order_count"),
             F.sum("quantity").alias("units"),
             F.round(F.sum("order_amount"),2).alias("total_sales"),
             F.round(F.avg("order_amount"),2).alias("avg_order_value"))
        .orderBy(F.desc("total_sales")))
    product_sales = (enriched.groupBy("product_id","product_name","category")
        .agg(F.sum("quantity").alias("units_sold"),
             F.round(F.sum("order_amount"),2).alias("total_sales"))
        .orderBy(F.desc("total_sales")))
    daily_sales = (enriched.groupBy("order_date")
        .agg(F.countDistinct("order_id").alias("order_count"),
             F.sum("quantity").alias("units_sold"),
             F.round(F.sum("order_amount"),2).alias("total_sales"))
        .orderBy("order_date"))
    return customer_sales, product_sales, daily_sales, customer_sales.limit(10), product_sales.limit(10)

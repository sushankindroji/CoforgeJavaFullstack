from pyspark.sql import SparkSession

def create_spark(app_name="RetailSparkETL"):
    builder = (
        SparkSession.builder
        .appName(app_name)
        .master("local[*]")
        .config("spark.sql.shuffle.partitions", "4")
        .config("spark.sql.adaptive.enabled", "true")
        .config("spark.sql.extensions", "io.delta.sql.DeltaSparkSessionExtension")
        .config("spark.sql.catalog.spark_catalog", "org.apache.spark.sql.delta.catalog.DeltaCatalog")
    )
    try:
        from delta import configure_spark_with_delta_pip
        return configure_spark_with_delta_pip(builder).getOrCreate()
    except ImportError:
        return builder.getOrCreate()

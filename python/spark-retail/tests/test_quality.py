from pathlib import Path
from src.spark_session import create_spark
from src.extract import extract_all
from src.quality import run_quality_report

ROOT = Path(__file__).resolve().parents[1]

def test_quality_rules():
    spark = create_spark("QualityTest")
    try:
        c,p,o = extract_all(spark, str(ROOT/"data"))
        r = run_quality_report(c,p,o)
        assert r["customer_missing_columns"] == []
        assert r["order_missing_columns"] == []
        assert r["duplicate_customer_keys"] == 1
        assert r["invalid_order_quantity"] == 1
        assert r["invalid_order_price"] == 1
    finally:
        spark.stop()

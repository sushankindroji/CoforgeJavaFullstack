from pathlib import Path
import json
from .spark_session import create_spark
from .extract import extract_all
from .quality import run_quality_report, assert_no_missing_columns
from .transform import build_silver, build_gold
from .load import write_layer

ROOT = Path(__file__).resolve().parents[1]
DATA = ROOT/"data"
LAKE = ROOT/"lake"
REPORTS = ROOT/"reports"

def main():
    spark = create_spark()
    try:
        print("=== EXTRACT ===")
        customers, products, orders = extract_all(spark, str(DATA))
        customers.printSchema(); products.printSchema(); orders.printSchema()

        print("=== VALIDATE ===")
        report = run_quality_report(customers, products, orders)
        for k,v in report.items(): print(f"{k}: {v}")
        assert_no_missing_columns(report)

        print("=== BRONZE ===")
        write_layer(str(LAKE), "bronze",
                    {"customers":customers, "products":products, "orders":orders})

        print("=== SILVER ===")
        sc, sp, so = build_silver(customers, products, orders)
        so.show(10, truncate=False)
        write_layer(str(LAKE), "silver",
                    {"customers":sc, "products":sp, "orders":so})

        print("=== GOLD ===")
        cs, ps, ds, tc, tp = build_gold(so)
        cs.show(10, truncate=False)
        ps.show(10, truncate=False)
        ds.show(20, truncate=False)
        write_layer(str(LAKE), "gold",
                    {"customer_sales":cs, "product_sales":ps, "daily_sales":ds,
                     "top_customers":tc, "top_products":tp})

        REPORTS.mkdir(exist_ok=True)
        (REPORTS/"quality_report.json").write_text(json.dumps(report, indent=2),
                                                    encoding="utf-8")
        print("=== PIPELINE COMPLETED ===")
    finally:
        spark.stop()

if __name__ == "__main__":
    main()

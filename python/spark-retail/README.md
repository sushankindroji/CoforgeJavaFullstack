# PySpark Retail ETL + Delta Lake

## Objective

Build a hands-on retail ETL pipeline:

CSV → Extract → Validate → Bronze → Silver → Gold → Delta Lake

## Source files

- customers.csv
- products.csv
- orders.csv

The data intentionally contains quality issues:
duplicate customer, missing email/city, unknown customer/product,
invalid quantity, invalid price, and invalid date.

## Setup

Create/select your VS Code Python interpreter, then:

```bash
python -m venv .venv
```

Activate it and install:

```bash
python -m pip install -r requirements.txt
```

Verify:

```bash
python -c "import pyspark; print(pyspark.__version__)"
python -c "import delta; print('Delta Lake OK')"
```

## Run

From the project root:

```bash
python run_pipeline.py
```

Output:

```text
lake/
  bronze/
  silver/
  gold/
reports/
  quality_report.json
```

## Pipeline responsibilities

### Extract
Read all CSV files with explicit Spark schemas.

### Validate
Check required columns, nulls, duplicate keys and invalid business values.

### Bronze
Persist source-shaped data to Delta for traceability/replay.

### Silver
Clean, standardize, deduplicate, validate dates, reject invalid measures,
enforce customer/product referential integrity, and enrich orders.

### Gold
Create:
- customer_sales
- product_sales
- daily_sales
- top_customers
- top_products

## Run tests

```bash
pytest -q
```


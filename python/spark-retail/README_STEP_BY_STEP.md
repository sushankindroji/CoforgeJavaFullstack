# PySpark Retail ETL + Delta Lake
## Step-by-Step Understanding and Execution Guide

This project is designed as a beginner-friendly hands-on project for learning:

**PySpark → Data Quality → Bronze/Silver/Gold → Delta Lake → Testing**

---

# 1. What are we building?

We have three source CSV files:

```text
customers.csv
products.csv
orders.csv
```

We will build this pipeline:

```text
                    SOURCE
          +-----------+-----------+
          |           |           |
     customers     products     orders
          |           |           |
          +-----------+-----------+
                      |
                      v
                  EXTRACT
                      |
                      v
                  VALIDATE
                      |
                      v
              BRONZE / DELTA
                      |
                      v
              SILVER / DELTA
          Clean + Standardize
          Deduplicate + Validate
          Join + Enrich
                      |
                      v
               GOLD / DELTA
          Business Aggregations
                      |
          +-----------+-----------+
          |           |           |
     customer_sales product_sales daily_sales
```

---

# 2. Prerequisites

You need:

- Python 3
- VS Code
- Python extension for VS Code
- Java compatible with your installed Spark version
- PySpark
- Delta Lake package

Since you are using Python as the VS Code interpreter, make sure VS Code selects the same Python environment where PySpark is installed.

---

# 3. Open the project in VS Code

Extract the ZIP file.

Open the folder:

```text
pyspark_retail_etl_project
```

in VS Code.

You should see:

```text
data/
src/
tests/
lake/
run_pipeline.py
requirements.txt
README.md
README_STEP_BY_STEP.md
```

---

# 4. Select the Python interpreter

In VS Code:

```text
Ctrl + Shift + P
```

Choose:

```text
Python: Select Interpreter
```

Select your Python environment.

If you are using a virtual environment, it will normally look like:

```text
.venv/bin/python
```

on Linux/macOS, or:

```text
.venv\Scripts\python.exe
```

on Windows.

---

# 5. Open the VS Code terminal

Use:

```text
Terminal → New Terminal
```

Then check:

```bash
python --version
```

Check the Python executable:

```bash
python -c "import sys; print(sys.executable)"
```

---

# 6. Create a virtual environment

If you do not already have one:

```bash
python -m venv .venv
```

Activate it.

## Linux/macOS

```bash
source .venv/bin/activate
```

## Windows PowerShell

```powershell
.venv\Scripts\Activate.ps1
```

## Windows CMD

```cmd
.venv\Scripts\activate
```

After activation, your terminal should show something similar to:

```text
(.venv)
```

---

# 7. Install project dependencies

Run:

```bash
python -m pip install -r requirements.txt
```

The project requires:

```text
pyspark
delta-spark
pytest
```

---

# 8. Verify PySpark

Run:

```bash
python -c "import pyspark; print(pyspark.__version__)"
```

You should get a Spark/PySpark version.

Then:

```bash
python -c "from pyspark.sql import SparkSession; print('PySpark SQL OK')"
```

Expected:

```text
PySpark SQL OK
```

---

# 9. Verify Delta Lake

Run:

```bash
python -c "import delta; print('Delta Lake OK')"
```

Expected:

```text
Delta Lake OK
```

If this fails, install:

```bash
python -m pip install delta-spark
```

Then test again.

---

# 10. Understand the source data

Open:

```text
data/customers.csv
```

It contains:

```text
customer_id
customer_name
email
city
state
```

Open:

```text
data/products.csv
```

It contains:

```text
product_id
product_name
category
unit_price
```

Open:

```text
data/orders.csv
```

It contains:

```text
order_id
customer_id
product_id
order_date
quantity
unit_price
```

---

# 11. Why does the sample data contain bad records?

This is intentional.

The project is designed to demonstrate Data Quality.

Examples include:

```text
Duplicate customer_id
Missing email
Missing city
Unknown customer_id
Unknown product_id
Negative quantity
Negative price
Invalid order date
```

For example:

```text
1009,99,101,2026-08-07,1,75000
```

Customer `99` does not exist.

Another example:

```text
1010,1,101,2026-08-08,-1,75000
```

The quantity is invalid.

Another:

```text
1012,3,104,bad-date,1,18000
```

The date is invalid.

These records allow us to see how a real ETL pipeline handles bad data.

---

# 12. Understand the project modules

## `src/spark_session.py`

Creates the SparkSession.

Important code:

```python
spark = (
    SparkSession.builder
    .appName("RetailSparkETL")
    .master("local[*]")
    .getOrCreate()
)
```

`local[*]` means Spark runs locally and can use the available CPU cores.

---

## `src/schemas.py`

Defines explicit schemas.

For example:

```python
StructField("customer_id", IntegerType(), False)
```

This tells Spark:

```text
customer_id = integer
```

Instead of allowing Spark to guess the type.

This is recommended for production ETL pipelines.

---

# 13. Extract phase

The file:

```text
src/extract.py
```

reads the CSV files.

Conceptually:

```text
CSV
 ↓
Spark DataFrame
```

For example:

```python
customers = spark.read \
    .option("header", True) \
    .schema(CUSTOMER_SCHEMA) \
    .csv("customers.csv")
```

---

# 14. Validation phase

The file:

```text
src/quality.py
```

performs checks.

Examples:

### Required columns

```text
customer_id
customer_name
email
city
state
```

### Duplicate keys

```text
customer_id
```

### Null checks

```text
email
city
```

### Business rules

```text
quantity > 0
unit_price > 0
```

The pipeline prints a quality report before continuing.

---

# 15. Bronze layer

Bronze is the raw/landing layer.

We write the extracted data to:

```text
lake/bronze/
```

Structure:

```text
lake/
└── bronze/
    ├── customers/
    ├── products/
    └── orders/
```

The purpose is traceability.

If something goes wrong later, we can inspect the original ingested data.

---

# 16. Silver transformation

The file:

```text
src/transform.py
```

creates Silver data.

The pipeline performs:

```text
Remove duplicates
        ↓
Trim strings
        ↓
Standardize email
        ↓
Validate dates
        ↓
Remove invalid quantity
        ↓
Remove invalid price
        ↓
Validate customer
        ↓
Validate product
        ↓
Join datasets
        ↓
Calculate order_amount
```

The order amount is:

```text
quantity × unit_price
```

---

# 17. Silver layer

Silver data is written to:

```text
lake/silver/
```

Structure:

```text
lake/
└── silver/
    ├── customers/
    ├── products/
    └── orders/
```

Silver is cleaner and more useful than Bronze.

---

# 18. Gold transformation

Gold contains business-ready data.

The project creates:

```text
customer_sales
product_sales
daily_sales
top_customers
top_products
```

---

# 19. Customer sales

Example output concept:

```text
customer_id
customer_name
city
state
order_count
units
total_sales
avg_order_value
```

This answers:

> How much has each customer purchased?

---

# 20. Product sales

Example:

```text
product_id
product_name
category
units_sold
total_sales
```

This answers:

> Which products generate the most revenue?

---

# 21. Daily sales

Example:

```text
order_date
order_count
units_sold
total_sales
```

This answers:

> How much did we sell each day?

---

# 22. Execute the complete pipeline

From the project root:

```bash
python run_pipeline.py
```

The pipeline executes:

```text
1. Create SparkSession
2. Extract customers
3. Extract products
4. Extract orders
5. Print schemas
6. Run quality checks
7. Write Bronze
8. Clean data
9. Join data
10. Write Silver
11. Aggregate business metrics
12. Write Gold
13. Write quality report
14. Stop Spark
```

---

# 23. What should you see?

You should see sections similar to:

```text
=== EXTRACT ===

=== VALIDATE ===

customers_rows: ...
products_rows: ...
orders_rows: ...

duplicate_customer_keys: 1
null_customer_email: 1
null_customer_city: 1
invalid_order_quantity: 1
invalid_order_price: 1

=== BRONZE ===

=== SILVER ===

=== GOLD ===

=== PIPELINE COMPLETED ===
```

Spark may print additional logs. That is normal.

---

# 24. Check the generated folders

After successful execution:

```text
lake/
├── bronze/
│   ├── customers/
│   ├── products/
│   └── orders/
│
├── silver/
│   ├── customers/
│   ├── products/
│   └── orders/
│
└── gold/
    ├── customer_sales/
    ├── product_sales/
    ├── daily_sales/
    ├── top_customers/
    └── top_products/
```

These are Delta Lake datasets.

---

# 25. Quality report

The pipeline creates:

```text
reports/quality_report.json
```

Open it to see the validation results.

Example:

```json
{
  "customers_rows": 9,
  "products_rows": 6,
  "orders_rows": 14,
  "duplicate_customer_keys": 1,
  "null_customer_email": 1,
  "null_customer_city": 1,
  "invalid_order_quantity": 1,
  "invalid_order_price": 1
}
```

The exact counts correspond to the intentionally bad sample data.

---

# 26. Run the tests

From the project root:

```bash
pytest -q
```

The tests validate the quality rules and transformation behavior.

For example:

```text
duplicate customer detected
invalid quantity detected
invalid price detected
required columns exist
```

---

# 27. Understand the complete code flow

The main program is:

```text
run_pipeline.py
       |
       v
src/pipeline.py
       |
       +---- spark_session.py
       |
       +---- extract.py
       |
       +---- quality.py
       |
       +---- transform.py
       |
       +---- load.py
```

Think of it as:

```text
Orchestration
      |
      +-- Extract
      |
      +-- Validate
      |
      +-- Transform
      |
      +-- Load
```

---

# 28. Important Spark concepts used

This project gives you practical examples of:

### SparkSession

```python
SparkSession.builder.getOrCreate()
```

### DataFrame

```python
df
```

### Explicit schema

```python
StructType(...)
```

### Filter

```python
df.filter(...)
```

### Join

```python
orders.join(customers, "customer_id")
```

### GroupBy

```python
df.groupBy(...)
```

### Aggregation

```python
F.sum(...)
F.count(...)
F.avg(...)
```

### Delta write

```python
df.write.format("delta").save(path)
```

---

# 29. First learner exercise

Run:

```bash
python run_pipeline.py
```

Then answer:

1. How many customer records entered Bronze?
2. How many duplicate customer keys were detected?
3. How many orders were invalid?
4. How many orders remained in Silver?
5. Which customer has the highest sales?
6. Which product has the highest sales?
7. What is the total sales amount?

---

# 30. Second exercise — add an email quality rule

Add a check to identify emails that do not contain:

```text
@
```

For example:

```python
invalid_emails = customers.filter(
    ~F.col("email").contains("@")
)
```

Decide whether invalid emails should:

- be rejected,
- be quarantined,
- or be corrected.

---

# 31. Third exercise — add category sales

Create:

```text
category_sales
```

with:

```text
category
units_sold
total_sales
```

Hint:

```python
df.groupBy("category").agg(...)
```

---

# 32. Fourth exercise — inspect Spark execution

Add:

```python
silver_orders.explain("formatted")
```

Look for:

```text
Exchange
```

An `Exchange` often indicates data movement/shuffle.

Discuss:

> Why does the join/groupBy require data to move between partitions?

---

# 33. Fifth exercise — partitioning

Check:

```python
print(silver_orders.rdd.getNumPartitions())
```

Experiment with:

```python
df.repartition(4)
```

and:

```python
df.coalesce(2)
```

Then compare the execution plan.

---

# 34. Sixth exercise — caching

If the same DataFrame is reused multiple times:

```python
silver_orders.cache()
```

Then execute an action:

```python
silver_orders.count()
```

Later:

```python
silver_orders.unpersist()
```

Discuss why caching everything is not a good strategy.

---

# 35. Seventh exercise — Delta MERGE

Extend the project to support incremental customer updates.

Concept:

```text
New customer data
       |
       v
Delta MERGE
       |
       +---- matched → UPDATE
       |
       +---- new → INSERT
```

This is an important next step toward CDC/incremental ETL.

---

# 36. Eighth exercise — ETL audit

Create an audit/control dataset containing:

```text
run_id
start_time
end_time
status
customers_read
products_read
orders_read
silver_orders
gold_rows
error_message
```

This teaches production ETL monitoring.

---

# 37. Ninth exercise — failure handling

Change the pipeline so that:

```text
Critical validation failure
          ↓
Stop Silver/Gold publication
```

For example:

```text
Missing required column
          ↓
FAIL PIPELINE
          ↓
Do not publish Gold
```

This is an important production-quality concept.

---

# 38. Tenth exercise — incremental architecture

The next version can become:

```text
SOURCE
  |
  v
BRONZE
  |
  | Delta MERGE / CDC
  v
SILVER
  |
  v
GOLD
  |
  v
BI / Analytics
```

Possible future additions:

- Watermark
- CDC
- Delta Change Data Feed
- Batch control
- Reconciliation
- Data-quality framework
- Airflow
- Databricks
- Azure Data Lake Storage
- Unity Catalog

---

# 39. Recommended learning sequence

Do not try to understand the entire project at once.

Use this order:

```text
Day 1
 |
 +-- SparkSession
 +-- DataFrame
 +-- Read CSV
 +-- show()
 +-- printSchema()

Day 2
 |
 +-- filter()
 +-- select()
 +-- withColumn()
 +-- groupBy()
 +-- agg()

Day 3
 |
 +-- joins
 +-- null handling
 +-- duplicates
 +-- data quality

Day 4
 |
 +-- Bronze
 +-- Silver
 +-- Gold
 +-- Delta Lake

Day 5
 |
 +-- performance
 +-- partitions
 +-- shuffle
 +-- explain()

Day 6
 |
 +-- testing
 +-- audit
 +-- incremental processing
 +-- Delta MERGE
```

---

# 40. Final project objective

After completing this project, you should be able to explain:

```text
Why Spark?
    ↓
How Spark reads data
    ↓
How Spark transforms data
    ↓
How Spark joins data
    ↓
How Spark aggregates data
    ↓
How Spark handles data quality
    ↓
How Bronze/Silver/Gold works
    ↓
Why Delta Lake is useful
    ↓
How to build a complete Spark ETL pipeline
```

This project can then be extended into a production-style data engineering project with:

**PySpark + Delta Lake + Data Quality + Incremental ETL + Audit + Testing + Orchestration.**

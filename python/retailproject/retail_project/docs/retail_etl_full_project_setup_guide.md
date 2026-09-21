# Retail ETL Full Project — Step-by-Step Execution Guide

## 1. Prerequisites

Install:

- Python 3.10+
- MySQL 8.x
- VS Code
- Git (optional)

The source database must already exist:

`intern_sql_training`

The target database will be:

`retail_dw`

---

## 2. Open the project in VS Code

Extract:

`retail_etl_full_project.zip`

Then:

```bash
cd retail_etl_full_project
code .
```

---

## 3. Create the virtual environment

Linux/macOS:

```bash
python3 -m venv venv
source venv/bin/activate
```

Windows PowerShell:

```powershell
python -m venv venv
venv\Scripts\Activate.ps1
```

---

## 4. Install Python packages

```bash
pip install -r requirements.txt
```

---

## 5. Configure `.env`

Copy:

```bash
cp .env.example .env
```

Edit `.env`:

```text
SOURCE_DB_URL=mysql+pymysql://root:YOUR_PASSWORD@localhost:3306/intern_sql_training
TARGET_DB_URL=mysql+pymysql://root:YOUR_PASSWORD@localhost:3306/retail_dw
```

Replace `YOUR_PASSWORD`.

Do not commit `.env` to Git.

---

## 6. Test both database connections

Run:

```bash
pytest -q tests/test_connections.py
```

Expected:

```text
2 passed
```

---

# SQL EXECUTION ORDER

Run the SQL files in this exact order.

---

## 7. SQL 01 — Staging and ETL control tables

```bash
mysql -u root -p < sql/01_staging_and_control.sql
```

Creates:

- `retail_dw`
- `etl_batch_control`
- `etl_watermark`
- `etl_record_hash`
- all `stg_*` tables

Verify:

```sql
USE retail_dw;
SHOW TABLES;
```

---

## 8. SQL 02 — Dimensions

```bash
mysql -u root -p < sql/02_dimensions.sql
```

Creates:

- `dim_date`
- `dim_category`
- `dim_customer`
- `dim_product`
- `dim_department`
- `dim_employee`
- `dw_load_control`

---

## 9. SQL 03 — Facts

```bash
mysql -u root -p < sql/03_facts.sql
```

Creates:

- `fact_sales`
- `fact_payments`

Important fact grain:

`fact_sales = one row per order item`

---

## 10. Run the existing Source -> Staging ETL

This ZIP contains the reusable extraction modules, but your previously validated project may already have the main orchestration script you used during training.

If you already have that script, run it now so that `stg_*` contains the current source data.

The DW phase expects staging data.

Verify:

```sql
USE retail_dw;

SELECT COUNT(*) FROM stg_customers;
SELECT COUNT(*) FROM stg_products;
SELECT COUNT(*) FROM stg_orders;
SELECT COUNT(*) FROM stg_order_items;
SELECT COUNT(*) FROM stg_payments;
```

---

## 11. Run the Python Dimension + Fact Loader

After staging has current data:

```bash
python scripts/run_dw_pipeline.py
```

The loader performs:

1. Date dimension loading
2. Category dimension loading
3. Department dimension loading
4. Customer SCD Type 2 loading
5. Product SCD Type 2 loading
6. Employee SCD Type 2 loading
7. Fact sales loading
8. Fact payment loading

Expected output resembles:

```text
STAGING -> DATA WAREHOUSE
Source batch: 19

dim_date inserted: ...
dim_category inserted: ...
dim_department inserted: ...

dim_customer inserted=22, expired=0
dim_product inserted=31, expired=0
dim_employee inserted=15, expired=0

fact_sales inserted: ...
fact_payments inserted: ...

DW LOAD COMPLETED
```

Exact counts depend on the current source data.

---

## 12. SQL 04 — Reporting Views

Run:

```bash
mysql -u root -p retail_dw < sql/04_reporting_views.sql
```

Creates:

- `vw_sales_report`
- `vw_monthly_sales`
- `vw_customer_sales`
- `vw_product_sales`
- `vw_payment_summary`

---

## 13. SQL 05 — Warehouse reconciliation

Run:

```bash
mysql -u root -p retail_dw < sql/05_warehouse_reconciliation.sql
```

Then:

```sql
USE retail_dw;

SELECT *
FROM vw_dw_reconciliation;
```

Expected:

```text
table_name     source_count   warehouse_count   status
-------------------------------------------------------
customers      ...            ...               PASS
categories     ...            ...               PASS
products       ...            ...               PASS
departments    ...            ...               PASS
employees      ...            ...               PASS
order_items    ...            ...               PASS
payments       ...            ...               PASS
```

You can also run:

```bash
python scripts/run_reconciliation.py
```

---

## 14. SQL 06 — Reporting queries

Run:

```bash
mysql -u root -p retail_dw < sql/06_reporting_queries.sql
```

This provides:

- total sales
- total orders
- total units
- monthly sales
- top customers
- top products
- category sales
- payment summary
- order status analysis

---

## 15. SQL 07 — Validation

Run:

```bash
mysql -u root -p retail_dw < sql/07_validation.sql
```

This checks:

- source counts
- warehouse counts
- ETL batches
- watermarks
- hash state

---

# SCD TYPE 2 TEST

## 16. Test a customer update

Change one customer in the source database:

```sql
USE intern_sql_training;

UPDATE customers
SET city = 'Secunderabad'
WHERE customer_id = 22;
```

Then run your Source -> Staging/change-aware ETL.

Then run:

```bash
python scripts/run_dw_pipeline.py
```

Check:

```sql
USE retail_dw;

SELECT
    customer_sk,
    customer_id,
    customer_name,
    city,
    effective_from,
    effective_to,
    is_current
FROM dim_customer
WHERE customer_id = 22
ORDER BY effective_from;
```

Expected:

```text
customer 22 | Hyderabad    | old date | old end | 0
customer 22 | Secunderabad | new date | NULL    | 1
```

This proves SCD Type 2.

---

# AUTOMATED TESTS

## 17. Run all tests

```bash
pytest -q
```

The tests validate:

- source connection
- target connection
- required source tables
- baseline source counts
- warehouse tables
- fact uniqueness
- reconciliation

If your training source data was intentionally modified, the baseline count test may need to be updated to reflect the new baseline. It uses `>=` so added test records do not fail it.

---

# DASHBOARD

## 18. Dashboard technology

The project uses:

- Streamlit
- Plotly
- SQLAlchemy
- MySQL

Dashboard file:

```text
dashboard/app.py
```

It displays:

### KPI cards

- Total Sales
- Orders
- Units Sold
- Customers

### Charts

- Monthly Sales
- Sales by Category
- Top Products
- Top Customers

### Operational information

- Warehouse reconciliation
- Recent ETL batches

---

## 19. Start the dashboard

Make sure:

1. `.env` exists
2. MySQL is running
3. `retail_dw` exists
4. dimensions are loaded
5. facts are loaded
6. reporting views exist

Then:

```bash
streamlit run dashboard/app.py
```

Streamlit will show a local URL, normally similar to:

```text
Local URL: http://localhost:8501
```

Open that URL in your browser.

---

## 20. If the dashboard shows an error

First check:

```bash
python -c "from utils.database import get_target_connection; print(get_target_connection().connect().execute(__import__('sqlalchemy').text('SELECT 1')).scalar())"
```

Expected:

```text
1
```

Then check:

```sql
USE retail_dw;

SELECT COUNT(*) FROM fact_sales;
SELECT COUNT(*) FROM fact_payments;
SELECT COUNT(*) FROM dim_customer WHERE is_current=TRUE;
```

And:

```sql
SELECT * FROM vw_monthly_sales;
```

---

# FULL RUN ORDER

For a normal daily/full execution, the conceptual sequence is:

```text
1. Source MySQL
       |
       v
2. Generic Python Source -> Staging ETL
       |
       v
3. Batch Control
       |
       v
4. Reconciliation
       |
       v
5. Watermark / Hash state
       |
       v
6. Python Staging -> DW
       |
       +--> dim_date
       +--> dim_category
       +--> dim_department
       +--> dim_customer SCD2
       +--> dim_product SCD2
       +--> dim_employee SCD2
       |
       v
7. fact_sales
       |
       v
8. fact_payments
       |
       v
9. Warehouse reconciliation
       |
       v
10. Reporting views
       |
       v
11. Dashboard
```

---

# File-by-file responsibility

| File | Purpose |
|---|---|
| `config/settings.py` | DB configuration |
| `config/table_config.py` | Generic ETL metadata |
| `config/hash_config.py` | Hash columns |
| `extract/extractor.py` | Source extraction |
| `load/staging_loader.py` | Staging load |
| `load/dw_loader.py` | Dimension/fact warehouse loading |
| `utils/batch.py` | Batch control |
| `utils/watermark.py` | Incremental state |
| `utils/change_detection.py` | NEW/CHANGED/UNCHANGED |
| `sql/01_*` | Staging/control schema |
| `sql/02_*` | Dimensions |
| `sql/03_*` | Facts |
| `sql/04_*` | Reporting views |
| `sql/05_*` | Warehouse reconciliation |
| `sql/06_*` | Reporting SQL |
| `sql/07_*` | Validation |
| `scripts/run_dw_pipeline.py` | Staging -> DW orchestration |
| `scripts/run_reconciliation.py` | DW reconciliation |
| `tests/` | Automated tests |
| `dashboard/app.py` | Streamlit dashboard |

---

# Production-style architecture

The finished training project now looks like:

```text
                   ┌──────────────────────┐
                   │  MySQL OLTP SOURCE   │
                   │ intern_sql_training  │
                   └──────────┬───────────┘
                              │
                              ▼
                    ┌───────────────────┐
                    │ Generic Python ETL│
                    └─────────┬─────────┘
                              │
                 ┌────────────┼────────────┐
                 ▼            ▼            ▼
             Watermark    Row Hash     Batch Control
                 │            │            │
                 └────────────┼────────────┘
                              ▼
                    ┌───────────────────┐
                    │     STAGING       │
                    │      stg_*         │
                    └─────────┬─────────┘
                              │
                              ▼
                    ┌───────────────────┐
                    │  DW Python Loader │
                    └─────────┬─────────┘
                              │
               ┌──────────────┼──────────────┐
               ▼              ▼              ▼
          Dimensions      fact_sales    fact_payments
               │              │              │
               │          SCD Type 2         │
               └──────────────┼──────────────┘
                              ▼
                    ┌───────────────────┐
                    │ Reporting Views   │
                    └─────────┬─────────┘
                              │
                    ┌─────────▼─────────┐
                    │    Streamlit      │
                    │    Dashboard      │
                    └───────────────────┘
```

---

# Important note about your existing project

This is a **full consolidated reference implementation** of the next phase. Your previously validated source→staging scripts may have additional orchestration code from our earlier work.

Do **not** overwrite your working project blindly.

Instead, use this package as the **complete project baseline**, copy any newer source→staging orchestration you already validated into it, then follow the execution guide from the staging → DW section.

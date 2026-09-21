# Retail ETL Full Project

## Architecture

```text
MySQL Source
   |
Python Generic ETL
   |
Staging
   |
SCD2 Dimensions + Facts
   |
Warehouse Reconciliation
   |
Reporting Views
   |
Streamlit Dashboard
```

## Quick start

```bash
python3 -m venv venv
source venv/bin/activate
pip install -r requirements.txt
cp .env.example .env
```

Edit `.env`.

Then follow:

`docs/SETUP_AND_EXECUTION_GUIDE.md`

The guide contains the exact SQL execution order and dashboard instructions.

## Main commands

```bash
pytest -q
python scripts/run_dw_pipeline.py
python scripts/run_reconciliation.py
streamlit run dashboard/app.py
```

## SQL order

1. `sql/01_staging_and_control.sql`
2. `sql/02_dimensions.sql`
3. `sql/03_facts.sql`
4. Run source -> staging ETL
5. `python scripts/run_dw_pipeline.py`
6. `sql/04_reporting_views.sql`
7. `sql/05_warehouse_reconciliation.sql`
8. `sql/06_reporting_queries.sql`
9. `sql/07_validation.sql`
10. `streamlit run dashboard/app.py`

See `docs/SETUP_AND_EXECUTION_GUIDE.md` before executing.

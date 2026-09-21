#!/bin/bash

# Retail ETL Project - Complete Setup & Execution
# Run this file from the retail_project root directory.
# MySQL credentials expected by this project: root / root

set -e

echo "=============================================="
echo " Retail ETL Project - Setup & Execution"
echo "=============================================="

# Always run from the directory containing this script.
cd "$(dirname "$0")"

echo
echo "==> Checking virtual environment..."
if [ -z "$VIRTUAL_ENV" ]; then
    if [ -f "venv/bin/activate" ]; then
        source venv/bin/activate
    else
        echo "ERROR: venv not found."
        echo "Create it first with: python3 -m venv venv"
        exit 1
    fi
fi

echo "Python: $(python --version)"
echo "Virtual environment: $VIRTUAL_ENV"

echo
echo "==> Installing/updating Python dependencies..."
python -m pip install -r requirements.txt

echo
echo "==> MySQL password"
read -s -p "Enter MySQL root password: " MYSQL_PASSWORD
echo
export MYSQL_PWD="$MYSQL_PASSWORD"

cleanup() {
    unset MYSQL_PWD
}
trap cleanup EXIT

echo
echo "==> 1/10 Importing source database..."
mysql -u root < intern_sql_training_mysql8.sql

echo
echo "==> 2/10 Creating retail_dw + staging/control tables..."
mysql -u root < sql/01_staging_and_control.sql

echo
echo "==> 3/10 Creating dimension tables..."
mysql -u root < sql/02_dimensions.sql

echo
echo "==> 4/10 Creating fact tables..."
mysql -u root < sql/03_facts.sql

echo
echo "==> 5/10 Running Source -> Staging ETL..."
python -m scripts.run_staging_etl

echo
echo "==> 6/10 Running Staging -> Data Warehouse pipeline..."
python -m scripts.run_dw_pipeline

echo
echo "==> 7/10 Creating reporting views..."
mysql -u root retail_dw < sql/04_reporting_views.sql

echo
echo "==> 8/10 Creating reconciliation objects..."
mysql -u root retail_dw < sql/05_warehouse_reconciliation.sql

echo
echo "==> 9/10 Running reconciliation..."
python -m scripts.run_reconciliation

echo
echo "==> 10/10 Running full automated test suite..."
pytest -v

echo
echo "=============================================="
echo " SETUP + ETL + DW + TESTS COMPLETED"
echo "=============================================="
echo
echo "Starting Streamlit dashboard..."
echo

unset MYSQL_PWD

streamlit run dashboard/app.py

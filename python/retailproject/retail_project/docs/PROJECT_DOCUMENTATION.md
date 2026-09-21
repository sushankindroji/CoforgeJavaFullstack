# Retail ETL Full-Fledged Project Documentation

## Executive Summary

This project demonstrates a complete retail Data Engineering pipeline:

`MySQL Source -> Python ETL -> Staging -> Dimensional Warehouse -> Reconciliation -> Reporting -> Dashboard`

It includes:

- metadata-driven extraction
- batch control
- watermark incremental processing
- SHA-256 update detection
- NEW / CHANGED / UNCHANGED classification
- SCD Type 2 dimensions
- fact tables
- warehouse reconciliation
- automated tests
- Streamlit/Plotly dashboard

## Source tables

- categories
- customers
- departments
- employees
- products
- orders
- order_items
- payments

## Warehouse dimensions

- dim_date
- dim_category
- dim_customer
- dim_product
- dim_department
- dim_employee

## Warehouse facts

- fact_sales — grain: one row per order item
- fact_payments — grain: one row per payment

## SCD Type 2

Customer, product and employee dimensions are designed for history tracking using:

- effective_from
- effective_to
- is_current
- source_batch_id

## Reporting

The warehouse exposes:

- detailed sales view
- monthly sales
- customer sales
- product sales
- payment summary
- reconciliation status

## Dashboard

The Streamlit dashboard shows:

- sales KPI
- order KPI
- unit KPI
- customer KPI
- monthly sales trend
- category revenue
- top products
- top customers
- reconciliation
- recent ETL batches

## Operational execution

Use `docs/SETUP_AND_EXECUTION_GUIDE.md` for the exact SQL execution order and dashboard startup instructions.

## Recommended future production enhancements

- Airflow orchestration
- MySQL binlog CDC / Debezium
- Kafka
- data quality framework
- Great Expectations
- centralized logging
- alerting
- CI/CD
- secrets manager
- cloud warehouse

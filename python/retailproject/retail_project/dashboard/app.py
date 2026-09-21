import os
import pandas as pd
import streamlit as st
import plotly.express as px
from sqlalchemy import create_engine, text
from dotenv import load_dotenv

load_dotenv()

TARGET_DB_URL = os.getenv("TARGET_DB_URL")

st.set_page_config(
    page_title="Retail Data Warehouse Dashboard",
    page_icon="📊",
    layout="wide",
)

st.title("📊 Retail Data Warehouse Dashboard")
st.caption("MySQL + Python ETL + Dimensional Warehouse")

if not TARGET_DB_URL:
    st.error("TARGET_DB_URL is missing. Create .env from .env.example.")
    st.stop()

@st.cache_resource
def get_engine():
    return create_engine(TARGET_DB_URL, pool_pre_ping=True)

@st.cache_data(ttl=60)
def query_df(sql):
    with get_engine().connect() as connection:
        return pd.read_sql(text(sql), connection)

try:
    total_sales = query_df(
        "SELECT COALESCE(SUM(sales_amount),0) AS value FROM fact_sales"
    ).iloc[0]["value"]

    total_orders = query_df(
        "SELECT COUNT(DISTINCT order_id) AS value FROM fact_sales"
    ).iloc[0]["value"]

    total_units = query_df(
        "SELECT COALESCE(SUM(quantity),0) AS value FROM fact_sales"
    ).iloc[0]["value"]

    total_customers = query_df(
        "SELECT COUNT(*) AS value FROM dim_customer WHERE is_current=TRUE"
    ).iloc[0]["value"]

    c1, c2, c3, c4 = st.columns(4)
    c1.metric("Total Sales", f"₹{float(total_sales):,.2f}")
    c2.metric("Orders", f"{int(total_orders):,}")
    c3.metric("Units Sold", f"{int(total_units):,}")
    c4.metric("Customers", f"{int(total_customers):,}")

    st.divider()

    monthly = query_df("""
        SELECT year_number, month_number, month_name,
               total_sales, total_orders, total_units
        FROM vw_monthly_sales
        ORDER BY year_number, month_number
    """)

    products = query_df("""
        SELECT product_name, category_name, total_sales
        FROM vw_product_sales
        ORDER BY total_sales DESC
        LIMIT 10
    """)

    customers = query_df("""
        SELECT customer_name, city, state, total_sales
        FROM vw_customer_sales
        ORDER BY total_sales DESC
        LIMIT 10
    """)

    categories = query_df("""
        SELECT category_name, SUM(sales_amount) AS total_sales
        FROM vw_sales_report
        GROUP BY category_name
        ORDER BY total_sales DESC
    """)

    left, right = st.columns(2)

    with left:
        st.subheader("Monthly Sales")
        if not monthly.empty:
            monthly["period"] = (
                monthly["month_name"].astype(str)
                + " "
                + monthly["year_number"].astype(str)
            )
            fig = px.line(
                monthly,
                x="period",
                y="total_sales",
                markers=True,
                title="Sales Trend",
            )
            fig.update_layout(xaxis_title="", yaxis_title="Sales")
            st.plotly_chart(fig, use_container_width=True)

    with right:
        st.subheader("Sales by Category")
        if not categories.empty:
            fig = px.bar(
                categories,
                x="category_name",
                y="total_sales",
                title="Category Revenue",
            )
            fig.update_layout(xaxis_title="", yaxis_title="Sales")
            st.plotly_chart(fig, use_container_width=True)

    left, right = st.columns(2)

    with left:
        st.subheader("Top Products")
        if not products.empty:
            fig = px.bar(
                products.sort_values("total_sales"),
                x="total_sales",
                y="product_name",
                orientation="h",
                title="Top 10 Products",
            )
            st.plotly_chart(fig, use_container_width=True)

    with right:
        st.subheader("Top Customers")
        if not customers.empty:
            fig = px.bar(
                customers.sort_values("total_sales"),
                x="total_sales",
                y="customer_name",
                orientation="h",
                title="Top 10 Customers",
            )
            st.plotly_chart(fig, use_container_width=True)

    st.divider()

    st.subheader("Warehouse Reconciliation")
    recon = query_df("""
        SELECT table_name, source_count,
               warehouse_current_count, status
        FROM vw_dw_reconciliation
        ORDER BY table_name
    """)
    st.dataframe(recon, use_container_width=True, hide_index=True)

    st.subheader("Recent ETL Batches")
    batches = query_df("""
        SELECT batch_id, pipeline_name, status,
               records_processed, start_time, end_time
        FROM etl_batch_control
        ORDER BY batch_id DESC
        LIMIT 10
    """)
    st.dataframe(batches, use_container_width=True, hide_index=True)

except Exception as exc:
    st.error(
        "Dashboard could not query the warehouse. "
        "Run the SQL setup and DW pipeline first."
    )
    st.exception(exc)

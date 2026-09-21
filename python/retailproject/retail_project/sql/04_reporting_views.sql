USE retail_dw;

CREATE OR REPLACE VIEW vw_sales_report AS
SELECT
    f.sales_sk,
    f.order_id,
    f.order_item_id,
    d.full_date,
    d.year_number,
    d.month_number,
    d.month_name,
    c.customer_id,
    c.customer_name,
    c.city,
    c.state,
    p.product_id,
    p.product_name,
    cat.category_id,
    cat.category_name,
    f.quantity,
    f.unit_price,
    f.sales_amount,
    f.order_status
FROM fact_sales f
JOIN dim_date d ON f.date_sk = d.date_sk
JOIN dim_customer c ON f.customer_sk = c.customer_sk
JOIN dim_product p ON f.product_sk = p.product_sk
LEFT JOIN dim_category cat ON p.category_sk = cat.category_sk;

CREATE OR REPLACE VIEW vw_monthly_sales AS
SELECT
    year_number,
    month_number,
    month_name,
    SUM(sales_amount) AS total_sales,
    SUM(quantity) AS total_units,
    COUNT(DISTINCT order_id) AS total_orders
FROM vw_sales_report
GROUP BY year_number, month_number, month_name;

CREATE OR REPLACE VIEW vw_customer_sales AS
SELECT
    customer_id,
    customer_name,
    city,
    state,
    SUM(sales_amount) AS total_sales,
    SUM(quantity) AS total_units,
    COUNT(DISTINCT order_id) AS total_orders
FROM vw_sales_report
GROUP BY customer_id, customer_name, city, state;

CREATE OR REPLACE VIEW vw_product_sales AS
SELECT
    product_id,
    product_name,
    category_name,
    SUM(sales_amount) AS total_sales,
    SUM(quantity) AS total_units,
    COUNT(DISTINCT order_id) AS total_orders
FROM vw_sales_report
GROUP BY product_id, product_name, category_name;

CREATE OR REPLACE VIEW vw_payment_summary AS
SELECT
    payment_method,
    payment_status,
    SUM(amount) AS total_amount,
    COUNT(*) AS payment_count
FROM fact_payments
GROUP BY payment_method, payment_status;

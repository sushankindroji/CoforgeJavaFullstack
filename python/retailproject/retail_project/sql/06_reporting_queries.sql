USE retail_dw;

-- Total sales
SELECT SUM(sales_amount) AS total_sales
FROM fact_sales;

-- Total orders
SELECT COUNT(DISTINCT order_id) AS total_orders
FROM fact_sales;

-- Total units
SELECT SUM(quantity) AS total_units
FROM fact_sales;

-- Monthly sales
SELECT *
FROM vw_monthly_sales
ORDER BY year_number, month_number;

-- Top customers
SELECT *
FROM vw_customer_sales
ORDER BY total_sales DESC
LIMIT 10;

-- Top products
SELECT *
FROM vw_product_sales
ORDER BY total_sales DESC
LIMIT 10;

-- Sales by category
SELECT
    category_name,
    SUM(sales_amount) AS total_sales
FROM vw_sales_report
GROUP BY category_name
ORDER BY total_sales DESC;

-- Payment summary
SELECT *
FROM vw_payment_summary
ORDER BY total_amount DESC;

-- Order status
SELECT
    order_status,
    COUNT(DISTINCT order_id) AS orders,
    SUM(sales_amount) AS sales
FROM vw_sales_report
GROUP BY order_status
ORDER BY orders DESC;

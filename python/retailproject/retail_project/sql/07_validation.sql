USE retail_dw;

SELECT 'SOURCE' AS layer, 'customers' AS table_name,
       COUNT(*) AS row_count
FROM intern_sql_training.customers
UNION ALL
SELECT 'SOURCE', 'products', COUNT(*)
FROM intern_sql_training.products
UNION ALL
SELECT 'SOURCE', 'orders', COUNT(*)
FROM intern_sql_training.orders
UNION ALL
SELECT 'SOURCE', 'order_items', COUNT(*)
FROM intern_sql_training.order_items
UNION ALL
SELECT 'SOURCE', 'payments', COUNT(*)
FROM intern_sql_training.payments

UNION ALL

SELECT 'DW', 'dim_customer', COUNT(*)
FROM dim_customer
WHERE is_current = TRUE
UNION ALL
SELECT 'DW', 'dim_product', COUNT(*)
FROM dim_product
WHERE is_current = TRUE
UNION ALL
SELECT 'DW', 'fact_sales', COUNT(*)
FROM fact_sales
UNION ALL
SELECT 'DW', 'fact_payments', COUNT(*)
FROM fact_payments;

SELECT *
FROM vw_dw_reconciliation;

SELECT *
FROM etl_batch_control
ORDER BY batch_id DESC
LIMIT 20;

SELECT *
FROM etl_watermark
ORDER BY table_name;

SELECT
    table_name,
    COUNT(*) AS hash_records
FROM etl_record_hash
GROUP BY table_name
ORDER BY table_name;

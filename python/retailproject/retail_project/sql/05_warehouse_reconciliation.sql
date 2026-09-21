USE retail_dw;

CREATE OR REPLACE VIEW vw_dw_reconciliation AS
SELECT
    'customers' AS table_name,
    (SELECT COUNT(*) FROM intern_sql_training.customers) AS source_count,
    (SELECT COUNT(*) FROM dim_customer WHERE is_current = TRUE) AS warehouse_current_count,
    CASE
        WHEN (SELECT COUNT(*) FROM intern_sql_training.customers)
           = (SELECT COUNT(*) FROM dim_customer WHERE is_current = TRUE)
        THEN 'PASS' ELSE 'FAIL'
    END AS status

UNION ALL

SELECT
    'categories',
    (SELECT COUNT(*) FROM intern_sql_training.categories),
    (SELECT COUNT(*) FROM dim_category WHERE is_current = TRUE),
    CASE
        WHEN (SELECT COUNT(*) FROM intern_sql_training.categories)
           = (SELECT COUNT(*) FROM dim_category WHERE is_current = TRUE)
        THEN 'PASS' ELSE 'FAIL'
    END

UNION ALL

SELECT
    'products',
    (SELECT COUNT(*) FROM intern_sql_training.products),
    (SELECT COUNT(*) FROM dim_product WHERE is_current = TRUE),
    CASE
        WHEN (SELECT COUNT(*) FROM intern_sql_training.products)
           = (SELECT COUNT(*) FROM dim_product WHERE is_current = TRUE)
        THEN 'PASS' ELSE 'FAIL'
    END

UNION ALL

SELECT
    'departments',
    (SELECT COUNT(*) FROM intern_sql_training.departments),
    (SELECT COUNT(*) FROM dim_department WHERE is_current = TRUE),
    CASE
        WHEN (SELECT COUNT(*) FROM intern_sql_training.departments)
           = (SELECT COUNT(*) FROM dim_department WHERE is_current = TRUE)
        THEN 'PASS' ELSE 'FAIL'
    END

UNION ALL

SELECT
    'employees',
    (SELECT COUNT(*) FROM intern_sql_training.employees),
    (SELECT COUNT(*) FROM dim_employee WHERE is_current = TRUE),
    CASE
        WHEN (SELECT COUNT(*) FROM intern_sql_training.employees)
           = (SELECT COUNT(*) FROM dim_employee WHERE is_current = TRUE)
        THEN 'PASS' ELSE 'FAIL'
    END

UNION ALL

SELECT
    'order_items',
    (SELECT COUNT(*) FROM intern_sql_training.order_items),
    (SELECT COUNT(*) FROM fact_sales),
    CASE
        WHEN (SELECT COUNT(*) FROM intern_sql_training.order_items)
           = (SELECT COUNT(*) FROM fact_sales)
        THEN 'PASS' ELSE 'FAIL'
    END

UNION ALL

SELECT
    'payments',
    (SELECT COUNT(*) FROM intern_sql_training.payments),
    (SELECT COUNT(*) FROM fact_payments),
    CASE
        WHEN (SELECT COUNT(*) FROM intern_sql_training.payments)
           = (SELECT COUNT(*) FROM fact_payments)
        THEN 'PASS' ELSE 'FAIL'
    END;

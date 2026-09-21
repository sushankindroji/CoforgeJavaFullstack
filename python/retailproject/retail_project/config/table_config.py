TABLE_CONFIG = [
    {
        "source_table": "departments",
        "staging_table": "stg_departments",
        "watermark_column": "department_id",
        "primary_key": "department_id",
    },
    {
        "source_table": "employees",
        "staging_table": "stg_employees",
        "watermark_column": "employee_id",
        "primary_key": "employee_id",
    },
    {
        "source_table": "customers",
        "staging_table": "stg_customers",
        "watermark_column": "customer_id",
        "primary_key": "customer_id",
    },
    {
        "source_table": "categories",
        "staging_table": "stg_categories",
        "watermark_column": "category_id",
        "primary_key": "category_id",
    },
    {
        "source_table": "products",
        "staging_table": "stg_products",
        "watermark_column": "product_id",
        "primary_key": "product_id",
    },
    {
        "source_table": "orders",
        "staging_table": "stg_orders",
        "watermark_column": "order_id",
        "primary_key": "order_id",
    },
    {
        "source_table": "order_items",
        "staging_table": "stg_order_items",
        "watermark_column": "order_item_id",
        "primary_key": "order_item_id",
    },
    {
        "source_table": "payments",
        "staging_table": "stg_payments",
        "watermark_column": "payment_id",
        "primary_key": "payment_id",
    },
]

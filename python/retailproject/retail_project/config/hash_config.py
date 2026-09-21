HASH_COLUMNS = {
    "departments": ["department_id", "department_name"],
    "employees": [
        "employee_id", "employee_name", "department_id",
        "salary", "manager_id"
    ],
    "customers": [
        "customer_id", "customer_name", "email", "city", "state"
    ],
    "categories": ["category_id", "category_name"],
    "products": [
        "product_id", "product_name", "category_id", "unit_price"
    ],
    "orders": [
        "order_id", "customer_id", "order_date", "status"
    ],
    "order_items": [
        "order_item_id", "order_id", "product_id",
        "quantity", "unit_price"
    ],
    "payments": [
        "payment_id", "order_id", "amount",
        "payment_method", "payment_status"
    ],
}

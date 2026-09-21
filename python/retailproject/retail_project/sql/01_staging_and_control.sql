CREATE DATABASE IF NOT EXISTS retail_dw;
USE retail_dw;

CREATE TABLE IF NOT EXISTS etl_batch_control (
    batch_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pipeline_name VARCHAR(150) NOT NULL,
    status VARCHAR(30) NOT NULL,
    records_processed BIGINT DEFAULT 0,
    error_message TEXT,
    start_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    end_time DATETIME NULL
);

CREATE TABLE IF NOT EXISTS etl_watermark (
    table_name VARCHAR(100) PRIMARY KEY,
    last_watermark BIGINT NULL,
    batch_id BIGINT NULL,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS etl_record_hash (
    table_name VARCHAR(100) NOT NULL,
    record_key VARCHAR(200) NOT NULL,
    row_hash CHAR(64) NOT NULL,
    batch_id BIGINT NULL,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (table_name, record_key)
);

CREATE TABLE IF NOT EXISTS stg_categories (
    category_id INT,
    category_name VARCHAR(100),
    etl_batch_id BIGINT,
    etl_loaded_at DATETIME
);

CREATE TABLE IF NOT EXISTS stg_customers (
    customer_id INT,
    customer_name VARCHAR(120),
    email VARCHAR(160),
    city VARCHAR(80),
    state VARCHAR(80),
    etl_batch_id BIGINT,
    etl_loaded_at DATETIME
);

CREATE TABLE IF NOT EXISTS stg_departments (
    department_id INT,
    department_name VARCHAR(100),
    etl_batch_id BIGINT,
    etl_loaded_at DATETIME
);

CREATE TABLE IF NOT EXISTS stg_employees (
    employee_id INT,
    employee_name VARCHAR(120),
    department_id INT,
    salary DECIMAL(12,2),
    manager_id INT,
    etl_batch_id BIGINT,
    etl_loaded_at DATETIME
);

CREATE TABLE IF NOT EXISTS stg_order_items (
    order_item_id INT,
    order_id INT,
    product_id INT,
    quantity INT,
    unit_price DECIMAL(12,2),
    etl_batch_id BIGINT,
    etl_loaded_at DATETIME
);

CREATE TABLE IF NOT EXISTS stg_orders (
    order_id INT,
    customer_id INT,
    order_date DATE,
    status VARCHAR(30),
    etl_batch_id BIGINT,
    etl_loaded_at DATETIME
);

CREATE TABLE IF NOT EXISTS stg_payments (
    payment_id INT,
    order_id INT,
    amount DECIMAL(12,2),
    payment_method VARCHAR(40),
    payment_status VARCHAR(30),
    etl_batch_id BIGINT,
    etl_loaded_at DATETIME
);

CREATE TABLE IF NOT EXISTS stg_products (
    product_id INT,
    product_name VARCHAR(150),
    category_id INT,
    unit_price DECIMAL(12,2),
    etl_batch_id BIGINT,
    etl_loaded_at DATETIME
);

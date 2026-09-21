USE retail_dw;

CREATE TABLE IF NOT EXISTS dim_date (
    date_sk INT PRIMARY KEY,
    full_date DATE NOT NULL,
    day_of_month INT NOT NULL,
    month_number INT NOT NULL,
    month_name VARCHAR(20) NOT NULL,
    quarter_number INT NOT NULL,
    year_number INT NOT NULL,
    day_of_week INT NOT NULL,
    day_name VARCHAR(20) NOT NULL,
    is_weekend BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS dim_category (
    category_sk BIGINT AUTO_INCREMENT PRIMARY KEY,
    category_id INT NOT NULL,
    category_name VARCHAR(100) NOT NULL,
    effective_from DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    effective_to DATETIME NULL,
    is_current BOOLEAN NOT NULL DEFAULT TRUE,
    source_batch_id BIGINT NULL,
    UNIQUE KEY uk_category_version (category_id, effective_from),
    INDEX idx_category_current (category_id, is_current)
);

CREATE TABLE IF NOT EXISTS dim_customer (
    customer_sk BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    customer_name VARCHAR(120) NOT NULL,
    email VARCHAR(160),
    city VARCHAR(80),
    state VARCHAR(80),
    effective_from DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    effective_to DATETIME NULL,
    is_current BOOLEAN NOT NULL DEFAULT TRUE,
    source_batch_id BIGINT NULL,
    UNIQUE KEY uk_customer_version (customer_id, effective_from),
    INDEX idx_customer_current (customer_id, is_current)
);

CREATE TABLE IF NOT EXISTS dim_product (
    product_sk BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    product_name VARCHAR(150) NOT NULL,
    category_id INT NULL,
    category_sk BIGINT NULL,
    unit_price DECIMAL(12,2),
    effective_from DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    effective_to DATETIME NULL,
    is_current BOOLEAN NOT NULL DEFAULT TRUE,
    source_batch_id BIGINT NULL,
    UNIQUE KEY uk_product_version (product_id, effective_from),
    INDEX idx_product_current (product_id, is_current),
    CONSTRAINT fk_product_category
        FOREIGN KEY (category_sk)
        REFERENCES dim_category(category_sk)
);

CREATE TABLE IF NOT EXISTS dim_department (
    department_sk BIGINT AUTO_INCREMENT PRIMARY KEY,
    department_id INT NOT NULL,
    department_name VARCHAR(100) NOT NULL,
    effective_from DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    effective_to DATETIME NULL,
    is_current BOOLEAN NOT NULL DEFAULT TRUE,
    source_batch_id BIGINT NULL,
    UNIQUE KEY uk_department_version (department_id, effective_from),
    INDEX idx_department_current (department_id, is_current)
);

CREATE TABLE IF NOT EXISTS dim_employee (
    employee_sk BIGINT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL,
    employee_name VARCHAR(120) NOT NULL,
    department_id INT NULL,
    department_sk BIGINT NULL,
    salary DECIMAL(12,2),
    manager_id INT NULL,
    effective_from DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    effective_to DATETIME NULL,
    is_current BOOLEAN NOT NULL DEFAULT TRUE,
    source_batch_id BIGINT NULL,
    UNIQUE KEY uk_employee_version (employee_id, effective_from),
    INDEX idx_employee_current (employee_id, is_current),
    CONSTRAINT fk_employee_department
        FOREIGN KEY (department_sk)
        REFERENCES dim_department(department_sk)
);

CREATE TABLE IF NOT EXISTS dw_load_control (
    load_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    load_name VARCHAR(150) NOT NULL,
    status VARCHAR(30) NOT NULL,
    rows_inserted BIGINT DEFAULT 0,
    rows_updated BIGINT DEFAULT 0,
    started_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    ended_at DATETIME NULL,
    error_message TEXT
);

USE retail_dw;

CREATE TABLE IF NOT EXISTS fact_sales (
    sales_sk BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_item_id INT NOT NULL,
    order_id INT NOT NULL,
    date_sk INT NOT NULL,
    customer_sk BIGINT NOT NULL,
    product_sk BIGINT NOT NULL,
    quantity INT NOT NULL,
    unit_price DECIMAL(12,2) NOT NULL,
    sales_amount DECIMAL(14,2)
        GENERATED ALWAYS AS (quantity * unit_price) STORED,
    order_status VARCHAR(30),
    source_batch_id BIGINT NULL,
    loaded_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    UNIQUE KEY uk_fact_sales_order_item (order_item_id),
    INDEX idx_fact_sales_order (order_id),
    INDEX idx_fact_sales_customer (customer_sk),
    INDEX idx_fact_sales_product (product_sk),
    INDEX idx_fact_sales_date (date_sk),
    CONSTRAINT fk_sales_date
        FOREIGN KEY (date_sk) REFERENCES dim_date(date_sk),
    CONSTRAINT fk_sales_customer
        FOREIGN KEY (customer_sk) REFERENCES dim_customer(customer_sk),
    CONSTRAINT fk_sales_product
        FOREIGN KEY (product_sk) REFERENCES dim_product(product_sk)
);

CREATE TABLE IF NOT EXISTS fact_payments (
    payment_sk BIGINT AUTO_INCREMENT PRIMARY KEY,
    payment_id INT NOT NULL,
    order_id INT NOT NULL,
    date_sk INT NOT NULL,
    customer_sk BIGINT NULL,
    amount DECIMAL(14,2) NOT NULL,
    payment_method VARCHAR(40),
    payment_status VARCHAR(30),
    source_batch_id BIGINT NULL,
    loaded_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    UNIQUE KEY uk_fact_payment (payment_id),
    INDEX idx_fact_payment_order (order_id),
    INDEX idx_fact_payment_customer (customer_sk),
    INDEX idx_fact_payment_date (date_sk),
    CONSTRAINT fk_payment_date
        FOREIGN KEY (date_sk) REFERENCES dim_date(date_sk),
    CONSTRAINT fk_payment_customer
        FOREIGN KEY (customer_sk) REFERENCES dim_customer(customer_sk)
);

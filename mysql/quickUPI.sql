-- ============================================================
-- QuickUPI Database
-- ============================================================

-- ================= DATABASE =================
DROP DATABASE IF EXISTS quickupi;
CREATE DATABASE quickupi;
USE quickupi;

-- ================= TABLES =================
-- 1NF/2NF/3NF: single atomic PK, no partial or transitive dependency
CREATE TABLE Banks (
    bank_id INT AUTO_INCREMENT PRIMARY KEY,
    bank_name VARCHAR(50) NOT NULL UNIQUE,
    ifsc_prefix VARCHAR(11) NOT NULL
);

-- 1NF/2NF/3NF: atomic columns, single PK, no column depends on another non-key column
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    mobile_number VARCHAR(10) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    gender ENUM('M','F','O') DEFAULT 'M',
    dob DATE,
    city VARCHAR(50),
    is_active TINYINT(1) NOT NULL DEFAULT 1,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- One-to-One: each user has exactly one wallet
-- 1NF/2NF/3NF: balance depends only on wallet_id, not on any other column
CREATE TABLE Wallets (
    wallet_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL UNIQUE,
    balance DECIMAL(10,2) NOT NULL DEFAULT 0 CHECK (balance >= 0),
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- One-to-Many: a user can have many bank accounts
-- 1NF/2NF/3NF: bank_id is a foreign key, not bank_name repeated here (avoids transitive dependency)
CREATE TABLE BankAccounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    bank_id INT NOT NULL,
    account_number VARCHAR(20) NOT NULL UNIQUE,
    account_type ENUM('SAVINGS','CURRENT') DEFAULT 'SAVINGS',
    is_primary TINYINT(1) DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (bank_id) REFERENCES Banks(bank_id) ON DELETE RESTRICT ON UPDATE CASCADE
);

-- 1NF/2NF/3NF: one vpa per row, account_id links to BankAccounts instead of repeating account details
CREATE TABLE UPI_IDs (
    upi_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    account_id INT NOT NULL,
    vpa VARCHAR(50) NOT NULL UNIQUE,
    is_active TINYINT(1) DEFAULT 1,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (account_id) REFERENCES BankAccounts(account_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 1NF/2NF/3NF: category stored as plain text here since it has no other attributes to justify its own table
CREATE TABLE Merchants (
    merchant_id INT AUTO_INCREMENT PRIMARY KEY,
    merchant_name VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    merchant_vpa VARCHAR(50) NOT NULL UNIQUE,
    city VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Lookup table for transaction status (avoids repeating text)
-- 3NF: pulled out so status text does not repeat on every transaction row
CREATE TABLE TransactionStatus (
    status_id INT AUTO_INCREMENT PRIMARY KEY,
    status_name VARCHAR(20) NOT NULL UNIQUE
);

-- 1NF/2NF/3NF: status stored as status_id FK, not status text (no transitive dependency)
CREATE TABLE Transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    sender_id INT NOT NULL,
    receiver_user_id INT NULL,
    merchant_id INT NULL,
    amount DECIMAL(10,2) NOT NULL CHECK (amount > 0),
    transaction_type ENUM('P2P','MERCHANT','RECHARGE','BILL') NOT NULL,
    status_id INT NOT NULL DEFAULT 1,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    remarks VARCHAR(100),
    -- business rule: a transaction should have a receiver_user_id or a merchant_id
    -- (not enforced as a CHECK here because both columns use ON DELETE SET NULL,
    -- and MySQL does not allow a column to be in both a CHECK and a SET NULL FK action)
    FOREIGN KEY (sender_id) REFERENCES Users(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (receiver_user_id) REFERENCES Users(user_id) ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (merchant_id) REFERENCES Merchants(merchant_id) ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (status_id) REFERENCES TransactionStatus(status_id) ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Many-to-Many: users linked to other users as beneficiaries (junction table)
-- 2NF: single-column PK (beneficiary_id) avoids partial dependency on the composite user pair
CREATE TABLE Beneficiaries (
    beneficiary_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    beneficiary_user_id INT NOT NULL,
    nickname VARCHAR(50),
    added_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (user_id, beneficiary_user_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (beneficiary_user_id) REFERENCES Users(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 1NF/2NF/3NF: one bill per row, amount depends only on bill_id
CREATE TABLE Bills (
    bill_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    biller_name VARCHAR(50) NOT NULL,
    bill_type ENUM('ELECTRICITY','WATER','MOBILE','DTH','GAS') NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    due_date DATE,
    is_paid TINYINT(1) DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- One-to-One: one cashback record per transaction
-- 3NF: kept separate from Transactions so cashback logic does not affect the core transaction row
CREATE TABLE Cashback (
    cashback_id INT AUTO_INCREMENT PRIMARY KEY,
    transaction_id INT NOT NULL UNIQUE,
    cashback_amount DECIMAL(8,2) NOT NULL DEFAULT 0,
    credited_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (transaction_id) REFERENCES Transactions(transaction_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 1NF/2NF/3NF: points depend only on reward_id, no repeating groups
CREATE TABLE Rewards (
    reward_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    points INT NOT NULL DEFAULT 0,
    reason VARCHAR(100),
    earned_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 1NF/2NF/3NF: offer details stored once, not duplicated per user (that is handled by OfferClaims)
CREATE TABLE Offers (
    offer_id INT AUTO_INCREMENT PRIMARY KEY,
    offer_title VARCHAR(100) NOT NULL,
    discount_percent DECIMAL(5,2) CHECK (discount_percent BETWEEN 0 AND 100),
    valid_till DATE,
    is_active TINYINT(1) DEFAULT 1
);

-- Many-to-Many: users claiming offers (junction table)
-- 2NF: single-column PK (claim_id) avoids partial dependency on the composite user-offer pair
CREATE TABLE OfferClaims (
    claim_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    offer_id INT NOT NULL,
    claimed_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (user_id, offer_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (offer_id) REFERENCES Offers(offer_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 1NF/2NF/3NF: one message per row, depends only on notification_id
CREATE TABLE Notifications (
    notification_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    message VARCHAR(150) NOT NULL,
    is_read TINYINT(1) DEFAULT 0,
    sent_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- ================= SAMPLE DATA =================

INSERT INTO Banks (bank_name, ifsc_prefix) VALUES
('State Bank of India','SBIN0'),
('HDFC Bank','HDFC0'),
('ICICI Bank','ICIC0'),
('Axis Bank','UTIB0'),
('Punjab National Bank','PUNB0'),
('Kotak Mahindra Bank','KKBK0'),
('Bank of Baroda','BARB0'),
('Canara Bank','CNRB0');

INSERT INTO TransactionStatus (status_name) VALUES ('SUCCESS'),('FAILED'),('PENDING');

INSERT INTO Users (full_name, mobile_number, email, gender, dob, city) VALUES
('Ramesh Kumar','9876543210','ramesh.kumar@mail.com','M','1990-05-14','Hyderabad'),
('Priya Sharma','9876543211','priya.sharma@mail.com','F','1992-08-21','Mumbai'),
('Amit Verma','9876543212','amit.verma@mail.com','M','1988-01-10','Delhi'),
('Sneha Reddy','9876543213','sneha.reddy@mail.com','F','1995-03-30','Hyderabad'),
('Arjun Nair','9876543214','arjun.nair@mail.com','M','1991-11-02','Kochi'),
('Kavita Iyer','9876543215','kavita.iyer@mail.com','F','1993-07-19','Chennai'),
('Rohit Singh','9876543216','rohit.singh@mail.com','M','1989-09-25','Lucknow'),
('Anjali Gupta','9876543217','anjali.gupta@mail.com','F','1994-02-17','Delhi'),
('Vikram Rao','9876543218','vikram.rao@mail.com','M','1987-12-05','Bengaluru'),
('Neha Joshi','9876543219','neha.joshi@mail.com','F','1996-06-23','Pune'),
('Suresh Pillai','9876543220','suresh.pillai@mail.com','M','1985-04-11','Kochi'),
('Deepa Menon','9876543221','deepa.menon@mail.com','F','1990-10-08','Chennai'),
('Manoj Yadav','9876543222','manoj.yadav@mail.com','M','1993-01-27','Kanpur'),
('Pooja Chawla','9876543223','pooja.chawla@mail.com','F','1997-05-15','Delhi'),
('Sanjay Mehta','9876543224','sanjay.mehta@mail.com','M','1986-08-09','Ahmedabad');

INSERT INTO Wallets (user_id, balance) VALUES
(1,5000),(2,3200),(3,1500),(4,7800),(5,2200),(6,4100),(7,900),(8,6600),
(9,1200),(10,3300),(11,500),(12,8800),(13,2700),(14,1900),(15,4500);

INSERT INTO BankAccounts (user_id, bank_id, account_number, account_type, is_primary) VALUES
(1,1,'SBIN0001001','SAVINGS',1),
(2,2,'HDFC0002002','SAVINGS',1),
(3,3,'ICIC0003003','SAVINGS',1),
(4,1,'SBIN0004004','SAVINGS',1),
(5,4,'UTIB0005005','SAVINGS',1),
(6,3,'ICIC0006006','SAVINGS',1),
(7,5,'PUNB0007007','SAVINGS',1),
(8,2,'HDFC0008008','SAVINGS',1),
(9,6,'KKBK0009009','SAVINGS',1),
(10,1,'SBIN0010010','SAVINGS',1),
(11,7,'BARB0011011','SAVINGS',1),
(12,3,'ICIC0012012','SAVINGS',1),
(13,8,'CNRB0013013','SAVINGS',1),
(14,4,'UTIB0014014','SAVINGS',1),
(15,2,'HDFC0015015','SAVINGS',1),
(1,2,'HDFC0001016','CURRENT',0),
(3,1,'SBIN0003017','CURRENT',0),
(8,6,'KKBK0008018','CURRENT',0),
(9,1,'SBIN0009019','CURRENT',0),
(12,4,'UTIB0012020','CURRENT',0);

INSERT INTO UPI_IDs (user_id, account_id, vpa) VALUES
(1,1,'ramesh.kumar@sbi'),(2,2,'priya.sharma@hdfc'),(3,3,'amit.verma@icici'),
(4,4,'sneha.reddy@sbi'),(5,5,'arjun.nair@axis'),(6,6,'kavita.iyer@icici'),
(7,7,'rohit.singh@pnb'),(8,8,'anjali.gupta@hdfc'),(9,9,'vikram.rao@kotak'),
(10,10,'neha.joshi@sbi'),(11,11,'suresh.pillai@bob'),(12,12,'deepa.menon@icici'),
(13,13,'manoj.yadav@canara'),(14,14,'pooja.chawla@axis'),(15,15,'sanjay.mehta@hdfc'),
(1,16,'ramesh.biz@hdfc'),(3,17,'amit.biz@sbi'),(9,19,'vikram.biz@sbi');

INSERT INTO Merchants (merchant_name, category, merchant_vpa, city) VALUES
('Annapurna Kirana Store','Grocery','annapurna@icici','Hyderabad'),
('Spice Route Restaurant','Food','spiceroute@hdfc','Mumbai'),
('Metro Fashion Hub','Clothing','metrofashion@sbi','Delhi'),
('Green Grocers','Grocery','greengrocers@axis','Chennai'),
('City Electronics','Electronics','cityelectronics@icici','Bengaluru'),
('Daily Needs Supermarket','Grocery','dailyneeds@hdfc','Pune'),
('Royal Petrol Pump','Fuel','royalpetrol@sbi','Lucknow'),
('QuickBite Cafe','Food','quickbite@kotak','Kochi');

-- Transactions: mix of P2P, merchant, recharge, bill types
INSERT INTO Transactions (sender_id, receiver_user_id, merchant_id, amount, transaction_type, status_id, remarks) VALUES
(1,2,NULL,500,'P2P',1,'Lunch split'),
(2,3,NULL,1200,'P2P',1,'Rent share'),
(3,NULL,1,350,'MERCHANT',1,'Grocery'),
(4,5,NULL,700,'P2P',1,'Gift'),
(5,NULL,2,850,'MERCHANT',1,'Dinner'),
(6,NULL,3,2000,'MERCHANT',1,'Shopping'),
(7,8,NULL,150,'P2P',2,'Failed transfer'),
(8,NULL,4,600,'MERCHANT',1,'Vegetables'),
(9,10,NULL,3000,'P2P',1,'Loan repay'),
(10,NULL,5,4500,'MERCHANT',1,'Mobile phone'),
(11,NULL,NULL,199,'RECHARGE',1,'Prepaid recharge'),
(12,NULL,NULL,499,'RECHARGE',1,'DTH recharge'),
(13,NULL,NULL,1200,'BILL',1,'Electricity bill'),
(14,NULL,6,900,'MERCHANT',1,'Groceries'),
(15,1,NULL,250,'P2P',1,'Movie ticket'),
(1,NULL,7,1000,'MERCHANT',1,'Fuel'),
(2,NULL,8,300,'MERCHANT',1,'Coffee'),
(3,4,NULL,450,'P2P',3,'Pending transfer'),
(4,NULL,1,220,'MERCHANT',1,'Snacks'),
(5,6,NULL,800,'P2P',1,'Split bill'),
(6,NULL,NULL,299,'RECHARGE',1,'Postpaid bill'),
(7,NULL,2,650,'MERCHANT',1,'Dinner'),
(8,9,NULL,1500,'P2P',1,'Rent'),
(9,NULL,3,1800,'MERCHANT',1,'Shopping'),
(10,11,NULL,300,'P2P',2,'Failed'),
(11,NULL,4,400,'MERCHANT',1,'Grocery'),
(12,NULL,NULL,199,'RECHARGE',1,'Data pack'),
(13,14,NULL,600,'P2P',1,'Gift'),
(14,NULL,5,2500,'MERCHANT',1,'Electronics'),
(15,NULL,NULL,1000,'BILL',1,'Water bill');

INSERT INTO Beneficiaries (user_id, beneficiary_user_id, nickname) VALUES
(1,2,'Priya'),(1,3,'Amit'),(2,1,'Ramesh'),(4,5,'Arjun'),(5,4,'Sneha'),
(6,7,'Rohit'),(8,9,'Vikram'),(9,8,'Anjali'),(10,11,'Suresh'),(13,14,'Pooja');

INSERT INTO Bills (user_id, biller_name, bill_type, amount, due_date, is_paid) VALUES
(1,'TSSPDCL Electricity','ELECTRICITY',1200,'2026-07-15',1),
(2,'BEST Electricity','ELECTRICITY',950,'2026-07-10',0),
(3,'Delhi Jal Board','WATER',300,'2026-07-12',1),
(4,'Airtel Postpaid','MOBILE',499,'2026-07-08',1),
(5,'Tata Sky DTH','DTH',350,'2026-07-20',0),
(6,'Indane Gas','GAS',900,'2026-07-18',0),
(7,'UPPCL Electricity','ELECTRICITY',1100,'2026-07-14',1),
(8,'Jio Postpaid','MOBILE',599,'2026-07-11',1),
(9,'BWSSB Water','WATER',280,'2026-07-16',0),
(10,'MSEB Electricity','ELECTRICITY',1350,'2026-07-09',1);

INSERT INTO Cashback (transaction_id, cashback_amount) VALUES
(1,10),(3,5),(5,15),(6,40),(8,10),(10,90),(14,18),(16,20),(19,5),(24,35);

INSERT INTO Rewards (user_id, points, reason) VALUES
(1,50,'Transaction milestone'),(2,30,'Referral bonus'),(3,20,'First transaction'),
(4,45,'Bill payment'),(5,25,'Cashback bonus'),(6,60,'Monthly top spender'),
(7,10,'Recharge reward'),(8,35,'Merchant payment'),(9,55,'Loyalty bonus'),
(10,15,'Offer claim');

INSERT INTO Offers (offer_title, discount_percent, valid_till) VALUES
('Flat 10% off on Grocery',10,'2026-08-31'),
('Recharge Cashback 5%',5,'2026-07-31'),
('Dining Offer 15%',15,'2026-09-15'),
('Fuel Offer 2%',2,'2026-07-25'),
('Electronics Sale 20%',20,'2026-08-10'),
('Bill Payment Cashback',8,'2026-07-28');

INSERT INTO OfferClaims (user_id, offer_id) VALUES
(1,1),(2,2),(3,3),(4,1),(5,4),(6,5),(7,2),(8,6),(9,1),(10,3);

INSERT INTO Notifications (user_id, message, is_read) VALUES
(1,'You received Rs.500 from Priya Sharma',1),
(2,'You sent Rs.1200 to Amit Verma',1),
(3,'Payment of Rs.350 to Annapurna Kirana Store successful',0),
(4,'Cashback of Rs.15 credited',0),
(5,'Your bill payment is due tomorrow',0),
(6,'New offer available: Dining Offer 15%',1),
(7,'Transaction failed, please retry',0),
(8,'Reward points credited: 35',1),
(9,'Loan repayment received',1),
(10,'Recharge successful for 9876543219',1),
(11,'Welcome to QuickUPI!',1),
(12,'KYC verification pending',0);

-- ================= ALTER TABLE DEMO =================
ALTER TABLE Users ADD COLUMN pin_code VARCHAR(6) NULL;
ALTER TABLE Merchants ADD COLUMN is_active TINYINT(1) DEFAULT 1;

-- RENAME TABLE demo (not run, would break later references)
-- RENAME TABLE Notifications TO UserNotifications;

-- DROP / TRUNCATE demo (not run, only for reference)
-- DROP TABLE SomeOldTable;
-- TRUNCATE TABLE Notifications;

-- ================= UPDATE / DELETE / REPLACE =================
UPDATE Users SET city = 'Hyderabad' WHERE user_id = 9;
DELETE FROM Notifications WHERE is_read = 1 AND notification_id = 2;
REPLACE INTO Notifications (notification_id, user_id, message, is_read) VALUES (1,1,'You received Rs.500 from Priya Sharma',1);

-- ================= OPERATORS =================
SELECT full_name, balance FROM Users JOIN Wallets USING(user_id) WHERE balance > 3000;
SELECT * FROM Transactions WHERE amount BETWEEN 500 AND 1500;
SELECT * FROM Merchants WHERE merchant_name LIKE 'City%';
SELECT * FROM Users WHERE city IN ('Delhi','Mumbai');
SELECT * FROM Users WHERE city NOT IN ('Delhi','Mumbai');
SELECT * FROM Users WHERE pin_code IS NULL;
SELECT * FROM Users u WHERE EXISTS (SELECT 1 FROM Transactions t WHERE t.sender_id = u.user_id);

-- ================= BASIC QUERIES =================
SELECT DISTINCT city FROM Users;
SELECT full_name, city FROM Users ORDER BY full_name LIMIT 5;
SELECT full_name AS name, mobile_number AS mobile FROM Users;
SELECT city, COUNT(*) AS total_users FROM Users GROUP BY city HAVING COUNT(*) > 1;
SELECT transaction_id, amount,
  CASE WHEN amount >= 1000 THEN 'High' WHEN amount >= 500 THEN 'Medium' ELSE 'Low' END AS amount_level
FROM Transactions;
SELECT full_name, IFNULL(pin_code,'Not Set') AS pin_code FROM Users;

-- ================= JOINS =================
SELECT t.transaction_id, u.full_name AS sender, t.amount
FROM Transactions t INNER JOIN Users u ON t.sender_id = u.user_id;

SELECT u.full_name, w.balance
FROM Users u LEFT JOIN Wallets w ON u.user_id = w.user_id;

SELECT m.merchant_name, t.amount
FROM Transactions t RIGHT JOIN Merchants m ON t.merchant_id = m.merchant_id;

-- Self join: find beneficiary pairs with names
SELECT u1.full_name AS user_name, u2.full_name AS beneficiary_name
FROM Beneficiaries b
JOIN Users u1 ON b.user_id = u1.user_id
JOIN Users u2 ON b.beneficiary_user_id = u2.user_id;

-- ================= SUBQUERIES =================
-- Single row
SELECT full_name FROM Users WHERE user_id = (SELECT sender_id FROM Transactions ORDER BY amount DESC LIMIT 1);
-- Multi row
SELECT full_name FROM Users WHERE user_id IN (SELECT sender_id FROM Transactions WHERE amount > 2000);
-- Correlated
SELECT full_name FROM Users u WHERE EXISTS
  (SELECT 1 FROM Bills b WHERE b.user_id = u.user_id AND b.is_paid = 0);

-- ================= AGGREGATE FUNCTIONS =================
SELECT COUNT(*) AS total_transactions, SUM(amount) AS total_amount,
       AVG(amount) AS avg_amount, MIN(amount) AS min_amount, MAX(amount) AS max_amount
FROM Transactions;

-- ================= STRING FUNCTIONS =================
SELECT CONCAT(full_name, ' - ', city) AS user_info FROM Users LIMIT 5;
SELECT UPPER(full_name) AS upper_name, LOWER(email) AS lower_email FROM Users LIMIT 5;
SELECT SUBSTRING(mobile_number, 1, 5) AS partial_number FROM Users LIMIT 5;
SELECT LENGTH(full_name) AS name_length, TRIM('  QuickUPI  ') AS trimmed_text FROM Users LIMIT 3;

-- ================= DATE FUNCTIONS =================
SELECT CURDATE() AS today, NOW() AS current_datetime;
SELECT transaction_id, DATE(transaction_date) AS txn_date, YEAR(transaction_date) AS txn_year
FROM Transactions LIMIT 5;
SELECT bill_id, due_date, DATEDIFF(due_date, CURDATE()) AS days_left FROM Bills;
SELECT DATE_ADD(CURDATE(), INTERVAL 7 DAY) AS next_week;

-- ================= NUMERIC FUNCTIONS =================
SELECT ROUND(AVG(amount),2) AS avg_rounded, ABS(-500) AS abs_value, MOD(10,3) AS mod_value FROM Transactions;

-- ================= INDEXES =================
CREATE INDEX idx_users_mobile ON Users(mobile_number);
CREATE INDEX idx_users_email ON Users(email);
CREATE INDEX idx_upi_vpa ON UPI_IDs(vpa);
CREATE INDEX idx_txn_date ON Transactions(transaction_date);
CREATE INDEX idx_merchant_name ON Merchants(merchant_name);

-- ================= FUNCTION =================
DELIMITER //
CREATE FUNCTION fn_calculate_cashback(p_amount DECIMAL(10,2))
RETURNS DECIMAL(8,2)
DETERMINISTIC
BEGIN
    RETURN ROUND(p_amount * 0.02, 2);
END //
DELIMITER ;

-- ================= PROCEDURES =================
DELIMITER //
CREATE PROCEDURE sp_transfer_money(
    IN p_sender_id INT, IN p_receiver_id INT, IN p_amount DECIMAL(10,2)
)
BEGIN
    START TRANSACTION;
    -- wallet balance is updated automatically by trg_update_wallet_after_txn
    INSERT INTO Transactions (sender_id, receiver_user_id, amount, transaction_type, status_id)
    VALUES (p_sender_id, p_receiver_id, p_amount, 'P2P', 1);
    COMMIT;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_pay_bill(IN p_bill_id INT)
BEGIN
    DECLARE v_user_id INT;
    DECLARE v_amount DECIMAL(10,2);
    SELECT user_id, amount INTO v_user_id, v_amount FROM Bills WHERE bill_id = p_bill_id;
    UPDATE Wallets SET balance = balance - v_amount WHERE user_id = v_user_id;
    UPDATE Bills SET is_paid = 1 WHERE bill_id = p_bill_id;
    INSERT INTO Transactions (sender_id, merchant_id, amount, transaction_type, status_id)
    VALUES (v_user_id, NULL, v_amount, 'BILL', 1);
END //
DELIMITER ;

-- ================= REPORTS =================
-- Top 5 spending users
SELECT u.full_name, SUM(t.amount) AS total_spent
FROM Transactions t JOIN Users u ON t.sender_id = u.user_id
GROUP BY u.full_name ORDER BY total_spent DESC LIMIT 5;

-- Most used banks
SELECT b.bank_name, COUNT(*) AS accounts_count
FROM BankAccounts ba JOIN Banks b ON ba.bank_id = b.bank_id
GROUP BY b.bank_name ORDER BY accounts_count DESC;

-- Failed transactions report
SELECT t.* FROM Transactions t JOIN TransactionStatus s ON t.status_id = s.status_id
WHERE s.status_name = 'FAILED';

-- Users without bank accounts
SELECT u.full_name FROM Users u
LEFT JOIN BankAccounts ba ON u.user_id = ba.user_id
WHERE ba.account_id IS NULL;

-- Users with multiple bank accounts
SELECT user_id, COUNT(*) AS account_count FROM BankAccounts
GROUP BY user_id HAVING COUNT(*) > 1;

-- Monthly transaction report
SELECT MONTH(transaction_date) AS txn_month, COUNT(*) AS txn_count, SUM(amount) AS total_amount
FROM Transactions GROUP BY MONTH(transaction_date);

-- ================= ADVANCED QUERIES =================
-- UNION: combine sender and receiver user ids into one list
SELECT sender_id AS user_id FROM Transactions
UNION
SELECT receiver_user_id AS user_id FROM Transactions WHERE receiver_user_id IS NOT NULL;

-- Derived table example
SELECT city, avg_balance FROM (
    SELECT u.city, AVG(w.balance) AS avg_balance
    FROM Users u JOIN Wallets w ON u.user_id = w.user_id
    GROUP BY u.city
) AS city_avg
WHERE avg_balance > 2000;
















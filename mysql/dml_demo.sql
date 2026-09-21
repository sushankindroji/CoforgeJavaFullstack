# DML Operations - INSERT , UPDATE , DELETE

-- The INSERT statement allows you to insert one or more rows into a table. 
-- The following illustrates the syntax of the INSERT statement:

/*INSERT INTO table(c1,c2,...)
VALUES (v1,v2,...); */

desc departments;

-- Insert demo without specifying column names
USE classicmodels;

CREATE TABLE customersbackup2025 AS SELECT * FROM customers ;

DESC customersbackup2025;

INSERT INTO customersbackup2025 values(
		9999,'Raj Associates','GS','Raj','8765349019','Shri Nilaya',
		'Down Town Lane','Udupi','Karnataka','574101','India',NULL,50000.00);

SELECT * FROM customersbackup2025;

USE coforgedb;
SELECT * FROM departments;

INSERT INTO departments values(100,'Technical');

INSERT INTO departments values(104,'Production');

INSERT INTO departments values(105,'Travel');

SELECT * FROM departments;

-- Insert demo specifying columns fields

DESC department;

INSERT INTO department(deptName,fees,email) VALUES('Mech',75000,'mech@vtu.ac.in');

INSERT INTO department(deptName,fees,email) VALUES('EE',90000,'ee@vtu.ac.in');

INSERT INTO department(deptName,fees,email) VALUES('CSE',100000,'cse@vtu.ac.in');

SELECT * FROM department;


/*
The UPDATE statement updates data in a table. 
It allows you to change the values in one or more columns of a single row or multiple rows.

 syntax of the UPDATE statement:

UPDATE  table_name 
SET 
    column_name1 = expr1,
    column_name2 = expr2,
    ...
[WHERE
    condition];
*/

USE classicmodels;

SELECT * FROM employees WHERE employeeNumber=1401;

-- Update lastName, emailid of Pamela

update employees set lastname='george', email='pamela.g@classicmodelcars.com' where employeenumber=1401;

select * from employees where employeenumber=1401;

-- Update email domain of all Sales Reps with office code 6
--  to @sydneyclassicmodelcars.com

SELECT * FROM employees WHERE officeCode=6;
SELECT * FROM offices WHERE officeCode=6;

update employees set email=replace(email,'@classicmodelcars.com','@sydneyclassicmodelcars.com') where jobTitle='sales rep' and officecode=6;

SELECT * FROM employees WHERE officeCode=6;




# DELETE statement
 /*To delete data from a table, you use the MySQL DELETE statement. 
 
 syntax of the DELETE statement:

DELETE FROM table_name
WHERE condition;  */

USE coforgedb;

SELECT * FROM departments;

-- Delete Travel department


SELECT * FROM departments;

USE classicmodels;

SELECT * FROM customersbackup2025;  -- 123 records



SELECT count(*) FROM customersbackup2025; -- 118  records

-- delete all records


delete from departments where dept_id=105;

SELECT * FROM departments;

-- Using LIMIT clause in delete

CREATE TABLE customersbackupfrance AS SELECT * FROM customers;

SELECT * FROM customersbackupfrance;

SELECT * FROM customersbackupfrance  WHERE country='France'; -- 12 customers


-- Delete customers from France with low 5 Credit Limit

delete from customersbackupfrance where country='France' order by creditlimit limit 5;


-- Deleting Table

# Drop statement removes the table permanently from database

drop table employeesbackup2025;
show tables;
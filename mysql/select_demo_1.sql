/* MySQL/MariaDB is a RDBMS software used to Store & Manage data.

MySQl founder- Michael Widenius. His 2 daughters - My  & Maria

/* Heidi SQL - It's an IDE for working with MariaDB. It's installed 		automatically.
/*     -  It's an IDE for working with MySQL. It's an standalone Installation*/
/*


*/
/*Data is information such as facts and numbers used to analyze something or make decisions.*/
/*
Database is merely a structured collection of data.
Database is a collection of inter-related Tables.
Table is a collection of Records.
Record is a collection of fields.

The data relating to each other by nature, e.g., a product belonged to a product 
category and associated with multiple tags. Therefore, we use the term relational database.
A table may relate to another table using a relationship
*/

/* Eg:
 classicmodels- Database
 employees,customers,offices,products - Tables
*/
/*An RDBMS is a type of database management system (DBMS) that stores data in a 
row-based table structure which connects related data elements. 

SQL- SQL is a standard language for storing, manipulating and retrieving data in databases.

   DML - SELECT, INSERT, UPDATE, DELETE
   DDL- CREATE,ALTER,DROP
   TCL - COMMIT, ROLLBACK, SAVEPOINT
   DCL - GRANT REVOKE
   
   
# The SELECT statement allows you to retreieve data from one or more tables
-- Select Statements Syntax

-- SELECT select_list FROM table_name;
*/

use classicmodels;

 /* selection  - select all columns/records */
select * from customers;

select * from employees;

 /* projection -- select specific columns */
select lastName from employees;
 
select productCode,productName,buyPrice from products;

#display structure of the table




#----------------------------------------------------------------
-- Filter Records

#MySQL WHERE clause

-- The WHERE clause allows you to specify a search condition for the rows 
-- returned by a query.
# Syntax :
/*  SELECT 
    select_list
FROM
    table_name
WHERE
    search_condition;  */



-- Display Sales rep's in the organization
select * from employees where jobTitle='Sales Rep';


-- Display orders with quantity greater then 50

SELECT * FROM orderdetails;

select * from orderdetails where quantityordered>50;


/* The search_condition is a combination of one or more predicates using the 
logical operator AND, OR and NOT.

AND- All conditions should be TRUE
OR - Any one of the conditions should be TRUE.
NOT - Negate the Condition .
 */

/* Example uses the WHERE clause to find employees whose job titles are 
Sales Rep and office codes are 1 */

select * from employees where jobtitle='Sales Rep' and officecode=1;


select * from orderdetails where quantityordered>50 and priceeach>100;

-- OR operator
 -- query finds employees whose job title is Sales Rep or employees who 
 -- locate the office with office code 1:
 
select * from employees where jobTitle='Sales Rep' or officecode=1;
	
			
-- The BETWEEN operator returns TRUE if a value is in a range of values:
 
 -- Syntax: expression BETWEEN low AND high
 
 -- query finds employees who locate in offices whose office code is from 1 to 3:


select employeenumber,lastname,firstname,jobtitle,email,officecode from employees where officecode between 1 and 3;



-- query to list orders done in the first quarter of 2004 .
SELECT * FROM orders;

select * from orders where shippeddate between '2004-01-01' and '2004-03-31';


# MySQL WHERE with the LIKE operator
 
 /* The LIKE operator evaluates to TRUE if a value matches a specified pattern. 
 To form a pattern, you use % and _ wildcards. 
 The % wildcard matches any string of zero or more characters 
 while the _ wildcard matches any single character. */
 
 -- query finds employees whose last names end with the string 'son':

select employeenumber,lastname,firstname,jobtitle,email,officecode from employees where lastname like '%son';
 
select employeenumber,lastname,firstname,jobtitle,email,officecode from employees where lastname like 'B%';

-- ANSI SQL is Case Insensitive

select employeenumber,lastname,firstname,jobtitle,email,officecode from employees where lastname like 'B%' or firstname like 'd%';

select employeenumber,lastname,firstname,jobtitle,email,officecode from employees where firstname like '_arry';

-- NOT -- Negates the condition




	
#MySQL WHERE clause with the IN operator

-- The IN operator returns TRUE if a value matches any value in a list.
-- Syntax
-- value IN (value1, value2,...)

-- IN condition is used to help reduce the need to use multiple OR conditions in a 
-- SELECT, INSERT, UPDATE, or DELETE statement.

-- Query to display employees working in offices 1,5 & 7.

use classicmodels;
select employeenumber,lastname,firstname,jobtitle,email,officeCode from employees where -- officeCode=1 OR officeCode=5 or officeCode=7;
officecode in(1,5,7);
				
select * from customers where contactlastname in('Young','Smith')	


#MySQL WHERE  clause with the IS NULL operator
-- Null -> Absence of Data or Data is missing

/* To check if a value is NULL or not, you use the IS NULL operator, 
not the equal operator (=). The IS NULL operator returns TRUE if a value is NULL.

Syntax: 
value IS NULL  */ 		
		
-- Display employees who doesn't have Managers allocated		
SELECT employeeNumber,lastname,firstname,jobTitle,email,reportsTo
			FROM employees where reportsTo IS null;
						

SELECT * FROM orders;

select * from orders where comments is null;
select * from orders where comments is not null;

SELECT * FROM orders WHERE COMMENTs=" "; -- NOT considered AS NUll

SELECT * FROM customers WHERE phone=0; -- NOT considered AS NUll

SELECT * FROM customers WHERE phone IS NULL;


#WHERE clause with comparison operators
-- >, <, >=, <=, =, <> or != (not equals)

SELECT employeeNumber,lastname,firstname,jobTitle,email,reportsTo
			FROM employees where jobtitle <> 'sales rep';
						
						
DESC products;	
SELECT * FROM products;
SELECT * FROM products where buyprice>=50 and buyprice<=150;				


#---------------------------------------------------------------------------------
#MySQL ORDER BY clause
-- When you use the SELECT statement to query data from a table, 
-- the result set is not sorted. It means that the rows in the result set can 
-- be in any order.

-- To sort the result set, you add the ORDER BY clause to the SELECT statement
/* Syntax:
SELECT   select_list FROM    table_name
ORDER BY 
   column1 [ASC|DESC], 
   column2 [ASC|DESC],
   ...;  */

SELECT contactLastName, contactFirstName FROM customers;

-- sorts in ascending order
select contactLastName, contactFirstName FROM customers order by contactlastname;

-- sort in descending order
select contactLastName, contactFirstName FROM customers order by contactlastname desc;


SELECT * FROM products;


select * from products order by buyprice desc;


-- Sorting by Relative position in resultSet

select productcode,productname,quantityinstock,buyprice from products order by 3 desc;

-- Multi Level Sorting

select contactlastname,contactfirstname from customers order by contactfirstname,contactlastname desc;


#  ORDER BY to sort a result set by an expression	
SELECT * FROM orderdetails;

select ordernumber,productcode,quantityordered*priceeach from orderdetails order by quantityordered*priceeach;



-- Expressions with alias names
select ordernumber,productcode,quantityordered*priceeach 'total price' from orderdetails order by 'total price';

	
# ------------------------------------------------------------------------
# MySQL DISTINCT clause

-- When querying data from a table, you may get duplicate rows. 
-- In order to remove these duplicate rows, 
-- you use the DISTINCT clause in the SELECT statement.

/* Syntax: SELECT DISTINCT
    select_list
        FROM
    table_name;  */

SELECT lastname FROM employees ORDER BY lastname;

SELECT distinct lastname FROM employees ORDER BY lastname;



-- Distinct with multiple columns

select contactlastname,state,city from customers where state is not null order by contactlastname,state,city;
						
select distinct contactlastname,state,city from customers where state is not null order by contactlastname,state,city;					
						

# -------------------------------------------------------------------------------
# LIMIT clause
-- is used to retrieve records from one or more tables in a database and limit the number
--  of records returned based on a limit value.

SELECT * FROM customers;

SELECT * FROM customers limit 5;

SELECT * FROM customers order by contactlastname limit 10;


# The offset keyword allows you to offset the no. of record returned by 
-- the LIMIT clause.

select * from customers limit 5 offset 4;


# -------------------------------------------------------------------------

# MySQL AND operator
 /* The AND operator is a logical operator that combines two or more Boolean 
 expressions and returns true only if both expressions evaluate to true. 
 The AND operator returns false if one of the two expressions evaluate to false. */

 -- Syntax: boolean_expression_1 AND boolean_expression_2

select 1=0 and 1/1;

select customername,country,state from customers where country='USA'and state='CA';

select customername,country,state from customers where country='USA'and state='CA' AND   creditlimit>100000;

# The MySQL OR operator combines two Boolean expressions and returns true when 
# either condition is true.
-- Operator Precedence OR then AND

select customername,country,state from customers where country='USA' or state='France';


	
# -----------------------------------------------------------------------------------------

# MySQL alias for columns
-- Sometimes, column names are so technical that make the query’s output very 
-- difficult to understand. To give a column a descriptive name, you can use a 
-- column alias.
	  
/* Syntax: 
SELECT 
   [column_1 | expression] AS descriptive_name
FROM table_name;  */

select concat(lastname,'...',firstname) from employees;

select concat(lastname,'...',firstname) as 'full name' from employees;

select concat(lastname,'...',firstname) 'full xname' from employees;

select concat(lastname,'...',firstname) Fullname from employees;


-- alias for columns
DESC products;

select productcode,productname,msrp 'maximum sell retail price' from products;



#----------------------------------------------------------------------------

# MySQL GROUP BY clause
 -- The GROUP BY clause groups a set of rows into a set of summary rows by values 
 -- of columns or expressions. The GROUP BY clause returns one row for each group. 
 -- In other words, it reduces the number of rows in the result set.
 
 /* You often use the GROUP BY clause with aggregate functions such as SUM, AVG, 
 MAX, MIN, and COUNT. The aggregate function that appears in the SELECT clause 
 provides information about each group. */
 
 /* Syntax: 
 SELECT c1, c2,..., cn, aggregate_function(ci)
FROM table
WHERE where_conditions
GROUP BY c1 , c2,...,cn; */
use classicmodels;

select status from orders;

select status,count(*) as total from orders group by status;

select count(*) 'total orders' from orders;

SELECT quantityinstock from products;

select productline,sum(quantityinstock) 'total quantity' from products group by productline;



 /* The GROUP BY clause is often used with an aggregate function to perform calculation and 
return a single value for each subgroup. */

-- Query to find sum of quantity of Products

select productline,sum(quantityinstock) from products group by productline;
 
select ordernumber,sum(quantityordered*priceeach) as total from orderdetails group by ordernumber;


-- Query to display total no. of customers from each city

select * from customers;

select city,count(*) from customers group by city;


 -- Design a query using max function to return name of the productLine
 -- and maximum buyPrice for each ProductLine
 
 

 SELECT productline, buyprice FROM products;
 
 SELECT productline, MAX(buyprice) FROM products GROUP BY productline;
 SELECT MAX(buyprice) FROM products;
 
 SELECT productline,buyprice FROM 
 	products WHERE buyprice=( SELECT MAX(buyprice) FROM products);
 -- Display total no of sales rep
 
 SELECT jobTitle, COUNT(*) AS total FROM employees WHERE 
 jobTitle='Sales Rep' ;
 
 SELECT jobTitle, COUNT(*) AS total FROM employees
 	 GROUP BY jobTitle ;


 
 

# --------------------------------------------------------------------

# Scalar Functions
-- MySQL Scalar Functions allow you to perform different calculations 
-- on data values. 
-- These functions operate on single rows only and produce one result 
-- per row.

/* String functions – functions that perform operations on character values.
Numeric functions – functions that perform operations on numeric values.
Date functions – functions that perform operations on date values.
Conversion functions – functions that convert column data types.
NULL-related Functions – functions for handling null values.
*/	


-- String Functions	
	
SELECT LENGTH('Hello World');	

SELECT CONCAT('JDBC','SQL');

SELECT INSTR('JDBC','B'); -- Return location of substring in a string

SELECT TRIM('   SQL   JDBC');  -- truncates or removes extra spaces
	
SELECT LENGTH('   SQL');	

SELECT SUBSTR('JDBC Programming',1,2); -- Returns part of a string - specific pos,no. of characters







-- Date Functions
SELECT NOW(), CURRENT_DATE, SYSDATE();

SELECT productName,buyPrice,NOW() DispatchDate FROM products;

-- DATEDIFF function calculates the number of days between two dates
            
SELECT DATEDIFF(CURRENT_DATE,'2026-02-01') NoOfDays;

SELECT * FROM orders;

-- To calculate the number of days between the required date and 
-- shipped date of the orders


		
		
-- gets all orders whose statuses are in-process and calculates the number of 
-- days between ordered date and required date



-- -- The DAY() function returns the day of the month of a given date. 

SELECT DAY(NOW());

SELECT DAY('2026-02-22');

SELECT DAYNAME(NOW()), WEEKDAY(CURRENT_DATE); -- weekday starts from monday -0

-- return the number of orders by day number in 2004.




#Numeric Functions

-- The ABS() function is a mathematical function that returns the absolute (positive) 
-- value of a number.

SELECT ABS(-10), ABS(0), ABS(10), ABS(-9+5) , -9+5;

USE classicmodels;
SELECT * FROM products;



-- The ROUND() is a mathematical function that allows you to round a number 
-- to a specified number of decimal places.

SELECT ROUND(20.5), ROUND(20.7), ROUND(20.1), ROUND(20.4);

SELECT ROUND(20.567,2), ROUND(20.5,0), ROUND(3.142356,3);

-- The number of decimal places (d) can be positive or negative. 
-- If it is negative, then the d digits left of the decimal point of the number 
-- n becomes zero.

SELECT ROUND(121.55,-2) ,ROUND(161.55,-2), ROUND(2013.567,-3),ROUND(2588.567,-3);

SELECT* FROM orderdetails;


	 	
-- ceil() & Floor() 
-- The CEIL() function takes an input number and returns 
-- the smallest integer greater than or equal to that number.

-- FLOOR() -Returns the largest integer value not greater than the argument

SELECT FLOOR(59.9), FLOOR(53.3), CEIL(59.1);

SELECT productLine, CEIL(AVG(msrp)) averageMsrp , AVG(msrp) 
	FROM products
		GROUP BY productLine
			ORDER BY averageMsrp;


#Null Related Functions

-- IFNULL()  - Return the specified value IF the expression is NULL, 
-- otherwise return the expression

SELECT IFNULL(NULL, 'Hello'), IFNULL('Java','James'), IFNULL(NULL ,0),IFNULL(220,0);

SELECT customerName, city,state FROM customers;



SELECT * FROM payments;


# Conversion functions

-- FORMAT() -- Converts number in to a String
-- DATE_FORMAT() -Converts DATE  in to a String
-- CONVERT()  - Converting String to Number/dATE/TIME

SELECT DATE_FORMAT(NOW(),'%Y %M %m %D %d' ), NOW();  -- formating date

SELECT FORMAT(1002343,2), FORMAT(1002343.235,2);

SELECT CONVERT('100',UNSIGNED INTEGER), CONVERT('-100',SIGNED INTEGER);

SELECT CONVERT('2017-12-31',DATE), CONVERT('08:45:59',TIME);

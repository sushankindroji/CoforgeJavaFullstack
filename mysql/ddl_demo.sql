# DDL Commands - CREATE, ALTER, DROP, TRUNCATE, RENAME

/*Data Definition Language actually consists of the SQL commands that can be used to define the database schema. 
It simply deals with descriptions of the database schema and is used to create and modify the structure of database objects in the database.
DDL is a set of SQL commands used to create, modify, and delete database structures but not data. */

/*Create a db -- Follow normalization -- reduce rendundacy

1NF - Atomicity (Single Value), Primary Key

2NF - 1NF , Functional Dependency, Foreign Key

3NF - 2NF, No transive Dependency */

-- Create Database

create database coforgedb;
use coforgedb;

-- create table
create table user(id int primary key auto_increment,name varchar(25),email varchar(25));
describe user;

desc user;

create table department(deptid int primary key auto_increment,deptname varchar(25) not null, fees float not null, email varchar(25) not null);

-- Display structure of Table
desc department;

show tables;

-- create table & set primary key at field level

create table student(rollno int(10) primary key,firstname varchar(25) not null, middlename varchar(25),lastname varchar(25) not null,dob date not null, did int not null);


DESC student;
SHOW TABLES;

# ALTER Table
-- The MySQL ALTER TABLE statement is used to add, modify, or drop/delete columns 
-- in a table. The MySQL ALTER TABLE statement is also used to rename a table.

/* Syntax:  Add column in table
 ALTER TABLE table_name
  ADD new_column_name column_definition
    [ FIRST | AFTER column_name ];  */
    
-- Add new column city  

alter table student add city varchar(20) not null after dob;

desc student;


-- Modify column in a table

alter table student modify city varchar(25) null;ALTER 

desc student;
	

-- Rename column in a table

alter table student change column middlename mid_name varchar(20) null;

desc student;

# drop a column in table

alter table student drop column mid_name;

desc student;

# rename table



-- Create a new Table copy from existing Table


-- Delete table
create table student_copy(rollno int(10) primary key,firstname varchar(25) not null, middlename varchar(25),lastname varchar(25) not null,dob date not null, did int not null);
show tables;
drop table student_copy;
show tables;

/* MySql Constraints:

The constraint in MySQL is used to specify the rule that allows or restricts what values/data will be stored in the table. 
They provide a suitable method to ensure data accuracy and integrity inside the table. 
It also helps to limit the type of data that will be inserted inside the table.
*/
# DEFAULT constraint - Specifies a default value when specified none for this column

/*
#Check constraint - It is an integrity constraint that controls the value in a particular column. 
It ensures the inserted or updated value in a column must be matched with the given condition.
*/

/*
#AUTO_INCREMENT Constraint
This constraint automatically generates a unique number whenever we insert a new record into the table. 
Generally, we use this constraint for the primary key field in a table.
*/

create table staff(id int primary key auto_increment, name varchar(25),email varchar(25),city varchar(20) default 'bangalore',doj datetime default now());
desc staff;
	
-- Inserting data into staff table which has auto_increment & default values	
	
insert into staff(name,email) values('raj','raj@training.com');
insert into staff(name,email) values('mike','mike@training.com');
insert into staff(name,email) values('mary','mary@training.com');

select * from staff;

-- insert data into default columns
insert into staff(name,email,city) values('navin','navi@training.com','mumbai');
insert into staff(name,email,city,doj) values('hary','hary@training.com','noida','2017-06-01');
select * from staff;

-- set the new seed value for AUTO_INCREMENT

alter table staff auto_increment=100;
insert into staff(name,email,city,doj) values('x','x@training.com','noida','2015-06-01');
select * from staff;

-- # Check Constraint
-- CHECK constraint to ensure that values stored in a column or group of 
-- columns satisfy a Boolean expression.
use coforgedb;
desc staff;

alter table staff add salary double(10,2) check(salary>10000) after doj;
alter table staff add gender char(10) check(gender in('male','female')) after doj;

desc staff;

-- Unique Constraint
/* A UNIQUE constraint is an integrity constraint that ensures values in a column 
or group of columns to be unique.  
A UNIQUE constraint can be either a column constraint or a table constraint. */

delete from staff;
alter table staff drop column phone;
alter table staff add phone int not null unique after salary;

desc staff;

-- throw check constraint error for gender
use coforgedb;
-- 1. Display all records
SELECT * FROM staff;

-- 2. This will throw PRIMARY KEY constraint error because Emp_ID = 200 already exists
INSERT INTO staff
VALUES (200, 'Raj', 'raj@test.com', 'Delhi', '2013-12-07', 'Male', 15000, 9876543210);

-- 3. Insert a new valid record
INSERT INTO staff
VALUES (203, 'Raj', 'raj@test.com', 'Delhi', '2018-12-07', 'Male', 15000, 9876543211);

-- 4. This will throw UNIQUE constraint error because Phone No. is already used
INSERT INTO staff
VALUES (204, 'Monty', 'monty@test.com', 'Chennai', '2017-12-07', 'Female', 19000, 9876543211);

-- 5. Insert another valid record with a unique phone number
INSERT INTO staff
VALUES (204, 'Monty', 'monty@test.com', 'Chennai', '2017-12-07', 'Male', 19000, 9876543212);

-- throw check constraint error for salary





-- throw PRIMARY KEY constraint error for ID


-- throw check constraint error for salary



-- throw unique constraint error for phone no




-- not null constraint 




--- Creating Foreign Key Relationship

CREATE TABLE departments (   -- primary table
	d_id INT PRIMARY KEY,
	dept_name VARCHAR(15) );

CREATE TABLE employees (       -- secondary table
	emp_id INT AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
	last_name  VARCHAR(50) NOT NULL,
	dob        DATE NOT NULL,
	status     TINYINT NOT NULL,
	description TEXT,
	doj TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	dept_id INT  NOT NULL,
	constraint fk_empDept foreign key(dept_id)
	references departments(d_id));


INSERT INTO departments VALUES(101,'CSE');
INSERT INTO departments VALUES(102,'Mech');
INSERT INTO departments VALUES(103,'EE');
SELECT * FROM departments;

INSERT INTO employees VALUES(1001,'Raj','Mark','2012-12-12',2,'Employees Salary and 
		Client payments',CURRENT_DATE, 101);

SELECT * FROM employees;


INSERT INTO employees VALUES(1002,'Mary','John','2012-12-12',2,'Electrician',
				CURRENT_DATE, 105);

INSERT INTO employees VALUES(1002,'Mary','John','2012-12-12',2,'Electrician',
				CURRENT_DATE, 103);

INSERT INTO employees VALUES(1003,'Jk','John','2012-12-12',2,'Electrician',
				CURRENT_DATE, 103);
				
SELECT * FROM employees;



/* The foreign key is used to link one or more than one table 
together. It is also known as the referencing key. 
A foreign key matches the primary key field of another table. 
It means a foreign key field in one table refers to the primary key 
field of the other table. */

/* 
Syntax: [CONSTRAINT constraint_name]  
    FOREIGN KEY [foreign_key_name] (col_name, ...)  
    REFERENCES parent_tbl_name (col_name,...)  
    ON DELETE referenceOption  
    ON UPDATE referenceOption  */

USE coforge;




-- foreign key error


/* CASCADE: It is used when we delete or update any row from the 
parent table, the values of the matching rows in the child table 
will be deleted or updated automatically.

RESTRICT: It is used when we delete or update any row from the parent
table that has a matching row in the reference(child) table, 
MySQL does not allow to delete or update rows in the parent table. */



-- cascade demo

USE coforgedb;
CREATE TABLE departments2 (   -- primary table
	d_id INT PRIMARY KEY,
	dept_name VARCHAR(15) );
	
CREATE TABLE employees2 (       -- secondary table
	emp_id INT AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
	last_name  VARCHAR(50) NOT NULL,
	dob        DATE NOT NULL,
	status     TINYINT NOT NULL,
	description TEXT,
	doj TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	dept_id INT  NOT NULL,
	CONSTRAINT fk_empDept2 FOREIGN KEY(dept_id)
	REFERENCES departments2(d_id)
	ON DELETE CASCADE
	ON UPDATE RESTRICT
	);

DESC employees2;
DESC departments2;

INSERT INTO departments2 VALUES(101,'CSE');
INSERT INTO departments2 VALUES(102,'Mech');
INSERT INTO departments2 VALUES(103,'EE');
SELECT * FROM departments2;

INSERT INTO employees2 VALUES(1001,'Raj','Mark','2012-12-12',2,'Employees Salary and 
		Client payments',CURRENT_DATE, 101);

SELECT * FROM employees2;
SELECT * FROM departments2;

INSERT INTO employees2 VALUES(1002,'Mary','John','2012-12-12',2,'Electrician',
				CURRENT_DATE, 103);

INSERT INTO employees2 VALUES(1003,'Jk','John','2012-12-12',2,'Electrician',
				CURRENT_DATE, 103);
				
SELECT * FROM employees2;
SELECT * FROM departments2;

DELETE FROM departments2 WHERE d_id=103; -- deletes department & employess bcoz of  on cascade

UPDATE departments2 SET d_id=111 WHERE d_id=101;

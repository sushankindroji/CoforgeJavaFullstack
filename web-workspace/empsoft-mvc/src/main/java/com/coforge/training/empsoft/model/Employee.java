package com.coforge.training.empsoft.model;

/*Creating a complete MVC-based CRUD application to manage Employee details 
* using Servlets, JSP, and JDBC
* 
* This Bean class represents an Employee entity

*/
public class Employee {
	
	 private int id;  
	 private String name,password,email,sex,country;
	 
	 //default constructor
	 public Employee() {
	 }

	 //Parameterized constructor
	 public Employee(int id, String name, String password, String email, String sex, String country) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.sex = sex;
		this.country = country;
	 }

	 public int getId() {
		 return id;
	 }

	 public void setId(int id) {
		 this.id = id;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public String getPassword() {
		 return password;
	 }

	 public void setPassword(String password) {
		 this.password = password;
	 }

	 public String getEmail() {
		 return email;
	 }

	 public void setEmail(String email) {
		 this.email = email;
	 }

	 public String getSex() {
		 return sex;
	 }

	 public void setSex(String sex) {
		 this.sex = sex;
	 }

	 public String getCountry() {
		 return country;
	 }

	 public void setCountry(String country) {
		 this.country = country;
	 }
	 
	 
	 
	 
	 

}

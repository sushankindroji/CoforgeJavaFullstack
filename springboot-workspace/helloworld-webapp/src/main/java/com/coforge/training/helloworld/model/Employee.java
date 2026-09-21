package com.coforge.training.helloworld.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Employee {
	private Long id;
    private String firstName;
    private String lastName;
    private String department;
    private String position;
    private Double salary;
    private LocalDate hireDate;
    private String email;
	public Employee() {
		super();
	}
	public Employee(Long id, String firstName, String lastName, String department, String position, Double salary,
			LocalDate hireDate, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.position = position;
		this.salary = salary;
		this.hireDate = hireDate;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    

    
    // Helper methods - Make sure they follow getter naming convention
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFormattedSalary() {
        return String.format("$%,.2f", salary);
    }

    public String getFormattedHireDate() {
        return hireDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }
    
    // Add a method to get department in lowercase for CSS classes
    public String getDepartmentClass() {
        return department.toLowerCase().replace(" ", "-");
    }

}

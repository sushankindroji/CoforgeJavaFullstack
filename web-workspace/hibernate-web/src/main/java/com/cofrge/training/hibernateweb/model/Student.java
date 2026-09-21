package com.cofrge.training.hibernateweb.model;

import jakarta.persistence.*;

//This class represents a Student entity in the system using Hibernate ORM 
//with Annotation configuration.
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password; 
	private String course;
	public Student() {
		super();
	}
	// getters and setters (unchanged)
	public int getId() { return id; }
	public String getName() { return name; }
	public String getEmail() { return email; }
	public String getPassword() { return password; }
	public String getCourse() { return course; }
	public void setId(int id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setEmail(String email) { this.email = email; }
	public void setPassword(String password) { this.password = password; }
	public void setCourse(String course) { this.course = course; }
}
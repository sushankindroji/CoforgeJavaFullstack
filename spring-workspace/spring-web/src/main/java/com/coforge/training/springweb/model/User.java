package com.coforge.training.springweb.model;

/**
 * Author :sushank2
 * Date :24-Jul-2026
 * Time :11:22:03 am
 * Project Name :spring-web
 */

public class User {

	private String name;
	private String email;
	private String password;
	private String gender;
	private String country;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	
}

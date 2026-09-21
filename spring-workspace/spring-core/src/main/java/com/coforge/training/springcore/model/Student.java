package com.coforge.training.springcore.model;

/**
* Author :sushank2
* Date :23-Jul-2026
* Time :11:40:17 am
* Project Name :spring-core
*/

public class Student {

	private int rollNo;
	private String name,college;
	private double marks;
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
}

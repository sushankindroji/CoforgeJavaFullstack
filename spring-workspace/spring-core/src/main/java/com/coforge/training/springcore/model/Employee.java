package com.coforge.training.springcore.model;

/**
 * Author : sushank2
 * Date   : 23-Jul-2026
 * Project: spring-core
 * 
 * Spring uses POJO based programming Model
 * Constructor Dependency Injection using XML configuration
 */

public class Employee {

    private int empId;
    private String name;
    private double salary;

    // Constructor for Constructor Injection
    public Employee(int empId, String name, double salary) {
        super();
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    public void display() {
        System.out.println("************** Employee Details **********");
        System.out.println(this.empId + " " + this.name + " " + this.salary);
    }
}
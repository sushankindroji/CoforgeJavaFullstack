package com.coforge.training.helloworld.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.training.helloworld.model.Employee;

/**
 * Author :sushank2
 * Date :28-Jul-2026
 * Time :12:53:19 pm
 * Project :helloworld-service
 */

@RestController
public class HelloWorldController {
	//http://localhost:8089/hello
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello from Hello World MicroService! 😍😍";
	}

	//http://localhost:8089/ajax
	@GetMapping("/ajax")
	public String sayHello1() {
		return "Hello from Ajax! 😍😍";
	}

	// http://localhost:8089/employees
	@GetMapping("/employees")
	public List<Employee>  getEmployees() {

		Employee emp1=new Employee(101, "James Gosling", 7777.00);
		Employee emp2=new Employee(102, "Gavin King", 8888.00);
		Employee emp3=new Employee(103, "Rod Johnson", 9999.00);
		Employee emp4=new Employee(104, "Jeurgen Hauler", 9999.00);
		Employee emp5=new Employee(105, "Martin Flower",11111.00);

		List<Employee> employees=new ArrayList<>();

		employees.add(emp1);employees.add(emp2);employees.add(emp3);
		employees.add(emp4);employees.add(emp5);


		return employees;
	}
}

package com.coforge.training.helloworld.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.training.helloworld.model.Employee;
import com.coforge.training.helloworld.service.HelloClient;

/**
 * Author :sushank2
 * Date :28-Jul-2026
 * Time :2:26:18 pm
 * Project :helloworld-clientservice
 */

@RestController
public class HelloWorldConsumerController {
	
	//instance of feign micro service communication
	private final HelloClient helloClient;

	public HelloWorldConsumerController(HelloClient helloClient) {
		super();
		this.helloClient = helloClient;
	}

	//Open Postman/Browser - http://localhost:8091/get-hello
	@GetMapping("/get-hello")	
	public String getMethodName() {
		return helloClient.getHello();
	}


	//Open Postman/Browser - http://localhost:8091/test
	@GetMapping("/test")
	public String getMethodName1() {
		return helloClient.myMethod();
	}

	//Open Postman/Browser - http://localhost:8091/get-employees
	@GetMapping("/get-employees")
	public List<Employee> getEmployees() {
		return helloClient.getEmployees();
	}
}

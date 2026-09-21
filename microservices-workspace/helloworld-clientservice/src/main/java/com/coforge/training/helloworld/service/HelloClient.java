package com.coforge.training.helloworld.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.coforge.training.helloworld.model.Employee;

/**
* Author :sushank2
* Date :28-Jul-2026
* Time :2:16:44 pm
* Project :helloworld-clientservice
*/

@FeignClient(name="helloworld-service")
public interface HelloClient {

	@GetMapping("/hello")
	String getHello();

	@GetMapping("/ajax")
	String myMethod();

	@GetMapping("/employees")
	List<Employee> getEmployees();

}
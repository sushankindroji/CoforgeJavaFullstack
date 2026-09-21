package com.coforge.training.helloworld.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.training.helloworld.model.Employee;

/**
 * Author : sushank2
 * Date : 25-Jul-2026
 * Time : 4:24:06 pm
 * Project : helloworld-webservice
 */

@RestController
public class EmployeeController {

    @GetMapping("/employees")
    public List<Employee> getEmployees() {

        Employee e1 = new Employee(101, "James", "Gosling", "gosling@sun.com");
        Employee e2 = new Employee(102, "Gavin", "King", "king@hibernate.com");
        Employee e3 = new Employee(103, "Rod", "Johnson", "rod@spring.com");
        Employee e4 = new Employee(104, "Navin", "Kumar", "navin@softtech.com");
        Employee e5 = new Employee(105, "Mary", "Thomas", "mary@sun.com");

        List<Employee> empList = new ArrayList<>();

        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        empList.add(e4);
        empList.add(e5);

        return empList;
    }
}
package com.coforge.training.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coforge.training.springcore.model.Employee;

/**
 * Author : sushank2
 * Date   : 23-Jul-2026
 * Project: spring-core
 * 
 * Spring Program to demonstrate Dependency Injection using Constructor
 */

public class EmployeeApp {

    public static void main(String[] args) {

        // Load Spring Configuration File
        ApplicationContext context = new ClassPathXmlApplicationContext("EmployeeConfig.xml");

        // Get Employee Beans
        Employee e1 = (Employee) context.getBean("emp1");
        e1.display();

        Employee e2 = (Employee) context.getBean("emp2");
        e2.display();

        Employee e3 = (Employee) context.getBean("emp3");
        e3.display();

        // Close the context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
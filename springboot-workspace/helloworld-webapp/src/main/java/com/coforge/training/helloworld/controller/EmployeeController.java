package com.coforge.training.helloworld.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.coforge.training.helloworld.model.Employee;


@Controller
public class EmployeeController {
	// Handle GET request for /employees - http://localhost:8084/employees
		 @GetMapping("/employees")
		    public String showEmployees(Model model) {
		        List<Employee> employees = getSampleEmployees();
		        model.addAttribute("employees", employees);
		        model.addAttribute("totalEmployees", employees.size());
		        model.addAttribute("currentDate", LocalDate.now());
		        return "employees"; // returns the view name "employees" with the model attributes
		    }

		 // Sample data for demonstration purposes - in a real application, data would come from a database
		    private List<Employee> getSampleEmployees() {
		        return Arrays.asList(
		            new Employee(1L, "John", "Doe", "Engineering", "Software Engineer", 
		                        85000.00, LocalDate.of(2022, 3, 15), "john.doe@company.com"),
		            new Employee(2L, "Jane", "Smith", "Marketing", "Marketing Manager", 
		                        75000.00, LocalDate.of(2021, 6, 1), "jane.smith@company.com"),
		            new Employee(3L, "Mike", "Johnson", "Sales", "Sales Representative", 
		                        65000.00, LocalDate.of(2023, 1, 10), "mike.johnson@company.com"),
		            new Employee(4L, "Sarah", "Williams", "HR", "HR Specialist", 
		                        70000.00, LocalDate.of(2020, 8, 22), "sarah.williams@company.com"),
		            new Employee(5L, "David", "Brown", "Engineering", "Senior Developer", 
		                        95000.00, LocalDate.of(2019, 11, 5), "david.brown@company.com"),
		            new Employee(6L, "Lisa", "Davis", "Finance", "Financial Analyst", 
		                        80000.00, LocalDate.of(2022, 9, 30), "lisa.davis@company.com")
		        );
		    }

}

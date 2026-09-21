package com.coforge.training.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
* Author :ajax
* Date :24-Jul-2026
* Time :4:15:16 pm
* Project :helloworld-webapp
*/
@Controller
public class HelloWorldController {
	//Open browserr & GET request -http://localhost:8084/vishnu
	@GetMapping("/ajax")
	 public String getMethodName(Model model) {
        model.addAttribute("name", "ajax");
        model.addAttribute("date", new java.util.Date());
        return "mypage";  
        
	}
	
	// Handle GET request for /hello - http://localhost:8084/hello
		@GetMapping("/hello")
	    public String hello(
	        @RequestParam(name = "name", required = false, defaultValue = "World from Spring Boot") String name,
	        Model model) {
	        
	        model.addAttribute("name", name);
	        return "hello"; //returns the view name "hello" with the model attribute "name"
	    }
	    
		// Redirect root URL to /hello - http://localhost:8084/
	    @GetMapping("/")
	    public String home() {
	        return "redirect:/hello"; // Redirects to /hello endpoint
	    }

}


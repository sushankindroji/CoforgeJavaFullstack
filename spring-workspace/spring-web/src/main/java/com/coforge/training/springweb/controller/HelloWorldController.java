package com.coforge.training.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author :sushank2
 * Date :23-Jul-2026
 * Time :4:25:05 pm
 * Project Name :spring-web
 */

@Controller
public class HelloWorldController {


	/*Work Flow of Spring MVC Application
	 * 
	 *   Client --> Request(index.jsp) --> FrontController(Web.xml) 
	 *    -->Controller(HelloWorldController) ---> response(hello.jsp) 
	 */

	@GetMapping("/ajax") //Mapping URL of th request to the method
	public String sayHello() {
		return "hello"; //returns hello.jsp
	}
	
	
	@GetMapping("/noida") //Mapping URL of th request to the method
	public String sayHello1() {
		return "noida"; //returns hello.jsp
	}
}
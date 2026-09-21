package com.coforge.training.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplication is a convenience annotation in Spring Boot that combines 
 * three other annotations into a single, easy-to-use annotation for your main 
 * application class: 
 * @Configuration, 
 * @EnableAutoConfiguration, 
 * and @ComponentScan. 
 * It is used on the main entry point of a Spring Boot application to enable 
 * auto-configuration based on classpath dependencies, register components found 
 * during a scan, and mark the class as a source of bean definitions.
 */

@SpringBootApplication
public class HelloworldWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldWebappApplication.class, args);
	}

}
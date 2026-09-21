package com.coforge.training.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* Author :sushank2
* Date :25-Jul-2026
* Time :4:09:20 pm
* Project :helloworld-webservice
*/

//It is used to handle REST Web Services
@RestController
public class HelloWorldController {

  /*Open Browser - http://localhost:8082/ */
  @GetMapping("/") //GET request
  public String sayHello() {
      return "Hello World from Spring Boot !!! 😊😊😊";
  }

  /*Open Browser - http://localhost:8082/raj */
  @GetMapping("/ajax") //GET request
  public String test() {
      return "Myself Ajax, Created my first Spring Boot Web API in Coforge Training";
  }

  /*Open Browser - http://localhost:8082/city */
  @GetMapping("/city") //GET request
  public String displayCity() {
      return "I am from Hyd";
  }
}
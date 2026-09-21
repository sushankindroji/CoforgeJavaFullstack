package com.coforge.training.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coforge.training.springcore.model.HelloWorld;

public class HelloWorldApp {

    public static void main(String[] args) {

        // Load the Spring configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("HelloWorldConfig.xml");

        // Get the beans from Spring container
        HelloWorld obj1 = (HelloWorld) context.getBean("hw1");
        System.out.println(obj1.getMsg());

        HelloWorld obj2 = (HelloWorld) context.getBean("hw2");
        System.out.println(obj2.getMsg());

        // Close the context to release resources
        ((ClassPathXmlApplicationContext) context).close();
    }
}
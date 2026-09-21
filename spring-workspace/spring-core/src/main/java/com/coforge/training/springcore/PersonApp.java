package com.coforge.training.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coforge.training.springcore.model.Person;

/**
* Author :sushank2
* Date :23-Jul-2026
* Time :12:20:37 pm
* Project Name :spring-core
* 
*
* Spring Program to demonstrate Dependency Injection using Setter using 
* Dependent Object - Class with has- a relationship
*
*/

public class PersonApp {

	public static void main(String[] args) {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("PersonConfig.xml");
		
		//Get the bean/object from xml file
		Person p1=(Person) context.getBean("person1");
		p1.display();
		
		Person p2=(Person) context.getBean("person2");
		p2.display();
		
		Person p3=(Person) context.getBean("person3");
		p3.display();
		
		((ClassPathXmlApplicationContext) context).close();
		

	}

}


package com.coforge.training.springcore;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coforge.training.springcore.model.Student;

/**
 * Author :sushank2
 * Date :23-Jul-2026
 * Time :11:50:18 am
 * Project Name :spring-core
 */

public class StudentApp {

	public static void main( String[] args )
	{

		ApplicationContext context=new ClassPathXmlApplicationContext("studentConfig.xml");

		//Get the Student Bean/Object from xml file
		Student obj1=(Student) context.getBean("student1");
		System.out.println(obj1.getMarks());
		Student obj2=(Student) context.getBean("student1");
		System.out.println(obj2.getRollNo());
		Student obj3=(Student) context.getBean("student1");
		System.out.println(obj3.getName());
		Student obj4=(Student) context.getBean("student1");
		System.out.println(obj4.getCollege());



		Student obj5=(Student) context.getBean("student2");
		System.out.println(obj5.getMarks());
		Student obj6=(Student) context.getBean("student2");
		System.out.println(obj6.getRollNo());
		Student obj7=(Student) context.getBean("student2");
		System.out.println(obj7.getName());
		Student obj8=(Student) context.getBean("student2");
		System.out.println(obj8.getCollege());


		((ClassPathXmlApplicationContext) context).close();
	}

}


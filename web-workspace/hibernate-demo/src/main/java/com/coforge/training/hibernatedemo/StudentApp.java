package com.coforge.training.hibernatedemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.training.hibernatedemo.model.Student;

/**
 * Hello world!
 *
 * Hibernate Application to save student entity in to Database
 */
public class StudentApp 
{
    public static void main( String[] args )
    {
    	
    	Configuration cfg=new Configuration();  
		cfg.configure("hibernate.cfg.xml");  
		
		SessionFactory sf=cfg.buildSessionFactory();  
		Session session=sf.openSession();  

		Transaction t=session.beginTransaction(); 

		Student s1=new Student();

		Scanner s=new Scanner(System.in);
		System.out.println("Enter Name, Branch & Marks :");

		String name=s.nextLine();
		String branch=s.next();
		float marks=s.nextFloat();

		s1.setName(name);
		s1.setBranch(branch);
		s1.setMarks(marks);

		s.close();

		session.save(s1);
		t.commit();
		System.out.println("Student Details successfully Saved to DB");
		session.close();
		sf.close();

    }
}

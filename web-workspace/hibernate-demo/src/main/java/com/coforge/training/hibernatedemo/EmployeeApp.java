package com.coforge.training.hibernatedemo;

/* Hibernate Application to demonstrate the usage of Hibernate ORM Tool
 * with Annotation Configuration to save Employee details in the database
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.coforge.training.hibernatedemo.model.Employee;

public class EmployeeApp {

    public static void main(String[] args) {

        // Create Configuration object
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        // Create SessionFactory
        SessionFactory sf = cfg.buildSessionFactory();

        // Open Session
        Session session = sf.openSession();

        // Begin Transaction
        Transaction tx = session.beginTransaction();

        // Create Employee object
        Employee e1 = new Employee();

        e1.setId(112);
        e1.setFirstName("John");
        e1.setLastName("Doe");
        e1.setDept("Technical");
        e1.setSalary(8000.00f);

        // Save object
        session.persist(e1);

        // Commit transaction
        tx.commit();

        // Close resources
        session.close();
        sf.close();

        System.out.println("Employee record inserted successfully.");
    }
}
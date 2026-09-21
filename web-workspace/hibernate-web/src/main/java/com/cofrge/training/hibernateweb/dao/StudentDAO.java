package com.cofrge.training.hibernateweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.cofrge.training.hibernateweb.model.Student;

public class StudentDAO {

    private static SessionFactory factory;

    static {
        try {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (Exception e) {
            System.err.println("Failed to initialize SessionFactory: " + e.getMessage());
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static int register(Student s) {

        Transaction tx = null;
        int id = 0;

        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();

            session.persist(s);

            tx.commit();

            id = s.getId();

        } catch (Exception e) {

            if (tx != null)
                tx.rollback();

            e.printStackTrace();
        }

        return id;
    }

    // Fetch All Students
    public List<Student> getAllStudents() {

        List<Student> students = null;

        try (Session session = factory.openSession()) {

            String hql = "FROM Student";

            Query<Student> query = session.createQuery(hql, Student.class);

            students = query.getResultList();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return students;
    }
    // ... (imports unchanged)
    public Student login(String email,String password) {
    	try(Session session=factory.openSession()){
    		return session.createQuery("from Student where email=:email and password=:password",Student.class)
    				.setParameter("email",email).setParameter("password",password).uniqueResult();
    	}
    }
}
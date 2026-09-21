package com.cofrge.training.hibernateweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.List;

import com.cofrge.training.hibernateweb.model.User;

public class UserDAO {
	 
	 private static SessionFactory sessionFactory;

	    static {
	    	//Hibernate 5 way to create SessionFactory object
	        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
	                .configure("hibernate.cfg.xml")
	                .build();
	        sessionFactory = new MetadataSources(registry)
	                .addAnnotatedClass(User.class)
	                .buildMetadata()
	                .buildSessionFactory();
	    }

	    public void save(User user) {
	        try (Session session = sessionFactory.openSession()) {
	            Transaction tx = session.beginTransaction();
	            session.persist(user);
	            tx.commit();
	        }
	    }

	    public List<User> getAll() {
	        try (Session session = sessionFactory.openSession()) {
	            return session.createQuery(
	                "select distinct u from User u left join fetch u.skills",
	                User.class
	            ).list();
	        }
	    }

}

package com.coforge.training.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.coforge.training.hibernatedemo.model.Product;

public class ProductApp {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf=cfg.buildSessionFactory();
		Session session =sf.openSession();

		Transaction t=session.beginTransaction();

		Product p1=new Product("11 pro","iPhone",102000.00f);

		session.persist(p1);  //object is in persistent state
		t.commit();

		System.out.println("Data Successfully Saved to Database");
		session.close();
		sf.close();

	}

}

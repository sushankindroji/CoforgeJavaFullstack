package com.coforge.training.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coforge.training.springcore.model.Book;

/**
 * Author : sushank2
 * Date : 23-Jul-2026
 * Project Name : spring-core
 */

public class BookApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("BookConfig.xml");

        // Get Book Beans
        Book b1 = (Book) context.getBean("book1");
        Book b2 = (Book) context.getBean("book2");
        Book b3 = (Book) context.getBean("book3");

        b1.display();
        b2.display();
        b3.display();

        ((ClassPathXmlApplicationContext) context).close();
    }
}
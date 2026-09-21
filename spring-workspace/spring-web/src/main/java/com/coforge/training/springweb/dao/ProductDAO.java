package com.coforge.training.springweb.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coforge.training.springweb.model.Product;

import jakarta.transaction.Transactional;

/**
 * Author : sushank2
 * Date :24-Jul-2026
 * Time :2:32:48 pm
 * Project Name :spring-web
 */

@Repository
@Transactional
public class ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> getAllProducts() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Product", Product.class)
                .getResultList();
    }

}
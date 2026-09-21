package com.coforge.training.springcore.model;

import com.coforge.training.springcore.Address;

/**
 * Author : sushank2
 * Date   : 23-Jul-2026
 * Project: spring-core
 */

public class Person {

    private int id;
    private String name;
    private Address address;   // has-a relationship (Composition)

    // Setters (for Setter Injection)
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // Display method
    public void display() {
        System.out.println("********** Person Information **************");
        System.out.println(this.id + " " + this.name);
        System.out.println(address);   // calls toString() of Address class
    }
}
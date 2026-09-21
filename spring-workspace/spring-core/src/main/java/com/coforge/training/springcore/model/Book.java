package com.coforge.training.springcore.model;

/**
 * Author : sushank2
 * Date : 23-Jul-2026
 * Project Name : spring-core
 */

import com.coforge.training.springcore.Address;

public class Book {

    private int id;
    private String name;
    private String author;
    private String publisher;
    private int quantity;

    private Address address; // Has-A Relationship

    // Default Constructor
    public Book() {
    }

    // Constructor Injection
    public Book(int id, String name, String author, String publisher, int quantity, Address address) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
        this.address = address;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void display() {
        System.out.println("********** Book Details ******************");
        System.out.println(id + " " + name + " " + author + " " + publisher + " " + quantity);
        System.out.println("Publisher Address: " + address);
    }
}
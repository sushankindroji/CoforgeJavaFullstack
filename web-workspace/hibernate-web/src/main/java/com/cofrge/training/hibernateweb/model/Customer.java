package com.cofrge.training.hibernateweb.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Customer {

    private String name;
    private String email;
    private String address;

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
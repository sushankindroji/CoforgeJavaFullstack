package com.coforge.training.customersoft.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

/**
 * Author : sushank2
 * Date : 28-Jul-2026
 * Time : 3:03:46 PM
 * Project : customer-service
 */

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String firstName;

    private String lastName;

    @Lob
    @Column(name = "passport", columnDefinition = "LONGBLOB")
    private byte[] passport;

    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

    // Default Constructor
    public Customer() {
    }

    // Parameterized Constructor
    public Customer(Long customerId, String firstName, String lastName, byte[] passport, byte[] image) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
        this.image = image;
    }

    // Getters and Setters
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte[] getPassport() {
        return passport;
    }

    public void setPassport(byte[] passport) {
        this.passport = passport;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
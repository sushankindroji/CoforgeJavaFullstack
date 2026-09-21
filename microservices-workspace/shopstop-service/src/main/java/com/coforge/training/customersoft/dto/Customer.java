package com.coforge.training.customersoft.dto;

/**
 * Author : sushank2
 * Date : 28-Jul-2026
 * Time : 4:35:32 PM
 * Project : shopstop-service
 */

public class Customer {

    private Long customerId;
    private String firstName;
    private String lastName;
    private byte[] passport;
    private byte[] image;

    // Default Constructor
    public Customer() {
    }

    // Parameterized Constructor
    public Customer(Long customerId, String firstName, String lastName,
                    byte[] passport, byte[] image) {
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

    @Override
    public String toString() {
        return "Customer [customerId=" + customerId
                + ", firstName=" + firstName
                + ", lastName=" + lastName + "]";
    }
}
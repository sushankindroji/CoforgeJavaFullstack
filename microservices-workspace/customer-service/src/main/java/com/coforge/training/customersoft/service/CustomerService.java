package com.coforge.training.customersoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coforge.training.customersoft.model.Customer;
import com.coforge.training.customersoft.repository.CustomerRepository;

/**
 * Author : sushank2
 * Date : 28-Jul-2026
 * Time : 3:13:37 PM
 * Project : customer-service
 */

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Save Customer
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Get All Customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get Customer By Id
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

   
}
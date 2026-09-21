package com.coforge.training.customersoft.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.coforge.training.customersoft.exception.ResourceNotFoundException;
import com.coforge.training.customersoft.model.Customer;
import com.coforge.training.customersoft.service.CustomerService;
import org.springframework.http.MediaType;

/**
 * Author : sushank2
 * Date : 28-Jul-2026
 * Time : 3:19:52 PM
 * Project : customer-service
 */

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/customers", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Customer> saveCustomer(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("passport") MultipartFile passport,
            @RequestPart("image") MultipartFile image) {

        try {
            Customer customer = new Customer();
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setPassport(passport.getBytes());
            customer.setImage(image.getBytes());

            return ResponseEntity.ok(customerService.saveCustomer(customer));

        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id)
            throws ResourceNotFoundException {

        Customer customer = customerService.getCustomerById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found for this Id : " + id));

        return ResponseEntity.ok(customer);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();

        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(customers);
    }
}
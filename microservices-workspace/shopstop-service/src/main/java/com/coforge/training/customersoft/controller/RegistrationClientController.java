package com.coforge.training.customersoft.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.coforge.training.customersoft.dto.Customer;
import com.coforge.training.customersoft.services.CustomerServiceClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/client")
public class RegistrationClientController {

    private final CustomerServiceClient registerClient;

    public RegistrationClientController(CustomerServiceClient registerClient) {
        this.registerClient = registerClient;
    }

    /***************************************************
     * SAVE CUSTOMER
     * POST http://localhost:8089/client/customers
     ***************************************************/
    @PostMapping(value = "/customers", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @CircuitBreaker(name = "customerServiceCB", fallbackMethod = "saveCustomerFallback")
    public ResponseEntity<Customer> saveCustomer(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("passport") MultipartFile passport,
            @RequestPart("image") MultipartFile image) {

        return registerClient.saveCustomer(firstName, lastName, passport, image);
    }

    /***************************************************
     * GET CUSTOMER BY ID
     * GET http://localhost:8089/client/customers/{id}
     ***************************************************/
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerServiceCB", fallbackMethod = "getCustomerFallback")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return registerClient.getCustomerById(id);
    }

    /***************************************************
     * GET ALL CUSTOMERS
     * GET http://localhost:8089/client/customers
     ***************************************************/
    @GetMapping("/customers")
    @CircuitBreaker(name = "customerServiceCB", fallbackMethod = "getAllFallback")
    public List<Customer> getAll() {
        return registerClient.getAllCustomers();
    }

    // ================= FALLBACK METHODS =================

    public ResponseEntity<Customer> saveCustomerFallback(
            String firstName,
            String lastName,
            MultipartFile passport,
            MultipartFile image,
            Throwable ex) {

        Customer customer = new Customer();

        customer.setCustomerId(0L);
        customer.setFirstName(firstName);   // <-- returns entered first name
        customer.setLastName(lastName);     // <-- returns entered last name
        customer.setPassport(null);
        customer.setImage(null);

        return ResponseEntity.ok(customer);
    }

    public ResponseEntity<Customer> getCustomerFallback(Long id, Throwable ex) {

        Customer customer = new Customer();

        customer.setCustomerId(id);
        customer.setFirstName("Customer Service Down");
        customer.setLastName("Fallback");

        return ResponseEntity.ok(customer);
    }

    public List<Customer> getAllFallback(Throwable ex) {
        return Collections.emptyList();
    }
}
package com.coforge.training.customersoft.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.coforge.training.customersoft.dto.Customer;

@FeignClient(name = "customer-service")
public interface CustomerServiceClient {

    @PostMapping(
            value = "/api/customers",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<Customer> saveCustomer(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("passport") MultipartFile passport,
            @RequestPart("image") MultipartFile image);

    @GetMapping("/api/customers/{id}")
    ResponseEntity<Customer> getCustomerById(@PathVariable Long id);

    @GetMapping("/api/customers")
    List<Customer> getAllCustomers();
}
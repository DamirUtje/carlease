package com.damirutje.carlease.data.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damirutje.carlease.data.model.Customer;
import com.damirutje.carlease.data.service.CustomerService;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return this.customerService.getCustomers();
    }
    
}


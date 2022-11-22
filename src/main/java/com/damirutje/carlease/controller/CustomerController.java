package com.damirutje.carlease.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damirutje.carlease.service.CustomerService;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String[] getCustomers() {
        return this.customerService.getCustomers();
    }
}


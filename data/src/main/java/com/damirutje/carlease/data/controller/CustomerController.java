package com.damirutje.carlease.data.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.damirutje.carlease.data.model.Customer;
import com.damirutje.carlease.data.service.CustomerService;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Returns requested {@link Customer} from database.
     * 
     * @param id of the requested {@link Customer}
     * @return the requested {@link Customer}
     */
    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable long id) {
        return customerService.getCustomer(id);
    }

    /**
     * Returns all {@link Customer} items from database.
     * 
     * @return all {@link Customer} items
     */
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return this.customerService.getCustomers();
    }

    /**
     * Stores and returns a {@link Customer} from database.
     * 
     * @param customer item to be stored
     * @return created {@link Customer}
     */
    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    /**
     * Updates a {@link Customer} in database.
     * 
     * @param customer to update
     */
    @PutMapping("/customers/{id}")
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
    }

    /**
     * Deletes a {@link Customer} from database.
     * 
     * @param id of the {@link Customer} to be deleted
     */
    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

}

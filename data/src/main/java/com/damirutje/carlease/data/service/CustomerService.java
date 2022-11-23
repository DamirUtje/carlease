package com.damirutje.carlease.data.service;

import java.util.List;

import com.damirutje.carlease.data.model.Customer;

public interface CustomerService extends BaseService<Customer> {
 
    /**
     * Persists a new {@link Customer} entity to database.
     * @param customer to persist
     * @return created {@link Customer} entity
     */
    Customer createCustomer(Customer customer);
    
    /**
     * Requests a {@link Customer} entity from database by specified id.
     * @param id of requested {@link Customer}
     * @return requested {@link Customer}
     */
    Customer getCustomer(long id);

    /**
     * Requests all {@link Customer} entities from database.
     * @return all {@link Customer} entities
     */
    List<Customer> getCustomers();

    /**
     * Updates a {@link Customer} entity in database.
     * @param customer to update
     */
    void updateCustomer(Customer customer);

    /**
     * Deletes a specified {@link Customer} entity in database.
     * @param id of specified {@link Customer}
     */
    void deleteCustomer(long id);

}

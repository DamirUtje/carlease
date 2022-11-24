package com.damirutje.carlease.data.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.damirutje.carlease.data.exception.CustomerNotExistException;
import com.damirutje.carlease.data.model.Customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testShouldCreateAndGetCustomer() {

        Customer customer = new Customer("Jon", "Doe", "2", "32344",
                "Birimo", "meani@outlook.de", "0137467236");

        customerService.createCustomer(customer);

        long newId = customer.getId();

        assertThat(newId)
                .withFailMessage("New customer should have an id")
                .isNotNull();

        assertThat(customerService.getCustomer(newId))
                .withFailMessage("New customer should be queryable by id")
                .isNotNull();
    }

    @Test
    public void testGetCustomerWithNonExistingId() {

        int nonExistingId = Integer.MAX_VALUE;

        assertThatThrownBy(() -> this.customerService.getCustomer(nonExistingId))
                .isInstanceOf(CustomerNotExistException.class)
                .hasMessageContaining(String.format("The customer with id %d does not exist!", nonExistingId));
    }

    @Test
    public void testUpdateCustomer() {

        String customerName = "Test Name";

        Customer customer = customerService.getCustomers().get(0);
        customer.setName(customerName);
        customerService.updateCustomer(customer);

        assertThat(customerName)
                .withFailMessage("Customer name should be same after update")
                .isEqualTo(customer.getName());
    }

    @Test
    public void testDeleteCustomer() {

        int customersCount = customerService.getCustomers().size();

        if (customersCount > 0) {
            Customer customer = customerService.getCustomers().get(0);
            customerService.deleteCustomer(customer.getId());
        }

        int customersCountAfterDelete = customerService.getCustomers().size();

        assertThat(customersCountAfterDelete)
                .withFailMessage("Should return less items after delete operation")
                .isNotEqualTo(customersCount);
    }

}

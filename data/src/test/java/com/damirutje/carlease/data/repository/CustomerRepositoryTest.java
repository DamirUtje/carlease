package com.damirutje.carlease.data.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.damirutje.carlease.data.model.Customer;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testQueryAllCustomersMockData() {

        List<Customer> customers = StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertThat(customers.size())
                .withFailMessage("Customers query should have entities")
                .isGreaterThan(0);
    }

    @Test
    public void testShouldSaveAndQueryCustomer() {

        Customer customer = new Customer("Ami Nation", "Luisiana", "2A", "26773F",
            "Lopaniut", "ami@nation.com", "01372543");

        customerRepository.save(customer);

        Optional<Customer> customerQuery = customerRepository.findById(customer.getId());

        assertThat(customerQuery.isPresent())
                .withFailMessage("Customer query by id should have one customer entity")
                .isTrue();

        assertThat(customerQuery)
                .withFailMessage("Customer query should be equal to initial instance")
                .isEqualTo(Optional.of(customer));
    }
    
}

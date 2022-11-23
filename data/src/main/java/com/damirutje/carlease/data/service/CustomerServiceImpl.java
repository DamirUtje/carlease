package com.damirutje.carlease.data.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damirutje.carlease.data.exception.CustomerNotExistException;
import com.damirutje.carlease.data.model.Customer;
import com.damirutje.carlease.data.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(long id) {
        Customer customer = null;
        Optional<Customer> dbCustomer = customerRepository.findById(id);

        if (dbCustomer.isPresent()) {
            customer = dbCustomer.get();
        } else {
            throw new CustomerNotExistException(id);
        }
        return customer;
    }

    @Override
    public List<Customer> getCustomers() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .filter(item -> item.isActive())
                .collect(Collectors.toList());
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(long id) {
        Customer customer = getCustomer(id);
        customerRepository.delete(customer);
    }

    @Override
    public void setInactive(Customer customer) {
        customer.setActive(false);
        customerRepository.save(customer);
    }

}

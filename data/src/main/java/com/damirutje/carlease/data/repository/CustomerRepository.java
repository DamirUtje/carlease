package com.damirutje.carlease.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.damirutje.carlease.data.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
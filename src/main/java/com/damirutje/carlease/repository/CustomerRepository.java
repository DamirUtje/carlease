package com.damirutje.carlease.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.damirutje.carlease.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
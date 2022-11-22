package com.damirutje.carlease.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.damirutje.carlease.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
}
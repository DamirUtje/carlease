package com.damirutje.carlease.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damirutje.carlease.model.Car;
import com.damirutje.carlease.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Iterable<Car> getCars() {
        
        List<Car> cars = StreamSupport.stream(carRepository.findAll().spliterator(), false).collect(Collectors.toList());
        System.out.println("getCars: " + cars.size());
        return cars;
    }
    
}

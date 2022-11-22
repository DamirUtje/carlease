package com.damirutje.carlease.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damirutje.carlease.model.Car;
import com.damirutje.carlease.service.CarService;

@RestController
public class CarController {
    
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public Iterable<Car> getCars() {
        return this.carService.getCars();
    }
}

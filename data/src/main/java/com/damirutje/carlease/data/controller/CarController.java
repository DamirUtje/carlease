package com.damirutje.carlease.data.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damirutje.carlease.data.model.Car;
import com.damirutje.carlease.data.service.CarService;

@RestController
public class CarController {
    
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<Car> getCars() {
        return this.carService.getCars();
    }
    
}

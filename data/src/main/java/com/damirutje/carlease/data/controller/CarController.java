package com.damirutje.carlease.data.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.damirutje.carlease.data.model.Car;
import com.damirutje.carlease.data.service.CarService;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    /**
     * Returns requested {@link Car} from database.
     * 
     * @param id of the requested {@link Car}
     * @return the requested {@link Car}
     */
    @GetMapping("/cars/{id}")
    public Car getGame(@PathVariable long id) {
        return carService.getCar(id);
    }

    /**
     * Returns all {@link Car} items from database.
     * 
     * @return all {@link Car} items
     */
    @GetMapping("/cars")
    public List<Car> getCars() {
        return carService.getCars();
    }

    /**
     * Stores and returns a {@link Car} from database.
     * 
     * @param car item to be stored
     * @return created {@link Car}
     */
    @PostMapping("/cars")
    public Car createCar(@RequestBody Car car) {
        return carService.createCar(car);
    }

    /**
     * Updates a {@link Car} in database.
     * 
     * @param car to update
     */
    @PutMapping("/cars/{id}")
    public void updateCar(@RequestBody Car car) {
        carService.updateCar(car);
    }

    /**
     * Deletes a {@link Car} from database.
     * 
     * @param id of the {@link Car} to be deleted
     */
    @DeleteMapping("/cars/{id}")
    void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

}

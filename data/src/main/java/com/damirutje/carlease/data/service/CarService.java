package com.damirutje.carlease.data.service;

import java.util.List;

import com.damirutje.carlease.data.model.Car;

public interface CarService {

    /**
     * Persists a new {@link Car} entity to database.
     * @param car to persist
     * @return created {@link Car} entity
     */
    Car createCar(Car car);
    
    /**
     * Requests a {@link Car} entity from database by specified id.
     * @param id of requested {@link Car}
     * @return requested {@link Car}
     */
    Car getCar(long id);

    /**
     * Requests all {@link Car} entities from database.
     * @return all {@link Car} entities
     */
    List<Car> getCars();

    /**
     * Updates a {@link Car} entity in database.
     * @param car to update
     */
    void updateCar(Car car);

    /**
     * Deletes a specified {@link Car} entity in database.
     * @param id of specified {@link Car}
     */
    void deleteCar(long id);

}

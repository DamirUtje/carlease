package com.damirutje.carlease.data.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damirutje.carlease.data.exception.CarNotExistException;
import com.damirutje.carlease.data.exception.InvalidCarPricingException;
import com.damirutje.carlease.data.model.Car;
import com.damirutje.carlease.data.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car createCar(Car car) {
        validatePricing(car);
        return carRepository.save(car);
    }

    @Override
    public Car getCar(long id) {
        Car car = null;
        Optional<Car> dbCar = carRepository.findById(id);

        if (dbCar.isPresent()) {
            car = dbCar.get();
        } else {
            throw new CarNotExistException(id);
        }
        return car;
    }

    @Override
    public List<Car> getCars() {
        List<Car> cars = StreamSupport.stream(carRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return cars;
    }

    @Override
    public void updateCar(Car car) {
        validatePricing(car);
        carRepository.save(car);
    }

    @Override
    public void deleteCar(long id) {
        Car car = getCar(id);
        carRepository.delete(car);
    }

    private void validatePricing(Car car) {
        int minPrice = 0;
        int maxPrice = 10000000; // 10 million
        double nett = car.getNettPrice();
        double gross = car.getGrossPrice();
        if (nett < minPrice || gross < minPrice ||
                nett >= maxPrice || gross >= maxPrice ||
                nett > gross) {
            throw new InvalidCarPricingException();
        }
    }

}

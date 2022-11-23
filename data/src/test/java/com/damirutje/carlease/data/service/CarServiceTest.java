package com.damirutje.carlease.data.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.damirutje.carlease.data.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CarServiceTest {
    
    @Autowired
    private CarService carService;

    @Test
    public void testShouldCreateAndGetCar() {
        
        Car car = new Car("BMW", "3", 3, new BigDecimal("49790.00"), 
            new BigDecimal("45000.00"));

        carService.createCar(car);

        assertThat(car.getId())
                .withFailMessage("New car should have an id")
                .isNotNull();

    }

    @Test
    public void testChangeActive() {

        int carsCount = carService.getCars().size();

        if (carsCount > 0) {
            Car car = carService.getCars().get(0);
            carService.setInactive(car);
        }

        int carsCountAfterChange = carService.getCars().size();

        assertThat(carsCountAfterChange)
                .withFailMessage("Should return less entities after update")
                .isNotEqualTo(carsCount);
    }

}

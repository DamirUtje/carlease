package com.damirutje.carlease.data.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.damirutje.carlease.data.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    public void testQueryAllCarsMockData() {

        List<Car> cars = StreamSupport.stream(carRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertThat(cars.size())
                .withFailMessage("Car query should have entities")
                .isGreaterThan(0);
    }

    @Test
    public void testShouldSaveAndQueryCar() {
        Car car = new Car("VW", "Up", 3, 29790.00, 25000.00);

        carRepository.save(car);

        Optional<Car> carQuery = carRepository.findById(car.getId());

        assertThat(carQuery.isPresent())
                .withFailMessage("Car query by id should have one car entity")
                .isTrue();

        assertThat(carQuery)
                .withFailMessage("Car query should be equal to initial instance")
                .isEqualTo(Optional.of(car));
    }

}

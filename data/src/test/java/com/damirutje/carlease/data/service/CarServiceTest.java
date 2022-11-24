package com.damirutje.carlease.data.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.damirutje.carlease.data.exception.CarNotExistException;
import com.damirutje.carlease.data.exception.InvalidCarPricingException;
import com.damirutje.carlease.data.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class CarServiceTest {

    @Autowired
    private CarService carService;

    @Test
    public void testShouldCreateAndGetCar() {

        Car car = getNewCar();

        carService.createCar(car);

        long newCarId = car.getId();

        assertThat(newCarId)
                .withFailMessage("New car should have an id")
                .isNotNull();

        assertThat(carService.getCar(newCarId))
                .withFailMessage("New car should be queryable by id")
                .isNotNull();
    }

    @Test
    public void testGetCarWithNonExistingId() {

        int nonExistingId = Integer.MAX_VALUE;

        assertThatThrownBy(() -> this.carService.getCar(nonExistingId))
                .isInstanceOf(CarNotExistException.class)
                .hasMessageContaining(String.format("The car with id %d does not exist!", nonExistingId));
    }

    @Test
    public void testCarShouldHaveValidPricesOnCreate() {

        Car car = new Car("Volvo", "Gold", 4, -30, 34300.00);

        assertThatThrownBy(() -> carService.createCar(car))
                .isInstanceOf(InvalidCarPricingException.class)
                .hasMessageContaining("The car must have positive and plausible prices!");

        car.setGrossPrice(Integer.MAX_VALUE);

        assertThatThrownBy(() -> carService.createCar(car))
                .isInstanceOf(InvalidCarPricingException.class)
                .hasMessageContaining("The car must have positive and plausible prices!");
    }

    @Test
    public void testCarShouldHaveValidPricesOnUpdate() {

        Car car = getNewCar();
        car.setNettPrice(-324.00);

        assertThatThrownBy(() -> carService.updateCar(car))
                .isInstanceOf(InvalidCarPricingException.class)
                .hasMessageContaining("The car must have positive and plausible prices!");

        car.setNettPrice(Integer.MAX_VALUE);

        assertThatThrownBy(() -> carService.updateCar(car))
                .isInstanceOf(InvalidCarPricingException.class)
                .hasMessageContaining("The car must have positive and plausible prices!");

        double price = 20000.00;
        car.setGrossPrice(price);
        car.setNettPrice(price + 1);

        assertThatThrownBy(() -> carService.updateCar(car))
                .isInstanceOf(InvalidCarPricingException.class)
                .hasMessageContaining("The car must have positive and plausible prices!");
    }

    @Test
    public void testUpdateCar() {

        String carVersion = "Test Version";

        Car car = getNewTestCarFromDb();
        car.setVersion(carVersion);
        carService.updateCar(car);

        assertThat(carVersion)
                .withFailMessage("Car version should be same after update")
                .isEqualTo(car.getVersion());
    }

    @Test
    public void testDeleteCar() {

        int carsCount = carService.getCars().size();

        if (carsCount > 0) {
            Car car = getNewTestCarFromDb();
            carService.deleteCar(car.getId());
        }

        int carsCountAfterDelete = carService.getCars().size();

        assertThat(carsCountAfterDelete)
                .withFailMessage("Should return less items after delete operation")
                .isNotEqualTo(carsCount);
    }

    private Car getNewTestCarFromDb() {
        Car car;

        if (carService.getCars().size() > 0) {
            car = carService.getCars().get(0);
            car.setNettPrice(car.getGrossPrice()); // equalize prices
        } else {
            car = carService.createCar(getNewCar());
        }
        return car;
    }

    private Car getNewCar() {
        return new Car("BMW", "3", 3, 49790.00, 45000.00);
    }

}

package com.damirutje.carlease.data.exception;

public class CarNotExistException extends RuntimeException {

    public CarNotExistException(long carId) {
        super(String.format("The car with id %d does not exist!", carId));
    }
}
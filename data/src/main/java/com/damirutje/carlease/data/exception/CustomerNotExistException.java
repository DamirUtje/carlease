package com.damirutje.carlease.data.exception;

public class CustomerNotExistException extends RuntimeException {

    public CustomerNotExistException(long customerId) {
        super(String.format("The customer with id %d does not exist!", customerId));
    }
    
}
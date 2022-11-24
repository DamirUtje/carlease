package com.damirutje.carlease.data.exception;

public class InvalidCarPricingException extends RuntimeException {

    public InvalidCarPricingException() {
        super("The car must have positive and plausible prices!");
    }
    
}
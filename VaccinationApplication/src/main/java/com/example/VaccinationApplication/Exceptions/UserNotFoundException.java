package com.example.VaccinationApplication.Exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String userIsNotPresent) {
        super(userIsNotPresent);
    }
}

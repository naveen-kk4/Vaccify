package com.example.VaccinationApplication.Exceptions;

public class CenterNotFoundException extends RuntimeException {
    public CenterNotFoundException(String centerIsNotPresent) {
        super(centerIsNotPresent);
    }
}

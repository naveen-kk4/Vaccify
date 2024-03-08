package com.example.VaccinationApplication.Exceptions;

public class VaccinationAddressEmptyException extends RuntimeException{
    public VaccinationAddressEmptyException(String addressNotFound) {
        super(addressNotFound);
    }
}

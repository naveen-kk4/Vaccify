package com.example.VaccinationApplication.Exceptions;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(String doctorNotPresent) {
        super(doctorNotPresent);
    }
}

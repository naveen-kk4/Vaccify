package com.example.VaccinationApplication.Exceptions;

public class DoctorAlreadyExistsException extends RuntimeException {
    public DoctorAlreadyExistsException(String doctorAlreadyExists) {
        super(doctorAlreadyExists);
    }
}

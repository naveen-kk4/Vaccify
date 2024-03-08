package com.example.VaccinationApplication.Exceptions;

public class EmailIdInvalidException extends RuntimeException {
    public EmailIdInvalidException(String invalidEmailId) {
        super(invalidEmailId);
    }
}

package org.exception.employee;

public class EmployeeValidationException extends RuntimeException {
    public EmployeeValidationException(String message) {
        super(message);
    }
}
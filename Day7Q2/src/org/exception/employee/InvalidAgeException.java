// File: src/org/exception/employee/InvalidAgeException.java
package org.exception.employee;

public class InvalidAgeException extends EmployeeValidationException {
    public InvalidAgeException() {
        super("Age must be greater than 18.");
    }
    public InvalidAgeException(String message) {
        super(message);
    }
}
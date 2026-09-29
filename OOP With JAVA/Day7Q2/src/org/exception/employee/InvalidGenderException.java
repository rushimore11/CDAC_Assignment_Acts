// File: src/org/exception/employee/InvalidGenderException.java
package org.exception.employee;

public class InvalidGenderException extends EmployeeValidationException {
    public InvalidGenderException() {
        super("Gender must be entered as Male or Female.");
    }
    public InvalidGenderException(String message) {
        super(message);
    }
}
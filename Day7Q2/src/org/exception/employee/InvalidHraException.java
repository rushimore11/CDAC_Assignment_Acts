// File: src/org/exception/employee/InvalidHraException.java
package org.exception.employee;

public class InvalidHraException extends EmployeeValidationException {
    public InvalidHraException() {
        super("HRA must be greater than or equal to 0.");
    }
    public InvalidHraException(String message) {
        super(message);
    }
}
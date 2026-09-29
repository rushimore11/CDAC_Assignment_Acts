
package org.exception.employee;

public class InvalidNameException extends EmployeeValidationException {
    public InvalidNameException() {
        super("Name cannot be null or less than 2 characters.");
    }
    public InvalidNameException(String message) {
        super(message);
    }
}
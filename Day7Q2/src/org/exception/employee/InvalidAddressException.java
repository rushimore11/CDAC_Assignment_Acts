
package org.exception.employee;

public class InvalidAddressException extends EmployeeValidationException {
    public InvalidAddressException() {
        super("Address cannot be null or less than 3 characters.");
    }
    public InvalidAddressException(String message) {
        super(message);
    }
}

// File: src/org/exception/employee/InvalidCommissionException.java
package org.exception.employee;

public class InvalidCommissionException extends EmployeeValidationException {
    public InvalidCommissionException() {
        super("Commission must be greater than or equal to 0.");
    }
    public InvalidCommissionException(String message) {
        super(message);
    }
}
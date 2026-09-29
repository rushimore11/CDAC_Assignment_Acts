// File: src/org/exception/employee/InvalidOverTimeException.java
package org.exception.employee;

public class InvalidOverTimeException extends EmployeeValidationException {
    public InvalidOverTimeException() {
        super("Overtime must be greater than or equal to 0.");
    }
    public InvalidOverTimeException(String message) {
        super(message);
    }
}

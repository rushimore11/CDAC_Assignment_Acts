// File: src/org/exception/employee/InvalidBasicSalaryException.java
package org.exception.employee;

public class InvalidBasicSalaryException extends EmployeeValidationException {
    public InvalidBasicSalaryException() {
        super("Basic salary of an employee must be greater than 0.");
    }
    public InvalidBasicSalaryException(String message) {
        super(message);
    }
}
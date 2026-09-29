package org.EmployeeManagement;

import org.exception.employee.InvalidOverTimeException;

public class Engineer extends Employee {

    private double overtime;

    public Engineer() {
        super();
        this.overtime = 0.0;
    }

    public Engineer(String name, String address, int age, String gender, double basicSalary, double overtime) {
        super(name, address, age, gender, basicSalary);
        setOvertime(overtime);
    }

    public void setOvertime(double overtime) {
        if (overtime < 0) {
            throw new InvalidOverTimeException();
        }
        this.overtime = overtime;
    }

    public double getOvertime() { return overtime; }

    @Override
    public double calculateSalary() {
        return getBasicSalary() + overtime;
    }

    @Override
    public String toString() {
        return String.format("Engineer [Name: %s, Address: %s, Age: %d, Gender: %s, Basic: %.2f, Overtime: %.2f, Total Salary: %.2f]",
                getName(), getAddress(), getAge(), getGender(), getBasicSalary(), overtime, calculateSalary());
    }
}
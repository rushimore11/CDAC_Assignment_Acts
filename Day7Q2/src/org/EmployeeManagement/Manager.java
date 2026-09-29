package org.EmployeeManagement;

import org.exception.employee.InvalidHraException;

public class Manager extends Employee {

    private double hra;

    public Manager() {
        super();
        this.hra = 0.0;
    }

    public Manager(String name, String address, int age, String gender, double basicSalary, double hra) {
        super(name, address, age, gender, basicSalary);
        setHra(hra);
    }

    public void setHra(double hra) {
        if (hra < 0) {
            throw new InvalidHraException();
        }
        this.hra = hra;
    }

    public double getHra() { return hra; }

    @Override
    public double calculateSalary() {
        return getBasicSalary() + hra;
    }

    @Override
    public String toString() {
        return String.format("Manager [Name: %s, Address: %s, Age: %d, Gender: %s, Basic: %.2f, HRA: %.2f, Total Salary: %.2f]",
                getName(), getAddress(), getAge(), getGender(), getBasicSalary(), hra, calculateSalary());
    }
}
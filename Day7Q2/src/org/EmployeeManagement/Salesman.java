package org.EmployeeManagement;

import org.exception.employee.InvalidCommissionException;

public class Salesman extends Employee {

    private double commission;

    public Salesman() {
        super();
        this.commission = 0.0;
    }

    public Salesman(String name, String address, int age, String gender, double basicSalary, double commission) {
        super(name, address, age, gender, basicSalary);
        setCommission(commission);
    }

    public void setCommission(double commission) {
        if (commission < 0) {
            throw new InvalidCommissionException();
        }
        this.commission = commission;
    }

    public double getCommission() { return commission; }

    @Override
    public double calculateSalary() {
        return getBasicSalary() + commission;
    }

    @Override
    public String toString() {
        return String.format("Salesman [Name: %s, Address: %s, Age: %d, Gender: %s, Basic: %.2f, Commission: %.2f, Total Salary: %.2f]",
                getName(), getAddress(), getAge(), getGender(), getBasicSalary(), commission, calculateSalary());
    }
}
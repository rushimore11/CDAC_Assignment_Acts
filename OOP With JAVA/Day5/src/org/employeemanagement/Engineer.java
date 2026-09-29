package org.employeemanagement;

public class Engineer extends Employee {

    private double overtime;

    public Engineer() {
        super();
        overtime = 0.0;
    }

    public Engineer(String name, String address, int age, String gender, double basicSalary, double overtime) {

        super(name, address, age, gender, basicSalary);
        setOvertime(overtime);
    }

    public void setOvertime(double overtime) {

        if (overtime >= 0)
            this.overtime = overtime;
        else
            this.overtime = 0.0;
    }

    public double getOvertime() {
        return overtime;
    }

    @Override
    public double calculateSalary() {
        return getBasicSalary() + overtime;
    }

    @Override
    public String toString() {

        return "Engineer{" +
                 "name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                    ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                   ", basicSalary=" + getBasicSalary() +
                ", overtime=" + overtime +
                   ", totalSalary=" + calculateSalary() + '}';
    }
}
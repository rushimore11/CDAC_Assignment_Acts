package org.employeemanagement;

public class Manager extends Employee {

    private double hra;

    public Manager() {
        super();
        hra = 0.0;
    }

    public Manager(String name, String address, int age, String gender, double basicSalary, double hra) {

        super(name, address, age, gender, basicSalary);
        setHra(hra);
    }

    public void setHra(double hra) {

        if (hra >= 0)
            this.hra = hra;
        else
            this.hra = 0.0;
    }

    public double getHra() {
        return hra;
    }

    @Override
    public double calculateSalary() {
        return getBasicSalary() + hra;
    }

    @Override
    public String toString() {

        return "Manager{" +
                 "name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                  ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                ", basicSalary=" + getBasicSalary() +
                 ", hra=" + hra +
                ", totalSalary=" + calculateSalary() + '}';
    }
}
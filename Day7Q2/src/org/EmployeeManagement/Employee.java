package org.EmployeeManagement;

import java.io.Serializable;

import org.exception.employee.*;

public abstract class Employee implements Comparable<Employee> ,Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6663279784665671316L;
	private String name;
    private String address;
    private int age;
    private String gender;
    private double basicSalary;

    public Employee() {
        this.name = "Unknown";
        this.address = "Not Provided";
        this.age = 18;
        this.gender = "Not Specified";
        this.basicSalary = 0.0;
    }

    public Employee(String name, String address, int age, String gender, double basicSalary) {
        setName(name);
        setAddress(address);
        setAge(age);
        setGender(gender);
        setBasicSalary(basicSalary);
    }

    public void setName(String name) {
        if (name == null || name.trim().length() <= 1) {
            throw new InvalidNameException();
        }
        this.name = name.trim();
    }

    public void setAddress(String address) {
        if (address == null || address.trim().length() <= 2) {
            throw new InvalidAddressException();
        }
        this.address = address.trim();
    }

    public void setAge(int age) {
        if (age <= 18) {
            throw new InvalidAgeException();
        }
        this.age = age;
    }

    public void setGender(String gender) {
        if (gender == null || (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female"))) {
            throw new InvalidGenderException();
        }
        this.gender = gender;
    }

    public void setBasicSalary(double basicSalary) {
        if (basicSalary <= 0) {
            throw new InvalidBasicSalaryException();
        }
        this.basicSalary = basicSalary;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public double getBasicSalary() { return basicSalary; }

    public abstract double calculateSalary();

    @Override
    public int compareTo(Employee other) {
        return this.name.compareToIgnoreCase(other.name);
    }
}
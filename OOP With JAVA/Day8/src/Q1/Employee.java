package Q1;

public abstract class Employee {

    private String name;
    private String address;
    private int age;
    private String gender;
    private double basicSalary;

    // Default constructor
    public Employee() {
        name = "Unknown";
        address = "Not Provided";
        age = 18;
        gender = "Not Specified";
        basicSalary = 0.0;
    }

    // Parameterized constructor
    public Employee(String name, String address, int age,
                    String gender, double basicSalary) {

        setName(name);
        setAddress(address);
        setAge(age);
        setGender(gender);
        setBasicSalary(basicSalary);
    }

    // Setters

    public void setName(String name) {
        if (name != null && name.trim().length() > 1)
            this.name = name;
        else
            this.name = "Unknown";
    }

    public void setAddress(String address) {
        if (address != null && address.trim().length() > 2)
            this.address = address;
        else
            this.address = "Not Provided";
    }

    public void setAge(int age) {
        if (age > 18)
            this.age = age;
        else
            this.age = 18;
    }

    public void setGender(String gender) {
        if (gender != null &&
                (gender.equalsIgnoreCase("Male") ||
                        gender.equalsIgnoreCase("Female"))) {

            this.gender = gender;
        }
        else {
            this.gender = "Not Specified";
        }
    }

    public void setBasicSalary(double basicSalary) {
        if (basicSalary > 0)
            this.basicSalary = basicSalary;
        else
            this.basicSalary = 0.0;
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    // Abstract method
    public abstract double calculateSalary();
}
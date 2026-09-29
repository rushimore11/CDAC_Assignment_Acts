

public final class Engineer extends Employee {
    private float overTime;

    public Engineer(String name, String address, int age, String gender, int basicSalary, float overTime) {
        super(name, address, age, gender, basicSalary);
        if (!setOverTime(overTime)) {
            this.overTime = 0.0f;
        }
    }

    public float getOverTime() {
        return overTime;
    }

    public boolean setOverTime(float overTime) {
        if (overTime < 0) {
            System.out.println(" Overtime hours cannot be negative.");
            return false;
        }
        this.overTime = overTime;
        return true;
    }

    @Override
    public String getRole() {
        return "Engineer";
    }

    @Override
    public void displayDetails() {
        System.out.println("--- Engineer Details ---");
        System.out.println("Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Basic Salary: " + getBasicSalary());
        System.out.println("Overtime Hours: " + overTime);
    }

    
}



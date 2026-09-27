
public final class Salesman extends Employee {
    private float commision;

    
    public Salesman(String name, String address, int age, String gender, int basicSalary, float commision) {
        super(name, address, age, gender, basicSalary);
        if (!setCommision(commision)) {
            this.commision = 0;
        }
    }

    public float getCommision() {
        return commision;
    }

    
    public boolean setCommision(float commision) {
        if (commision < 0) {
            System.out.println("Commission cannot be negative.");
            return false;
        }
        this.commision = commision;
        return true;
    }

    @Override
    public String getRole() {
        return "Salesman";
    }

    @Override
    public void displayDetails() {
        System.out.println("--- Salesman Details ---");
        System.out.println("Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Basic Salary: " + getBasicSalary());
        System.out.println("Commission: " + commision);
    }

}



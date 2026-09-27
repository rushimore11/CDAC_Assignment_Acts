
public final class Manager extends Employee {
    private int bonus;

    public Manager(String name, String address, int age, String gender, int basicSalary, int bonus) {
        super(name, address, age, gender, basicSalary);
        if (!setBonus(bonus)) {
            this.bonus = 0; 
        }
    }

    public int getBonus() {
        return bonus;
    }

    public boolean setBonus(int bonus) {
        if (bonus < 0) {
            System.out.println("Bonus cannot be negative.");
            return false;
        }
        this.bonus = bonus;
        return true;
    }

    @Override
    public String getRole() {
        return "Manager"; 
    }

    @Override
    public void displayDetails() {
        System.out.println("--- Manager Details -");
        System.out.println("Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Basic Salary: " + getBasicSalary());
        System.out.println("Bonus: " + bonus);
    }

    
}















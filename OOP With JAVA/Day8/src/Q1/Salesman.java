package Q1;

public class Salesman extends Employee {

    private double commission;

    public Salesman() {
        super();
        commission = 0.0;
    }

    public Salesman(String name, String address, int age, String gender, double basicSalary, double commission) {

        super(name, address, age, gender, basicSalary);
        setCommission(commission);
    }

    public void setCommission(double commission) {

        if (commission >= 0)
            this.commission = commission;
        else
            this.commission = 0.0;
    }

    public double getCommission() {
        return commission;
    }

    @Override
    public double calculateSalary() {
        return getBasicSalary() + commission;
    }

    @Override
    public String toString() {

        return "Salesman{" +
                "name='" + getName() + '\'' +
                  ", address='" + getAddress() + '\'' +
                ", age=" + getAge() +
                 ", gender='" + getGender() + '\'' +
                ", basicSalary=" + getBasicSalary() +
                 ", commission=" + commission +
                ", totalSalary=" + calculateSalary() + '}';
    }
}
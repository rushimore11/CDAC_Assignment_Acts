public class Employee {

    private double salary;
    private double commission;

    public int addSalary() {
        System.out.println("Executing method: addSalary");
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Executing Employee main method...");
        Employee employee = new Employee();
        employee.addSalary();
    }
}

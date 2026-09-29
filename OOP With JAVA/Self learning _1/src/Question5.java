class Employee {
    String name;
    int yearOfJoining;
    double salary;
    String address;

    // Class Constructor
    public Employee(String empName, int year, double sal, String empAddress) {
        name = empName;
        yearOfJoining = year;
        salary = sal;
        address = empAddress;
    }

    public void printRow() {
        System.out.printf("%-12s %-16d %s\n", name, yearOfJoining, address);
    }
}

public class Question5 {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Manoj", 2026, 50000, "Pune");
        Employee emp2 = new Employee("Rushikesh", 2020, 60000, "Mumbai");
        Employee emp3 = new Employee("Vishvajit", 2021, 55000, "Goa");

        //  Header
        System.out.printf("%-12s %-16s %s\n", "Name", "Year of joining", "Address");
        
       
        emp1.printRow();
        emp2.printRow();
        emp3.printRow();
    }
}

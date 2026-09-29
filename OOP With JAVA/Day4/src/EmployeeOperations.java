
import Q1.ConsoleInput; // Keeps your custom console utility linked correctly

public class EmployeeOperations {
    static Employee[] employee = new Employee[100];
    static int employeeCount = 0;
    static int currentIndex = -1;

    static boolean addEmployee() {
        while (true) {
            System.out.println("\n--- Select Employee Type ---");
            System.out.println("1. Manager\n2. Engineer\n3. Sales Person\n4. Exit to Main Menu");
            System.out.print("Enter your choice: ");
            int ch = ConsoleInput.getInt();
            
            if (ch == 4) {
                System.out.println("Returning to main menu...");
                return true;
            }
            if (ch < 1 || ch > 4) {
                System.out.println("Invalid choice! Try again.");
                continue;
            }
            if (employeeCount >= employee.length) {
                System.out.println("Error: Database storage full!");
                return false;
            }

            System.out.print("Enter name: ");
            String name = ConsoleInput.getString();
            System.out.print("Enter address: ");
            String address = ConsoleInput.getString();
            System.out.print("Enter age: ");
            int age = ConsoleInput.getInt();
            System.out.print("Enter gender: ");
            String gender = ConsoleInput.getString();
            System.out.print("Enter basic Salary: ");
            int basicSalary = ConsoleInput.getInt();
             
            switch (ch) {
                case 1: {
                    System.out.print("Enter bonus: ");
                    int bonus = ConsoleInput.getInt();
                    employee[employeeCount++] = new Manager(name, address, age, gender, basicSalary, bonus);
                    System.out.println("Manager added successfully!");
                    break;
                }
                case 2: {
                    System.out.print("Enter overtime hours: ");
                    float overTime = ConsoleInput.getFloat();
                    employee[employeeCount++] = new Engineer(name, address, age, gender, basicSalary, overTime);
                    System.out.println("Engineer added successfully!");
                    break;
                }
                case 3: {
                    System.out.print("Enter commission: ");
                    float commission = ConsoleInput.getFloat();
                    employee[employeeCount++] = new Salesman(name, address, age, gender, basicSalary, commission);
                    System.out.println("Salesman added successfully!");
                    break;
                }
            }
            if (currentIndex == -1 && employeeCount > 0) currentIndex = 0;
        }
    }

    public static void displayAll() {
        if (employeeCount == 0) { System.out.println("No records found."); return; }
        for (int i = 0; i < employeeCount; i++) {
            employee[i].displayDetails();
            System.out.println("------------------------");
        }
    }

    public static void displayFirst() {
        if (employeeCount > 0) { currentIndex = 0; employee[currentIndex].displayDetails(); }
        else System.out.println("No records found.");
    }

    public static void displayNext() {
        if (employeeCount == 0) { System.out.println("No records found."); return; }
        if (currentIndex < employeeCount - 1) currentIndex++;
        else System.out.println("You are looking at the last record.");
        employee[currentIndex].displayDetails();
    }

    public static void displayPrevious() {
        if (employeeCount == 0) { System.out.println("No records found."); return; }
        if (currentIndex > 0) currentIndex--;
        else System.out.println("You are looking at the first record.");
        employee[currentIndex].displayDetails();
    }

    public static void displayLast() {
        if (employeeCount > 0) { currentIndex = employeeCount - 1; employee[currentIndex].displayDetails(); }
        else System.out.println("No records found.");
    }

    public static void filterByRole(String roleName) {
        if (employeeCount == 0) { System.out.println("No records found."); return; }
        boolean found = false;
        for (int i = 0; i < employeeCount; i++) {
            if (employee[i].getRole().equalsIgnoreCase(roleName)) {
                employee[i].displayDetails();
                System.out.println("------------------------");
                found = true;
            }
        }
        if (!found) System.out.println("No records matching: " + roleName);
    }

    public static void sortAlphabetical(boolean ascending) {
        if (employeeCount <= 1) {
            if (employeeCount == 0) System.out.println("No records to sort.");
            else employee[0].displayDetails();
            return;
        }
        for (int i = 0; i < employeeCount - 1; i++) {
            for (int j = 0; j < employeeCount - i - 1; j++) {
                int comp = employee[j].getName().compareToIgnoreCase(employee[j + 1].getName());
                if (ascending ? (comp > 0) : (comp < 0)) {
                    Employee temp = employee[j];
                    employee[j] = employee[j + 1];
                    employee[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted execution complete!");
        displayAll();
    }
}

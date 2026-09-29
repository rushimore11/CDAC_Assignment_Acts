package org.EmployeeManagement;

import org.utility.FileHandler;
import org.utility.LinkedList;
import org.exception.employee.EmployeeValidationException;
import org.exception.linkedlist.LinkedListException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeOperations {

    private static final LinkedList<Employee> employees = new LinkedList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void addEmployee() {
        int choice = -1;
        do {
            System.out.println("\n=== Add Employee ===");
            System.out.println("1. Manager");
            System.out.println("2. Engineer");
            System.out.println("3. Salesman");
            System.out.println("4. Exit to Main Menu");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> addManager();
                    case 2 -> addEngineer();
                    case 3 -> addSalesman();
                    case 4 -> System.out.println("Returning to Main Menu...");
                    default -> System.out.println("Invalid choice. Please choose 1-4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Input must be a valid integer number.");
                sc.nextLine(); // clear invalid input
            }
        } while (choice != 4);
    }

    private static void addManager() {
        try {
            String name = getStringInput("Enter Name: ");
            String address = getStringInput("Enter Address: ");
            int age = getIntInput("Enter Age: ");
            String gender = getStringInput("Enter Gender (Male/Female): ");
            double basicSalary = getDoubleInput("Enter Basic Salary: ");
            double hra = getDoubleInput("Enter HRA: ");

            Employee manager = new Manager(name, address, age, gender, basicSalary, hra);
            employees.add(manager);
            System.out.println("Manager added successfully.");
        } catch (EmployeeValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private static void addEngineer() {
        try {
            String name = getStringInput("Enter Name: ");
            String address = getStringInput("Enter Address: ");
            int age = getIntInput("Enter Age: ");
            String gender = getStringInput("Enter Gender (Male/Female): ");
            double basicSalary = getDoubleInput("Enter Basic Salary: ");
            double overtime = getDoubleInput("Enter Overtime Pay: ");

            Employee engineer = new Engineer(name, address, age, gender, basicSalary, overtime);
            employees.add(engineer);
            System.out.println("Engineer added successfully.");
        } catch (EmployeeValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private static void addSalesman() {
        try {
            String name = getStringInput("Enter Name: ");
            String address = getStringInput("Enter Address: ");
            int age = getIntInput("Enter Age: ");
            String gender = getStringInput("Enter Gender (Male/Female): ");
            double basicSalary = getDoubleInput("Enter Basic Salary: ");
            double commission = getDoubleInput("Enter Commission: ");

            Employee salesman = new Salesman(name, address, age, gender, basicSalary, commission);
            employees.add(salesman);
            System.out.println("Salesman added successfully.");
        } catch (EmployeeValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int val = sc.nextInt();
                sc.nextLine();
                return val;
            } catch (InputMismatchException e) {
                System.out.println("Error: Input must be an integer.");
                sc.nextLine();
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double val = sc.nextDouble();
                sc.nextLine();
                return val;
            } catch (InputMismatchException e) {
                System.out.println("Error: Input must be a valid number.");
                sc.nextLine();
            }
        }
    }

    public static void displayMenu() {
        int choice = -1;
        do {
            System.out.println("\n=== Display Menu ===");
            System.out.println("1. All Employees");
            System.out.println("2. First Employee");
            System.out.println("3. Next Employee");
            System.out.println("4. Previous Employee");
            System.out.println("5. Last Employee");
            System.out.println("6. Exit to Main Menu");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> displayAll();
                    case 2 -> displayFirst();
                    case 3 -> displayNext();
                    case 4 -> displayPrevious();
                    case 5 -> displayLast();
                    case 6 -> System.out.println("Returning to Main Menu...");
                    default -> System.out.println("Invalid choice. Please choose 1-6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Input must be an integer.");
                sc.nextLine();
            }
        } while (choice != 6);
    }

    private static void displayAll() {
        try {
            Employee emp = employees.getFirst();
            while (emp != null) {
                System.out.println(emp);
                if (employees.hasNext()) {
                    emp = employees.getNext();
                } else {
                    break;
                }
            }
        } catch (LinkedListException e) {
            System.out.println("List Error: " + e.getMessage());
        }
    }

    private static void displayFirst() {
        try {
            System.out.println(employees.getFirst());
        } catch (LinkedListException e) {
            System.out.println("List Error: " + e.getMessage());
        }
    }

    private static void displayNext() {
        try {
            System.out.println(employees.getNext());
        } catch (LinkedListException e) {
            System.out.println("Navigation Error: " + e.getMessage());
        }
    }

    private static void displayPrevious() {
        try {
            System.out.println(employees.getPrevious());
        } catch (LinkedListException e) {
            System.out.println("Navigation Error: " + e.getMessage());
        }
    }

    private static void displayLast() {
        try {
            System.out.println(employees.getLast());
        } catch (LinkedListException e) {
            System.out.println("List Error: " + e.getMessage());
        }
    }

    public static void sortMenu() {
        int choice = -1;
        do {
            System.out.println("\n=== Sort Menu ===");
            System.out.println("1. All Managers");
            System.out.println("2. All Engineers");
            System.out.println("3. All Salesmen");
            System.out.println("4. All Employees Alphabetic Ascending");
            System.out.println("5. All Employees Alphabetic Descending");
            System.out.println("6. Exit to Main Menu");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> filterAndDisplay(Manager.class);
                    case 2 -> filterAndDisplay(Engineer.class);
                    case 3 -> filterAndDisplay(Salesman.class);
                    case 4 -> sortAndDisplay(true);
                    case 5 -> sortAndDisplay(false);
                    case 6 -> System.out.println("Returning to Main Menu...");
                    default -> System.out.println("Invalid choice. Please choose 1-6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Input must be an integer.");
                sc.nextLine();
            }
        } while (choice != 6);
    }

    private static void filterAndDisplay(Class<? extends Employee> type) {
        try {
            if (employees.isEmpty()) {
                System.out.println("No employees found.");
                return;
            }

            boolean found = false;
            Employee emp = employees.getFirst();

            while (emp != null) {
                if (type.isInstance(emp)) {
                    System.out.println(emp);
                    found = true;
                }
                if (employees.hasNext()) {
                    emp = employees.getNext();
                } else {
                    break;
                }
            }

            if (!found) {
                System.out.println("No records found for type: " + type.getSimpleName());
            }
        } catch (LinkedListException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void sortAndDisplay(boolean ascending) {
        if (employees.isEmpty()) {
            System.out.println("No employees to sort.");
            return;
        }

        employees.sort(ascending);
        System.out.println("Employees sorted in " + (ascending ? "Ascending" : "Descending") + " order by name:");
        displayAll();
    }
    
    private static final String FILE_PATH = "employees.dat";

    public static void saveToFile() {
        if (employees.isEmpty()) {
            System.out.println("Warning: Employee list is empty. Saving empty record set.");
        }

        try {
            FileHandler.saveToFile(FILE_PATH, employees);
            System.out.println("Employee records successfully saved to '" + FILE_PATH + "'.");
        } catch (IOException e) {
            System.out.println("Error saving employee data: " + e.getMessage());
        }
    }

    public static void loadFromFile() {
        try {
            LinkedList<Employee> loadedList = FileHandler.loadFromFile(FILE_PATH);
            
            // Clear existing in-memory state and reload
            employees.clear();
            
            if (!loadedList.isEmpty()) {
                Employee emp = loadedList.getFirst();
                while (emp != null) {
                    employees.add(emp);
                    if (loadedList.hasNext()) {
                        emp = loadedList.getNext();
                    } else {
                        break;
                    }
                }
            }
            
            System.out.println("Successfully loaded " + employees.size() + " employee record(s) from '" + FILE_PATH + "'.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Data file '" + FILE_PATH + "' does not exist yet. Save data first.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading employee data: " + e.getMessage());
        }
    }
}
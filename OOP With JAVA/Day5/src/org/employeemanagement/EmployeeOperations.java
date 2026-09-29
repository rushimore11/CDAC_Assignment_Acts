package org.employeemanagement;

import org.utility.LinkedList;

import java.util.Scanner;

public class EmployeeOperations {

    private static LinkedList<Employee> employees =
            new LinkedList<>();

    private static Scanner sc = new Scanner(System.in);




    public static void addEmployee() {

        int choice;

        do {
            System.out.println("\n   Add Employee ");
            System.out.println("1. Manager");
            System.out.println("2. Engineer");
            System.out.println("3. Salesman");
            System.out.println("4. Exit to Main Menu");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addManager();
                    break;

                case 2:
                    addEngineer();
                    break;

                case 3:
                    addSalesman();
                    break;

                case 4:
                    System.out.println("Return to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }




    private static void addManager() {

        String name = getName();
        String address = getAddress();
        int age = getAge();
        String gender = getGender();
        double basicSalary = getBasicSalary();

        System.out.print("Enter HRA: ");
        double hra = sc.nextDouble();

        while (hra < 0) {

            System.out.println("HRA cannot be negative.");
            System.out.print("Enter HRA: ");

            hra = sc.nextDouble();
        }

        Employee employee =
                new Manager(
                         name,
                         address,
                        age,
                         gender,
                        basicSalary,
                         hra
                );

        employees.addNode(employee);

        System.out.println("Manager added successfully.");
    }




    private static void addEngineer() {

        String name = getName();
        String address = getAddress();
        int age = getAge();
        String gender = getGender();
        double basicSalary = getBasicSalary();

        System.out.print("Enter Overtime: ");
        double overtime = sc.nextDouble();

        while (overtime < 0) {

            System.out.println("Overtime cannot be negative.");
            System.out.print("Enter Overtime: ");

            overtime = sc.nextDouble();
        }

        Employee employee =
                new Engineer(
                         name,
                        address,
                         age,
                        gender,
                          basicSalary,
                        overtime
                );

        employees.addNode(employee);

        System.out.println("Engineer added successfully.");
    }




    private static void addSalesman() {

        String name = getName();
        String address = getAddress();
        int age = getAge();
        String gender = getGender();
        double basicSalary = getBasicSalary();

        System.out.print("Enter Commission: ");
        double commission = sc.nextDouble();

        while (commission < 0) {

            System.out.println("Commission cannot be negative.");
            System.out.print("Enter Commission: ");

            commission = sc.nextDouble();
        }

        Employee employee =
                new Salesman(
                        name,
                        address, age,
                         gender,
                        basicSalary,
                        commission
                );

        employees.addNode(employee);

        System.out.println("Salesman added successfully.");
    }




    private static String getName() {

        String name;

        do {

            System.out.print("Enter Name: ");
            name = sc.nextLine().trim();

            if (name.length() <= 1) {
                System.out.println("Name must contain more than 1 character.");
            }

        } while (name.length() <= 1);

        return name;
    }


    private static String getAddress() {

        String address;

        do {

            System.out.print("Enter Address: ");
            address = sc.nextLine().trim();

            if (address.length() <= 2) {
                System.out.println("Address must contain more than 2 characters.");
            }

        } while (address.length() <= 2);

        return address;
    }


    private static int getAge() {

        int age;

        do {

            System.out.print("Enter Age: ");
            age = sc.nextInt();

            if (age <= 18) {
                System.out.println("Age must be greater than 18.");
            }

        } while (age <= 18);

        sc.nextLine();

        return age;
    }


    private static String getGender() {

        String gender;

        do {

            System.out.print("Enter Gender (Male/Female): ");
            gender = sc.nextLine().trim();

            if (!(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female"))) {

                System.out.println("Invalid gender.");
            }

        } while (!(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")));

        return gender;
    }


    private static double getBasicSalary() {

        double salary;

        do {

            System.out.print("Enter Basic Salary: ");
            salary = sc.nextDouble();

            if (salary <= 0) {
                System.out.println("Basic salary must be greater than 0.");
            }

        } while (salary <= 0);

        return salary;
    }




    public static void displayMenu() {

        int choice;

        do {

            System.out.println("\n=== Display =====");
            System.out.println("1. All Employees");
            System.out.println("2. First Employee");
            System.out.println("3. Next Employee");
            System.out.println("4. Previous Employee");
            System.out.println("5. Last Employee");
            System.out.println("6. Exit to Main Menu");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    displayAll();
                    break;

                case 2:
                    displayFirst();
                    break;

                case 3:
                    displayNext();
                    break;

                case 4:
                    displayPrevious();
                    break;

                case 5:
                    displayLast();
                    break;

                case 6:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }




    private static void displayAll() {

        Employee employee = employees.getFirst();

        if (employee == null) {
            System.out.println("No employees available.");
            return;
        }

        while (employee != null) {

            System.out.println(employee);

            System.out.println(
                    "Calculated Salary : " + employee.calculateSalary());

            System.out.println();

            employee = employees.getNext();
        }
    }




    private static void displayFirst() {

        Employee employee = employees.getFirst();

        if (employee == null) {
            System.out.println("No employees available.");
            return;
        }

        System.out.println(employee);

        System.out.println(
                "Calculated Salary : " + employee.calculateSalary());
    }




    private static void displayNext() {

        Employee employee = employees.getNext();

        if (employee == null) {
            System.out.println("No next employee.");
            return;
        }

        System.out.println(employee);

        System.out.println(
                "Calculated Salary : " + employee.calculateSalary());
    }




    private static void displayPrevious() {

        Employee employee = employees.getPrevious();

        if (employee == null) {
            System.out.println("No previous employee.");
            return;
        }

        System.out.println(employee);

        System.out.println(
                "Calculated Salary : " + employee.calculateSalary());
    }




    private static void displayLast() {

        Employee employee = employees.getLast();

        if (employee == null) {
            System.out.println("No employees available.");
            return;
        }

        System.out.println(employee);

        System.out.println("Calculated Salary : " + employee.calculateSalary());
    }




    public static void sortMenu() {

        int choice;

        do {

            System.out.println("\n----- Sort ---------");
            System.out.println("1. All Managers");
            System.out.println("2. All Engineers");
            System.out.println("3. All Salesman");
            System.out.println("4. All Employees Alphabetic Ascending");
            System.out.println("5. All Employees Alphabetic Descending");
            System.out.println("6. Exit to Main Menu");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    displayManagers();
                    break;

                case 2:
                    displayEngineers();
                    break;

                case 3:
                    displaySalesman();
                    break;

                case 4:
                    sortAscending();
                    break;

                case 5:
                    sortDescending();
                    break;

                case 6:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }




    private static void displayManagers() {

        Employee employee = employees.getFirst();

        boolean found = false;

        while (employee != null) {

            if (employee instanceof Manager) {

                System.out.println(employee);

                System.out.println(
                        "Calculated Salary : " + employee.calculateSalary());

                System.out.println();

                found = true;
            }

            employee = employees.getNext();
        }

        if (!found) {
            System.out.println("No Managers found.");
        }
    }




    private static void displayEngineers() {

        Employee employee = employees.getFirst();

        boolean found = false;

        while (employee != null) {

            if (employee instanceof Engineer) {

                System.out.println(employee);

                System.out.println("Calculated Salary : " + employee.calculateSalary()
                );

                System.out.println();

                found = true;
            }

            employee = employees.getNext();
        }

        if (!found) {
            System.out.println("No Engineers found.");
        }
    }




    private static void displaySalesman() {

        Employee employee = employees.getFirst();

        boolean found = false;

        while (employee != null) {

            if (employee instanceof Salesman) {

                System.out.println(employee);

                System.out.println("Calculated Salary : " + employee.calculateSalary());

                System.out.println();

                found = true;
            }

            employee = employees.getNext();
        }

        if (!found) {
            System.out.println("No Salesman found.");
        }
    }




    private static void sortAscending() {

        System.out.println("Ascending sorting will be implemented after completing LinkedList.");
    }




    private static void sortDescending() {
        System.out.println("Descending sorting will be implemented after completing LinkedList.");
    }
}
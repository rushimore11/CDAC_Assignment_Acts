package org.EmployeeManagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgramMenu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("\n******* Employee Management System *******");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Sort Employees");
            System.out.println("4. Save Employees to File");
            System.out.println("5. Load Employees from File");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> EmployeeOperations.addEmployee();
                    case 2 -> EmployeeOperations.displayMenu();
                    case 3 -> EmployeeOperations.sortMenu();
                    case 4 -> EmployeeOperations.saveToFile();
                    case 5 -> EmployeeOperations.loadFromFile();
                    case 6 -> System.out.println("Thank you for using Employee Management System!");
                    default -> System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid numerical choice.");
                sc.nextLine(); // clear invalid input
            }

        } while (choice != 6);

        sc.close();
    }
}


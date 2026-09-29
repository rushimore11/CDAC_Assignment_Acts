package org.employeemanagement;

import java.util.Scanner;

public class ProgramMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n*******Employee Management System ******");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employee");
            System.out.println("3. Sort Employee");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    EmployeeOperations.addEmployee();
                    break;

                case 2:
                    EmployeeOperations.displayMenu();
                    break;

                case 3:
                    EmployeeOperations.sortMenu();
                    break;

                case 4:
                    System.out.println("Thank you");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}
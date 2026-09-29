

import Q1.ConsoleInput; // Keeps imports uniform with the operational file

public class Main {
    public static void main(String[] args) {
        
        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Add an Employee\n"
                             + "2. Display\n"
                             + "3. Sort / Filter Employee\n"
                             + "4. Save to File\n"
                             + "5. Load From File\n"
                             + "6. Exit");
            
            System.out.print("Enter your choice (1-6): ");
            int choice = ConsoleInput.getInt(); 

            switch (choice) {
                case 1: { 
                    EmployeeOperations.addEmployee();
                    break;
                }
                case 2: {
                    boolean inDisplayMenu = true;
                    while (inDisplayMenu) {
                        System.out.println("\n--- DISPLAY SUB-MENU ---");
                        System.out.println("1. All Employees\n"
                                         + "2. First Employee\n"
                                         + "3. Next Employee\n"
                                         + "4. Previous Employee\n"
                                         + "5. Last Employee\n"
                                         + "6. Exit To Main Menu");
                        
                        System.out.print("Enter sub-choice (1-6): ");
                        int subChoice = ConsoleInput.getInt();

                        switch (subChoice) {
                            case 1: EmployeeOperations.displayAll(); break;
                            case 2: EmployeeOperations.displayFirst(); break;
                            case 3: EmployeeOperations.displayNext(); break;
                            case 4: EmployeeOperations.displayPrevious(); break;
                            case 5: EmployeeOperations.displayLast(); break;
                            case 6: inDisplayMenu = false; break;
                            default: System.out.println("Invalid option!");
                        }
                    }
                    break;
                }
                
                case 3: {
                    boolean inSortMenu = true;
                    while (inSortMenu) {
                        System.out.println("\n--- SORT & FILTER SUB-MENU ---");
                        System.out.println("1. All Managers\n"
                                         + "2. All Engineers\n"
                                         + "3. All Sales Persons\n"
                                         + "4. All Employees Alphabetic order ascending\n"
                                         + "5. All Employees Alphabetic order descending\n"
                                         + "6. Exit To Main Menu");
                        
                        System.out.print("Enter sub-choice (1-6): ");
                        int subChoice = ConsoleInput.getInt();

                        switch (subChoice) {
                            case 1: EmployeeOperations.filterByRole("Manager"); break;
                            case 2: EmployeeOperations.filterByRole("Engineer"); break;
                            case 3: EmployeeOperations.filterByRole("Salesman"); break;
                            case 4: EmployeeOperations.sortAlphabetical(true); break;
                            case 5: EmployeeOperations.sortAlphabetical(false); break;
                            case 6: inSortMenu = false; break;
                            default: System.out.println("Invalid option!");
                        }
                    }
                    break;
                }
                    
                case 4: {
                    System.out.println("Feature Disabled (Save functionality skipped).");
                    break;
                }
                case 5: {
                    System.out.println("Feature Disabled (Load functionality skipped).");
                    break;
                }
                    
                case 6: {
                    System.out.println("Exiting Safely.... Thank you!");
                    return;
                }
                default:
                    System.out.println("Invalid main menu choice. Try again.");
            }
        }
    }
}

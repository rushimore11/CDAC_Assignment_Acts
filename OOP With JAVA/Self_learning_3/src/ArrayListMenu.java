import java.util.Scanner;

public class ArrayListMenu {
    public static void showMenu(Scanner scanner) {
        ArrayListOperations operations = new ArrayListOperations();

        while (true) {
            System.out.println("\n-- ARRAYLIST OPERATIONS MENU ---");
            System.out.println("1. Print Collection (Q1)");
            System.out.println("2. Insert at First Position (Q2)");
            System.out.println("3. Retrieve Element by Index (Q3)");
            System.out.println("4. Update Element by Index (Q4)");
            System.out.println("5. Remove Third Element (Q5)");
            System.out.println("6. Search for Element (Q6)");
            System.out.println("7. Sort List (Q7)");
            System.out.println("8. Copy to Another List (Q8)");
            System.out.println("9. Shuffle List (Q9)");
            System.out.println("10. Reverse List (Q10)");
            System.out.println("0. Return to Main ");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    operations.printCollection();
                    break;
                case 2:
                    System.out.print("Enter color name to insert at first slot: ");
                    operations.insertAtFirst(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Enter index (0 to " + (operations.getSize() - 1) + "): ");
                    operations.retrieveByIndex(scanner.nextInt());
                    break;
                case 4:
                    System.out.print("Enter index to update: ");
                    int upIdx = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new color name: ");
                    operations.updateByIndex(upIdx, scanner.nextLine());
                    break;
                case 5:
                    operations.removeThird();
                    break;
                case 6:
                    System.out.print("Enter color to search: ");
                    operations.searchElement(scanner.nextLine());
                    break;
                case 7:
                    operations.sortList();
                    break;
                case 8:
                    operations.copyList();
                    break;
                case 9:
                    operations.shuffleList();
                    break;
                case 10:
                    operations.reverseList();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

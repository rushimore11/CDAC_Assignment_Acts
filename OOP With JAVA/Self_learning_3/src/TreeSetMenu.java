
import java.util.Scanner;

public class TreeSetMenu {
    public static void showMenu(Scanner scanner) {
        TreeSetOperations operations = new TreeSetOperations();

        while (true) {
            System.out.println("\n- TREESET OPERATIONS MENU ---");
            System.out.println("1. Print TreeSet (Q11)");
            System.out.println("2. Add All to Another TreeSet (Q12)");
            System.out.println("3. Create Reverse Order View (Q13)");
            System.out.println("4. Get First and Last Elements (Q14)");
            System.out.println("5. Get Element Greater/Equal to Input (Q15)");
            System.out.println("0. Return to Main Dashboard");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    operations.printTreeSet();
                    break;
                case 2:
                    operations.addAllToAnother();
                    break;
                case 3:
                    operations.showReverseView();
                    break;
                case 4:
                    operations.showFirstAndLast();
                    break;
                case 5:
                    System.out.print("Enter color element threshold value: ");
                    operations.showCeilingElement(scanner.nextLine());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Try again........");
            }
        }
    }
}

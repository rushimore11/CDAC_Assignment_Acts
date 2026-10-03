import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= MAIN DASHBOARD ===");
            System.out.println("1. Open ArrayList Menu (Q1 -10)");
            System.out.println("2. Open TreeSet Menu (Q11- 15)");
            System.out.println("0. Exit...");
            System.out.print("Select a menu option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    ArrayListMenu.showMenu(scanner);
                    break;
                case 2:
                    TreeSetMenu.showMenu(scanner);
                    break;
                case 0:
                    System.out.println("Exiting Thank u!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid selection. Please choose 1, 2, or 0.");
            }
        }
    }
}

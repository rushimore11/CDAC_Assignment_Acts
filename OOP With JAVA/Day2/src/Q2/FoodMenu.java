package Q2;

//Display food menu to user. User will select items from menu along with the quantity. (eg 1. Dosa 2. Samosa 3. Idli ... 10 . Generate Bill ) Assign fixed prices to food items(hard code the prices)
//When user enters 'Generate Bill' option(10) , display total bill & exit.

public class FoodMenu {
    public static void main(String[] args) {
        int totalBill = 0;

        while (true) {
            
            System.out.println("\n--- HOTEL MENU ---");
            System.out.println("1. Dosa      - Rs. 40");
            System.out.println("2. Samosa    - Rs. 15");
            System.out.println("3. Idli      - Rs. 20");
            System.out.println("4. Vada      - Rs. 15");
            System.out.println("5. Puri      - Rs. 35");
            System.out.println("6. Pongal    - Rs. 45");
            System.out.println("7. Coffee    - Rs. 15");
            System.out.println("8. Tea       - Rs. 12");
            System.out.println("9. Juice     - Rs. 30");
            System.out.println("10. Meals    - Rs. 80");
            System.out.println("11. Generate Bill & Exit");
            System.out.print("Select Choice : ");
            
            int choice = ConsoleInput.getInt();

           
            if (choice == 11) {
                System.out.println("\n==========================");
                System.out.println("Final Total Bill: Rs. " + totalBill);
                System.out.println("Thank You! Visit Again.");
                System.out.println("==========================");
                break; 
            }

            System.out.print("Enter Quantity: ");
            int qty = ConsoleInput.getInt();

            
            switch (choice) {
                case 1:  totalBill = totalBill + (40 * qty);  
                break;
                case 2:  totalBill = totalBill + (15 * qty); 
                break;
                case 3:  totalBill = totalBill + (20 * qty);  
                break;
                case 4:  totalBill = totalBill + (15 * qty);  
                break;
                case 5:  totalBill = totalBill + (35 * qty); 
                break;
                case 6:  totalBill = totalBill + (45 * qty);  
                break;
                case 7:  totalBill = totalBill + (15 * qty);  
                break;
                case 8:  totalBill = totalBill + (12 * qty); 
                break;
                case 9:  totalBill = totalBill + (30 * qty);  
                break;
                case 10: totalBill = totalBill + (80 * qty);  
                break;
                default: System.out.println("Invalid Choice!"); 
                break;
            }
        }
    }
}

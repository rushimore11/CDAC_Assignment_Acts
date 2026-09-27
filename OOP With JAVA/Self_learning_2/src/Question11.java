import java.util.Scanner;

public class Question11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the total numbers you wish to sort: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the value: ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Choose sorting direction:");
        System.out.println("2. Sort in ascending order");
        System.out.println("3. Sort in descending order");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        // bubble sort 
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

       
        if (choice == 2) {
            System.out.print("2 - Ascending Array Is : [");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + (i < n - 1 ? ", " : ""));
            }
            System.out.println("]");
        } else if (choice == 3) {
            System.out.print("3 - Descending array is : [");
            for (int i = n - 1; i >= 0; i--) {
                System.out.print(arr[i] + (i > 0 ? ", " : ""));
            }
            System.out.println("]");
        } else {
            System.out.println("Invalid choice selection entered!");
        }

        sc.close();
    }
}

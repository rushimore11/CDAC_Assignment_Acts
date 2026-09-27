import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        int sum = 0;

        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the value: ");
            nums[i] = sc.nextInt();
            sum += nums[i];
        }

      
        System.out.print("Your inputs: ");
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        
        System.out.println("\nTotal of  values: " + sum);
        sc.close();
    }
}

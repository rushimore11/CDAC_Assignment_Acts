import java.util.Scanner;

public class Question13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input a positive integer: ");
        int originalNumber = sc.nextInt();

        int temp = originalNumber;
        int reversedNumber = 0;

        
        while (temp > 0) {
            int lastDigit = temp % 10;
            reversedNumber = (reversedNumber * 10) + lastDigit;
            temp = temp / 10;
        }

        boolean isPalindrome = (originalNumber == reversedNumber);
        
        System.out.println("Is " + originalNumber + " a palindrome number?");
        System.out.println("Output : " + isPalindrome);
        
        sc.close();
    }
}

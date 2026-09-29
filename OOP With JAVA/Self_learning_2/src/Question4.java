import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the first number : ");
        int a = sc.nextInt();
        System.out.print("Input the second number: ");
        int b = sc.nextInt();
        System.out.print("Input the third number : ");
        int c = sc.nextInt();

        
        boolean result = (b > a) && (c > b);
        
        System.out.println("The result is: " + result);
        sc.close();
    }
}

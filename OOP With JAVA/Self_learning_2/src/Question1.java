import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter  radius of the circle: ");
        double r = sc.nextDouble();

        
        double perimeter = 2 * 3.14 * r;
        double area = 3.14 * r * r;

        System.out.println("Perimeter is = " + perimeter);
        System.out.println("Area is = " + area);

        sc.close();
    }
}

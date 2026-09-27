import java.util.Scanner;

class Complex {
    double real;
    double imag;

 public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    // Methodaddition
    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imag + other.imag);
    }

    // Method  subtraction
    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imag - other.imag);
    }

    // Method for multiplication
    public Complex multiply(Complex other) {
        double r = (this.real * other.real) - (this.imag * other.imag);
        double i = (this.real * other.imag) + (this.imag * other.real);
        return new Complex(r, i);
    }

 
    public void print() {
        if (imag >= 0) {
            System.out.println(real + " + " + imag + "i");
        } else {
            System.out.println(real + " - " + (-imag) + "i");
        }
    }
}

public class Question4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting  first number
        System.out.println("Enter first complex number:");
        System.out.print("Real part: ");
        double r1 = scanner.nextDouble();
        System.out.print("Imaginary part: ");
        double i1 = scanner.nextDouble();
        Complex c1 = new Complex(r1, i1);

        // Getting inputs second number
        System.out.println("\nEnter second complex number:");
        System.out.print("Real part: ");
        double r2 = scanner.nextDouble();
        System.out.print("Imaginary part: ");
        double i2 = scanner.nextDouble();
        Complex c2 = new Complex(r2, i2);

    
        Complex sum = c1.add(c2);
        Complex diff = c1.subtract(c2);
        Complex prod = c1.multiply(c2);

        System.out.print("\nSum: ");
        sum.print();

        System.out.print("Difference: ");
        diff.print();

        System.out.print("Product: ");
        prod.print();

        scanner.close();
    }
}

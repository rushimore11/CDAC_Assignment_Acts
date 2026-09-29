class Triangle {
    double side1;
    double side2;
    double side3;

    // Constructor
    public Triangle(double s1, double s2, double s3) {
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // Method
    public double getArea() {
        double s = getPerimeter() / 2.0;
        double squareOfArea = s * (s - side1) * (s - side2) * (s - side3);
        return customSquareRoot(squareOfArea);
    }

    // square root method
    private double customSquareRoot(double number) {
        if (number < 0) return 0;
        double estimate = number / 2.0;
        if (estimate == 0) return 0;
        
        for (int i = 0; i < 100; i++) {
            estimate = 0.5 * (estimate + (number / estimate));
        }
        return estimate;
    }
}

public class Question2 {
    public static void main(String[] args) {
        
        Triangle myTriangle = new Triangle(3, 4, 5);

        System.out.println("- Triangle Sides (3, 4, 5) ---");
        System.out.println("Perimeter: " + myTriangle.getPerimeter() + " units");
        System.out.println("Area: " + myTriangle.getArea() + " sq units");
    }
}




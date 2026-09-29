class Rectangle {
    double length;
    double breadth;

    // Constructor
    public Rectangle(double l, double b) {
        length = l;
        breadth = b;
    }

    // Method to calculate area
    public double area() {
        return length * breadth;
    }
}

public class Question3 {
    public static void main(String[] args) {
        // Creating two rect objects
        Rectangle rect1 = new Rectangle(4, 5);
        Rectangle rect2 = new Rectangle(5, 8);

        System.out.println("Area of Rectangle 1 (4, 5): " + rect1.area());
        System.out.println("Area of Rectangle 2 (5, 8): " + rect2.area());
    }
}

class Student {
    String name;
    int roll_no;
    String phone_no;
    String address;

    // Constructor
    public Student(String studentName, int rollNo, String phone, String studentAddress) {
        name = studentName;
        roll_no = rollNo;
        phone_no = phone;
        address = studentAddress;
    }

    // Method
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + roll_no);
        System.out.println("Phone Number: " + phone_no);
        System.out.println("Address: " + address);
        System.out.println("-------------------");
    }
}

public class Question1 {
    public static void main(String[] args) {
        
        Student rushiPartA = new Student("Rushikesh", 2, "UNkown", "Unknown");
        System.out.println("- Part A: Initial Rushi Object --");
        rushiPartA.displayInfo();

        
        Student sam = new Student("Sam", 101, "9876543210", "Pune");
        Student rushiPartB = new Student("Rushikesh", 102, "7028200921", "Mont vert Wakad");

        System.out.println("--- Part B: Details of Sam and Rushi ");
        sam.displayInfo();
        rushiPartB.displayInfo();
    }
}




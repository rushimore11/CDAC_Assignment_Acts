// public class HelloWorld {
//     public static void main(String[] args) {
//         System.out.println("Hello, World!");
//     }
// }

//1. Variables and Data Types

// public class DataTypesExample {
//     public static void main(String[] args) {
//         int age = 25;
//         double price = 99.99;
//         char grade = 'A';
//         boolean isJavaFun = true;
//         String name = "Vijay";

//         System.out.println("Name: " + name + ", Age: " + age);
//     }
// }

//2. If-Else Condition (Conditional Statement)
// public class IfElseExample {
//     public static void main(String[] args) {
//         int number = 10;

//         if (number > 0) {
//             System.out.println("Positive Number");
//         } else if (number < 0) {
//             System.out.println("Negative Number");
//         } else {
//             System.out.println("Zero");
//         }
//     }
// }




//3. For Loop (Wrapping Statement)

// public class ForLoopExample {
//     public static void main(String[] args) {
       
//         for (int i = 1; i <= 5; i++) {
//             System.out.println("Count: " + i);
//         }
//     }
// }

//4. While Loop (Conditional Loop)

// public class WhileLoopExample {
//     public static void main(String[] args) {
//         int i = 1;
//         while (i <= 5) {
//             System.out.println("Value: " + i);
//             i++;
//         }
//     }
// }

// 5. Switch Case (Multiple Choice)
// public class SwitchExample {
//     public static void main(String[] args) {
//         int day = 3;
//         switch (day) {
//             case 1: System.out.println("Monday"); break;
//             case 2: System.out.println("Tuesday"); break;
//             case 3: System.out.println("Wednesday"); break;
//             default: System.out.println("Invalid Day");
//         }
//     }
// }

// 6. User Input using Scanner
// import java.util.Scanner;

// public class InputExample {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Enter your name: ");
//         String name = scanner.nextLine();

//         System.out.print("Enter your age: ");
//         int age = scanner.nextInt();

//         System.out.println("Hello " + name + ", you are " + age + " years old.");
//         scanner.close();
//     }
// }


// 7. Methods / Functions

// public class MethodExample {
//     public static int addNumbers(int a, int b) {
//         return a + b;
//     }

//     public static void main(String[] args) {
//         int result = addNumbers(5, 10);
//         System.out.println("Sum: " + result);
//     }
// }


// 8. Arrays
// public class ArrayExample {
//     public static void main(String[] args) {
//         int[] numbers = {10, 20, 30, 40, 50};

//         for (int i = 0; i < numbers.length; i++) {
//             System.out.println("Element at index " + i + ": " + numbers[i]);
//         }
//     }
// }



// 9. Basic Class and Object
// class Student {
//     String name;
//     int rollNo;

//     void display() {
//         System.out.println("Student: " + name + ", Roll No: " + rollNo);
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Student s1 = new Student(); 
//         s1.name = "Arun";
//         s1.rollNo = 101;
//         s1.display();
//     }
// }



// 10. Exception Handling (Try-Catch)
// public class ExceptionExample {
//     public static void main(String[] args) {
//         try {
//             // This will cause a runtime error (Division by Zero)
//             int divideByZero = 5 / 0; 
//         } catch (ArithmeticException e) {
//             // This block catches the specific error and handles it gracefully
//             System.out.println("Error: Cannot divide a number by zero!");
//         }
        
//         // Thanks to the try-catch block, the program does not crash and continues running
//         System.out.println("The rest of the program continues execution safely.");
//     }
// }

package Q1;
public class mainCalculator {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        while (true) {
            System.out.println("\n===== CALCULATOR MENU =====");
            System.out.println("1. Operation On Integer");
            System.out.println("2. Operation On  float");
            System.out.println("3. Operation on double");
            System.out.println("4. Exit");
            System.out.print("Select Data Type: ");
            
            int typeChoice = ConsoleInput.getInt();
            if (typeChoice == 4) {
            	System.out.println("Thank u Exiting Safely !!");
                return;
            }
            if (typeChoice < 1 || typeChoice > 3) {
                System.out.println("Invalid choice!");
                continue;
            }

            System.out.println("\n--- Select Operation ---");
            System.out.println("1. Add \n2. Subtract\n3. Multiply\n4. Divide");
            System.out.print("Choice: ");
            int opChoice = ConsoleInput.getInt();

            switch (typeChoice) {
                case 1: 
                    System.out.print("Enter first integer: ");
                    int i1 = ConsoleInput.getInt();
                    System.out.print("Enter second integer: ");
                    int i2 = ConsoleInput.getInt();
                    if (opChoice == 1) { 
                    	System.out.println("Result: " + calc.add(i1, i2));
                    }
                    else if (opChoice == 2) {
                    	System.out.println("Result: " + calc.subtract(i1, i2));
                    }
                    else if (opChoice == 3) {
                    	System.out.println("Result: " + calc.multiply(i1, i2));
                    }
                    else if (opChoice == 4) {
                    	System.out.println("Result: " + calc.divide(i1, i2));
                    }
                    break;

                case 2: 
                    System.out.print("Enter first float: ");
                    float f1 = ConsoleInput.getFloat();
                    System.out.print("Enter second float: ");
                    float f2 = ConsoleInput.getFloat();
                    if (opChoice == 1) {
                    	System.out.println("Result: " + calc.add(f1, f2));
                    }
                    else if (opChoice == 2) {
                    	System.out.println("Result: " + calc.subtract(f1, f2));
                    }
                    else if (opChoice == 3) {
                    	System.out.println("Result: " + calc.multiply(f1, f2));
                    }
                    else if (opChoice == 4) {
                    	System.out.println("Result: " + calc.divide(f1, f2));
                    }
                    break;

                case 3: 
                    System.out.print("Enter first double: ");
                    double d1 = ConsoleInput.getDouble();
                    System.out.print("Enter second double: ");
                    double d2 = ConsoleInput.getDouble();
                    if (opChoice == 1) {
                    	System.out.println("Result: " + calc.add(d1, d2));
                    }
                    else if (opChoice == 2) {
                    	System.out.println("Result: " + calc.subtract(d1, d2));
                    }
                    else if (opChoice == 3) {
                    	System.out.println("Result: " + calc.multiply(d1, d2));
                    }
                    else if (opChoice == 4) {
                    	System.out.println("Result: " + calc.divide(d1, d2));
                    }
                    break;
            }
        }
    }
}

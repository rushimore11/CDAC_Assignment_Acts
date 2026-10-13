package org.ADS;

public class Remainder_Q5 {

    private static int recursiveRemainder(int a, int b) {
 
        if (a < b) {
            return a;
        }
      
        return recursiveRemainder(a - b, b);
    }

    public static int remainder(int a, int b) {
        
        if (b == 0) {
            throw new ArithmeticException("Division by zero is undefined.");
        }

        int absA = Math.abs(a);
        int absB = Math.abs(b);

        int result = recursiveRemainder(absA, absB);

        if (a < 0) {
            return -result;
        }
        return result;
    }

    public static void main(String[] args) {
        // Verification Test Cases
        System.out.println("10 % 3   -> " + remainder(10, 3));   //  1
        System.out.println("-10 % 3  -> " + remainder(-10, 3));  // -1
        System.out.println("10 % -3  -> " + remainder(10, -3));  //  1
        System.out.println("-10 % -3 -> " + remainder(-10, -3)); // -1
    }
}

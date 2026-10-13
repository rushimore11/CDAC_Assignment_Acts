package org.ADS;
public class Multiply_Q6 {
    private static int recursiveMultiply(int a, int b) {
        if (b == 0) return 0;
        if (b == 1) return a;

        if ((b & 1) == 0) {
            return recursiveMultiply(a << 1, b >> 1);
        } 
       
        else {
            return a + recursiveMultiply(a << 1, b >> 1);
        }
    }

    public static int multiply(int a, int b) {
       
        int absA = Math.abs(a);
        int absB = Math.abs(b);
        
        int smaller = Math.min(absA, absB);
        int larger = Math.max(absA, absB);

		int result = recursiveMultiply(larger, smaller);

        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            return -result;
        }
        return result;
    }

    public static void main(String[] args) {
      
        System.out.println("5 * 4   -> " + multiply(5, 4));   
        System.out.println("-5 * 4  -> " + multiply(-5, 4));  
        System.out.println("5 * -4  -> " + multiply(5, -4));  
        System.out.println("-5 * -4 -> " + multiply(-5, -4)); 
    }
}

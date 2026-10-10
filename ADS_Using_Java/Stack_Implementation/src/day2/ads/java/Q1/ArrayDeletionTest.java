package day2.ads.java.Q1;
import java.util.Arrays;

public class ArrayDeletionTest {
    
    public static int deleteFromPosition(int[] arr, int n, int pos) {
        if (pos < 0 || pos >= n) {
            System.out.println("Error: Invalid position " + pos);
            return n;
        }
        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = 0; 
        return n - 1;
    }

    public static void main(String[] args) {
      
        int[] myArray = new int[10];
        myArray[0] = 10;
        myArray[1] = 20;
        myArray[2] = 30;
        myArray[3] = 40;
        myArray[4] = 50;
        
        int logicalSize = 5;
        System.out.println("Original Array: " + Arrays.toString(myArray) + " | Logical Size: " + logicalSize);

        
        int targetPos = 2;
        System.out.println("\nDeleting element at position index: " + targetPos);
        logicalSize = deleteFromPosition(myArray, logicalSize, targetPos);

        System.out.println("Updated Array: " + Arrays.toString(myArray) + " | New Logical Size: " + logicalSize);
    }
}

public class Question8{   

public static void main(String[] args) {
        int[] original = {10, 20, 30, 40, 50, 60, 70};
        int[] rotated = new int[7];

       
        for (int i = 0; i < original.length; i++) {
            rotated[i] = original[original.length - 1 - i];
        }

        
        System.out.print("Original Array: [");
        for (int i = 0; i < original.length; i++) {
            System.out.print(original[i] + (i < original.length - 1 ? ", " : ""));
        }
        System.out.println("]");

        // Print 
        System.out.print("Rotated Array: [");
        for (int i = 0; i < rotated.length; i++) {
            System.out.print(rotated[i] + (i < rotated.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}

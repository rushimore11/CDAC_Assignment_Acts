   
public class Question9{ 
public static void main(String[] args) {
        int[] original = {20, 30, 40};
        
       
        int[] swapped = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            swapped[i] = original[i];
        }

        
        if (swapped.length > 0) {
            int temp = swapped[0];
            swapped[0] = swapped[swapped.length - 1];
            swapped[swapped.length - 1] = temp;
        }

       
        System.out.print("Original Array: [");
        for (int i = 0; i < original.length; i++) {
            System.out.print(original[i] + (i < original.length - 1 ? ", " : ""));
        }
        System.out.println("]");

        System.out.print("New array after swapping the first and last elements: [");
        for (int i = 0; i < swapped.length; i++) {
            System.out.print(swapped[i] + (i < swapped.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}


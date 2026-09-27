public class Question10{    

public static void main(String[] args) {
        int[] arr1 = {1, 3, -5, 4};
        int[] arr2 = {1, 4, -5, -2};
        int[] result = new int[arr1.length];


        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] * arr2[i];
        }

        System.out.print("Result: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i < result.length - 1 ? ", " : ""));
        }
        System.out.println();
    }
}


public class Question12{    
public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {2, 5, 7, 8};
        
        int[] result = new int[array1.length + array2.length];
        
        int i = 0, j = 0, k = 0;
        
        
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }
        
        
        while (i < array1.length) {
            result[k++] = array1[i++];
        }
        
       
        while (j < array2.length) {
            result[k++] = array2[j++];
        }

       
        System.out.print("result = [");
        for (int index = 0; index < result.length; index++) {
            System.out.print(result[index] + (index < result.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}

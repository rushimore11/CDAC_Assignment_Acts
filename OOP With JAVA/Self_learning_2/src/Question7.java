
public class Question7{
public static void main(String[] args) {
       
        int[] arr = {50, -20, 0, 30, 40, 60, 10};

        if (arr.length >= 2) {
            boolean conditionMet = (arr[0] == arr[arr.length - 1]);
            System.out.println(conditionMet);
        } else {
            System.out.println("Array must contain at least 2 elements.");
        }
    }
}

public class Question14{    

public static void main(String[] args) {
        int[] sortedArray = {1, 2, 4, 5, 6};
        int target = 5; 

        int targetIndex = -1;

        
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] >= target) {
                targetIndex = i;
                break;
            }
        }

        if (targetIndex == -1) {
            targetIndex = sortedArray.length;
        }

        System.out.println("Target: " + target + " -> Index output: " + targetIndex);
    }
}

public class Question15{    
public static void main(String[] args) {
        int[] arr = {10, 99, 34, 78, 99, 21, 34, 56, 34, 78};
        
        
        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == true) {
                continue;
            }

            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            
            System.out.println(arr[i] + " appears " + count + (count == 1 ? " time" : " times"));
        }
    }
}

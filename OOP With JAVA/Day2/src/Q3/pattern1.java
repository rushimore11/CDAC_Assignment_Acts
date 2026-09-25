package Q3;

public class pattern1{
    public static void main(String[] args) {
        int rows = 5; 

        for (int i = rows; i >= 1; i--) {
           
            for (int j = 0; j < rows - i; j++) {
                System.out.print(" ");
            }
           
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
    
            System.out.println();
        }
    }
}

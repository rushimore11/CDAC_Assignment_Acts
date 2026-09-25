package Q3;


public class pattern2 {
    public static void main(String[] args) {
        int rows = 5;
        int cols = 6;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
               
                if (i == 1 || i == rows) {
                    System.out.print("*");
                }
               
                else if (i == 2 || i == 4) {
                    if (j == 1 || j == 2 || j == 5 || j == 6) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                
                else if (i == 3) {
                    if (j == 1 || j == 6) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}

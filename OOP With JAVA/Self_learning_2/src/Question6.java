public class Question6{     

public static void main(String[] args) {
        int count = 0;
        int num = 2;
        int sum = 0;

        while (count < 100) {
            boolean isPrime = true;
            
           
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                sum += num;
                count++;
            }
            num++;
        }

        System.out.println("Sum of the first 100 prime numbers: " + sum);
    }
    
}


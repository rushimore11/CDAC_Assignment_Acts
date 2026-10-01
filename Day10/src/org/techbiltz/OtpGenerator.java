package org.techbiltz;
import java.util.Random;
import java.util.function.Supplier;

public class OtpGenerator {
    public static void main(String[] args) {
        Supplier<String> generateOTP = () -> {
            char[] vowels = {'A', 'E', 'I', 'O', 'U'};
            Random random = new Random();
            
            // Pick a random vowel
            char firstChar = vowels[random.nextInt(vowels.length)];
            
            // Generate 4 random digits (0-9)
            StringBuilder digits = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                digits.append(random.nextInt(10));
            }
            
            return firstChar + digits.toString();
        };

        // Test the lambda
        System.out.println("Generated OTP 1: " + generateOTP.get()); // e.g., A8391
        System.out.println("Generated OTP 2: " + generateOTP.get()); // e.g., U8665
    }
}

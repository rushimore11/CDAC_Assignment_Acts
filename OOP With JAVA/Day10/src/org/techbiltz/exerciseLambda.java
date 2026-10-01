package org.techbiltz;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.function.*;

public class exerciseLambda {
    public static void main(String[] args) {
        Random random = new Random();

        // 1. Sort a string array in alphabetical order=
        Consumer<String[]> sortArray = arr -> Arrays.sort(arr);

        // 2. Find the largest number in an integer array
        Function<int[], Integer> findMax = arr -> Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);

        // 3. Find the smallest number in an integer array
        Function<int[], Integer> findMin = arr -> Arrays.stream(arr).min().orElse(Integer.MAX_VALUE);

        // 4. Generate a 3-digit random number (100 to 999)
        Supplier<Integer> threeDigitRandom = () -> random.nextInt(900) + 100;

        // 5. Take an integer array and return the reverse integer array
        UnaryOperator<int[]> reverseArray = arr -> {
            int[] reversed = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                reversed[i] = arr[arr.length - 1 - i];
            }
            return reversed;
        };

        // 6. Print the current date
        Consumer<LocalDate> printDate = date -> System.out.println("6. Current Date: " + date);

        // 7. Evaluate if a number entered is a Prime number
        Predicate<Integer> isPrime = n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };

        // 8. Accept 2 strings and return the concatenated value
        BiFunction<String, String, String> concatenate = (s1, s2) -> s1 + s2;


        //Testing
        
        System.out.println("-! Results !--");

        String[] words = {"orange", "apple", "banana"};
        sortArray.accept(words);
        System.out.println("1. Sorted Array: " + Arrays.toString(words));

        int[] numbers = {12, 45, 2, 67, 34};
        System.out.println("2. Max number: " + findMax.apply(numbers));
        System.out.println("3. Min number: " + findMin.apply(numbers));
        System.out.println("4. 3-Digit random: " + threeDigitRandom.get());
        System.out.println("5. Reversed array: " + Arrays.toString(reverseArray.apply(numbers)));
        
        printDate.accept(LocalDate.now());
        
        System.out.println("7. Is 17 Prime? " + isPrime.test(17));
        System.out.println("7. Is 40 Prime? " + isPrime.test(40));
        System.out.println("8. Concatenated: " + concatenate.apply("Hello ", "World!... Done the program"));
    }
}

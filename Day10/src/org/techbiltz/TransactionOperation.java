package org.techbiltz;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface TransactionOperation {
    
    static void filterAndPrint(List<Transaction> list, Predicate<Transaction> predicate, String message) {
        System.out.println(message);
        for (Transaction tx : list) {
            if (predicate.test(tx)) {
                System.out.println(tx);
            }
        }
    }

    static void calculateAndPrint(List<Transaction> list, Function<Transaction, Double> formula) {
        System.out.println("\n--- Calculated Amount Due ---");
        for (Transaction tx : list) {
            double finalDue = formula.apply(tx);
            System.out.printf("Tx ID: %d | Original: %.2f | Final Due: %.2f%n", 
                    tx.getTxId(), tx.getTxAmount(), finalDue);
        }
    }
}

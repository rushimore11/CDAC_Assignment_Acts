package org.techbiltz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProgramMain {
	Transaction tx1 = new Transaction(1, "1-oct-2026", 500000, true, false);
	Transaction tx2 = new Transaction(2, "11-nov-2025", 4830, false, true);
	Transaction tx3 = new Transaction(3, "24-Sept-2026", 746000, true, false);
	Transaction tx4 = new Transaction(4, "1-oct-2026", 483, true, false);
	Transaction tx5 = new Transaction(5, "14-sept-2026", 4230, false, false);
	
	List<Transaction> transactionList = new ArrayList<>();
	
	
	Predicate<Transaction> amountFilter = t -> t.getTxAmount() > 5000;
	
	Predicate<Transaction> statusFilter = t -> t.isTxStatus() == false;
	
	Function<Transaction, Double> amountDueCalculator = t -> {
		if (t.isTxArrears()) {
			return t.getTxAmount() + 500 + (0.18 * t.getTxAmount());
		} else {
			return (double) t.getTxAmount();
		}
	};

	public void setupAndExecute() {
		
		Collections.addAll(transactionList, tx1, tx2, tx3, tx4, tx5);
		
		TransactionOperation.filterAndPrint(
			transactionList, amountFilter, "\n-Transactions with Amount > 5000 ---"
		);
		
		TransactionOperation.filterAndPrint(
			transactionList, statusFilter, "\n- Transactions with Status = false ---"
		);
		
		
		TransactionOperation.calculateAndPrint(transactionList, amountDueCalculator);
	}

	public static void main(String[] args) {
		ProgramMain program = new ProgramMain();
		program.setupAndExecute();
	}
}

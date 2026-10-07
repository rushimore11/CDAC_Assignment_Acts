package com.bank.model;

import com.bank.exception.InsufficientFundsException;

public class SavingsAccount extends Account {
    public static final double MIN_BALANCE = 500.0;

    public SavingsAccount(String accountHolderName, double initialDeposit) {
        super(accountHolderName, AccountType.SAVINGS, initialDeposit);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.printf("$%,.2f deposited successfully. Updated Balance: $%,.2f%n", amount, this.balance);
        }
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) return;
        
        // Ensure minimum balance of $500 is maintained after withdrawal
        if (this.balance - amount < MIN_BALANCE) {
            throw new InsufficientFundsException("Transaction failed: Minimum balance of $" + MIN_BALANCE + " must be maintained!");
        }
        this.balance -= amount;
        System.out.printf("$%,.2f withdrawn successfully. Updated Balance: $%,.2f%n", amount, this.balance);
    }
}

package com.bank.model;

import com.bank.exception.InsufficientFundsException;

public class CurrentAccount extends Account {
    public static final double OVERDRAFT_LIMIT = 10000.0;

    public CurrentAccount(String accountHolderName, double initialDeposit) {
        super(accountHolderName, AccountType.CURRENT, initialDeposit);
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
        
        // Balance can go negative up to the specified overdraft limit
        if (this.balance - amount < -OVERDRAFT_LIMIT) {
            throw new InsufficientFundsException("Transaction failed: Exceeds overdraft limit of $" + OVERDRAFT_LIMIT);
        }
        this.balance -= amount;
        System.out.printf("$%,.2f withdrawn successfully. Updated Balance: $%,.2f%n", amount, this.balance);
    }
}

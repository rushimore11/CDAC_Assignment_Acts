package com.cdac.models;

import com.cdac.custom_exceptions.InsufficientFundsException;
import com.cdac.enums.AccountType;
import java.time.LocalDate;

public class CurrentAccount extends Account {
    public static final double OVERDRAFT_LIMIT = 10000.0;

    public CurrentAccount(String accountHolderName, double balance, LocalDate dateOfOpening) {
        super(accountHolderName, AccountType.CURRENT, balance, dateOfOpening);
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
        System.out.printf("Successfully deposited ₹%.2f. New Balance: ₹%.2f\n", amount, this.balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        // Can withdraw up to current balance + overdraft limit amount
        if (amount > (this.balance + OVERDRAFT_LIMIT)) {
            throw new InsufficientFundsException("Transaction Failed! Overdraft limit of ₹" + OVERDRAFT_LIMIT + " exceeded.");
        }
        this.balance -= amount;
        System.out.printf("Successfully withdrew ₹%.2f. Updated Balance/Overdraft position: ₹%.2f\n", amount, this.balance);
    }
}

package com.cdac.models;

import com.cdac.custom_exceptions.InsufficientFundsException;
import com.cdac.enums.AccountType;
import java.time.LocalDate;

public class SavingsAccount extends Account {
    public static final double MIN_BALANCE = 500.0;

    public SavingsAccount(String accountHolderName, double balance, LocalDate dateOfOpening) {
        super(accountHolderName, AccountType.SAVINGS, balance, dateOfOpening);
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
        System.out.printf("Successfully deposited ₹%.2f. New Balance: ₹%.2f\n", amount, this.balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (this.balance - amount < MIN_BALANCE) {
            throw new InsufficientFundsException("Transaction Failed! Savings account must maintain a minimum balance of ₹" + MIN_BALANCE);
        }
        this.balance -= amount;
        System.out.printf("Successfully withdrew ₹%.2f. Remaining Balance: ₹%.2f\n", amount, this.balance);
    }
}

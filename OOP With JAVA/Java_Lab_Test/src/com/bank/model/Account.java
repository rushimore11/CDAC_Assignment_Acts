package com.bank.model;

import java.time.LocalDate;

import com.bank.exception.InsufficientFundsException;

public abstract class Account {
    private static int idCounter = 1000; // Counter to generate unique account numbers
    
    private final String accountNumber;
    private String accountHolderName;
    private final AccountType accountType;
    protected double balance;
    private final LocalDate dateOfOpening;

    public Account(String accountHolderName, AccountType accountType, double balance) {
        this.accountNumber = "ACC" + (++idCounter);
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = balance;
        this.dateOfOpening = LocalDate.now();
    }

    // Abstract methods to be overridden by subclasses
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount) throws InsufficientFundsException;

    // Getters and Setters
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
    public AccountType getAccountType() { return accountType; }
    public double getBalance() { return balance; }
    public LocalDate getDateOfOpening() { return dateOfOpening; }

    @Override
    public String toString() {
        return String.format("A/C: %s | Name: %-15s | Type: %-7s | Balance: $%,.2f | Opened: %s",
                accountNumber, accountHolderName, accountType, balance, dateOfOpening);
    }
}

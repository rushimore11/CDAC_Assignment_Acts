package com.cdac.models;

import com.cdac.custom_exceptions.InsufficientFundsException;
import com.cdac.enums.AccountType;
import java.time.LocalDate;

public abstract class Account {
    private static int accountNoCounter = 50000; // Unique sequence start
    
    private final int accountNumber;
    private String accountHolderName;
    private AccountType accountType;
    protected double balance;
    private LocalDate dateOfOpening;

    public Account(String accountHolderName, AccountType accountType, double balance, LocalDate dateOfOpening) {
        this.accountNumber = ++accountNoCounter;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = balance;
        this.dateOfOpening = dateOfOpening;
    }

    // Abstract methods to be overriddenpolymorphically
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount) throws InsufficientFundsException;

    // Getters
    public int getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
    public AccountType getAccountType() { return accountType; }
    public double getBalance() { return balance; }
    public LocalDate getDateOfOpening() { return dateOfOpening; }

    @Override
    public String toString() {
        return String.format("Acc No: %d | Holder: %-15s | Type: %-7s | Balance: ₹%.2f | Opened: %s",
                accountNumber, accountHolderName, accountType, balance, dateOfOpening);
    }
}

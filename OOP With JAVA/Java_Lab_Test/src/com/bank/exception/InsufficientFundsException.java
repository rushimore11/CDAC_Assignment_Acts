package com.bank.exception;

// Exception thrown when an account has insufficient funds for a withdrawal
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

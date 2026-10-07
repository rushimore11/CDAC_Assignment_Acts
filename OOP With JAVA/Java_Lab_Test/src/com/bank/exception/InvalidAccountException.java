package com.bank.exception;

// Exception thrown for invalid inputs during account creation
public class InvalidAccountException extends Exception {
    public InvalidAccountException(String message) {
        super(message);
    }
}

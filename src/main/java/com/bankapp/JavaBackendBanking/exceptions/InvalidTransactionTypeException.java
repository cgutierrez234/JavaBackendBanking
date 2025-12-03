package com.bankapp.JavaBackendBanking.exceptions;

public class InvalidTransactionTypeException extends RuntimeException {

    public InvalidTransactionTypeException(String message) {
        super(message);
    }
    
}

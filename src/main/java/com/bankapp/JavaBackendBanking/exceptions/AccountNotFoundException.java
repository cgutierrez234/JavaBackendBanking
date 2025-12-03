package com.bankapp.JavaBackendBanking.exceptions;

public class AccountNotFoundException extends RuntimeException {
    
    public AccountNotFoundException(String message) {
        super(message);
    }
}

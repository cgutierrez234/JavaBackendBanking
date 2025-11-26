package com.bankapp.JavaBackendBanking.models;

public class User {

    private Long id;
    private String email;
    private String password;
    private String accountType;
    private double balance;

    //Constructor

    public User(Long id, String email, String password, String accountType, double balance) {
        this.id = id;
        this.email = email;;
        this.password = password;
        this.accountType = accountType;
        this.balance = balance; 
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }
    
    // Setters

    public void setId(Long id) {
    this.id = id;
        }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
    this.password = password;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }

}




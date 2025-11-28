package com.bankapp.JavaBackendBanking.models;

import jakarta.persistence.*;;

@Entity
@Table(name="Accounts")
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private double balance;
    private String accountType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Constructors

    // JPA needs a no args constructor

    public Account() {}

    public Account(double balance, String accountType, User user) {
        this.balance = balance;
        this.accountType = accountType;
        this.user = user;
    }

    //Getters 
    public Long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public User getUser() {
        return user;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setUser(User user) {
        this.user = user;
    }









    
}

package com.bankapp.JavaBackendBanking.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="Transactions")
public class Transaction {

    @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long id;

     @Column(nullable=false)
     private LocalDateTime timestamp;

     private double amount;
     private String transactionType;

     @ManyToOne
     @JoinColumn(name="account_id", nullable=false)
     private Account account;

     // This automatically adds the timestamp on creation to each transaction upon creation. 
     @PrePersist
     protected void onCreate() {
        timestamp = LocalDateTime.now();
     }

     // JPA needs a no args constructor!
     public Transaction() {}

     public Transaction(double amount, String transactionType, Account account) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.account = account;
     }

     //GETTERS

     public double getAmount() {
        return amount;
     }

     public String getTransactionType() {
        return transactionType;
     }

     public Account getAccount() {
        return account;
     }

     public LocalDateTime getTimestamp() {
        return timestamp;
     }

     //SETTERS

     public void setAmount(double amount) {
        this.amount = amount;
     }

     public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
     }

     public void setAccount(Account account) {
        this.account = account;
     }
}

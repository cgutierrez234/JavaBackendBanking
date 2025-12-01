package com.bankapp.JavaBackendBanking.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="Transactions")
public class Transaction {

    @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long id;

    // This makes it so once the timestamp is created, because it has to be, it is immutable. IMMUTABLE I SAY! 
    @CreationTimestamp
     @Column(nullable = false, updatable = false)
     private LocalDateTime timestamp;

     private double amount;
     private String transactionType;

     @ManyToOne
     @JoinColumn(name="account_id", nullable=false)
     private Account account;

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

     public void setTimestamp(LocalDateTime timestamp) {
      this.timestamp = timestamp;
     }
}

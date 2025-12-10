package com.bankapp.JavaBackendBanking.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="Loans")
public class Loan {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private double loanAmount;
    private double remainingBalance;
    private double interestRate;
    private int termLength;
    private LocalDateTime loanStartDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // No arg constructor for the JPA

    public Loan() {}

    // Constructor with all the args

    public Loan(double loanAmount,double interestRate, int termLength) {
        this.loanAmount = loanAmount;
        this.remainingBalance = loanAmount;
        this.interestRate = interestRate;
        this.termLength = termLength;
        this.loanStartDate = LocalDateTime.now();
    }

    //Getters

    public Long getId() {
        return id;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTermLength() {
        return termLength;
    }

    public LocalDateTime getLoanStartDate() {
        return loanStartDate;
    }

    //Setters 

    public void setId(Long id) {
        this.id = id;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setTermLength(int termLength) {
        this.termLength = termLength;
    }

    public void setLoanStartDate(LocalDateTime loanStartDate) {
        this.loanStartDate = loanStartDate;
    }


}

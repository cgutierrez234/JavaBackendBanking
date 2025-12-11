package com.bankapp.JavaBackendBanking.services;

import java.util.List;


import com.bankapp.JavaBackendBanking.models.Loan;
import com.bankapp.JavaBackendBanking.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.JavaBackendBanking.repositories.LoanRepository;
import com.bankapp.JavaBackendBanking.exceptions.LoanNotFoundException;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository){
        this.loanRepository = loanRepository;
    }

    public Loan addLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public Loan getLoanById(Long id) {
        return loanRepository.findById(id)
        .orElseThrow(() -> new LoanNotFoundException("Loan with id: " + id + " not found.")); // make sure to write the LoanNotFoundException.java class
    }

    public Loan makePayment(Long loanId, double amount) {
        Loan loan = loanRepository.findById(loanId)
        .orElseThrow(() -> new LoanNotFoundException("Loan with id: " + id + " not found."));

        double newBalance = loan.getRemainingBalance() - amount;
        if(newBalance < 0) {
            throw new IllegalArgumentException("Payment exceeds remaining balance.");
        }
        loan.setRemainingBalance(newBalance);
        return loanRepository.save(loan); // <---- this commits it to the database with the new value
    }

    public List<Loan> getLoansByUser(User user) {
        return loanRepository.findByUser(user);
    }

}

        
    
    


package com.bankapp.JavaBackendBanking.services;

import com.bankapp.JavaBackendBanking.repositories.TransactionRepository;
import com.bankapp.JavaBackendBanking.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transaction) {
        // Set the current timestamp automatically
        transaction.setTimestamp(LocalDateTime.now());
        // Save it to the DB
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionByAccountId(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    public List<Transaction> getTransactionsByAccountType(String accountType) {
        return transactionRepository.findByAccount_AccountType(accountType);
    }

    public List<Transaction> getByTransactionByType(String type) {
        return transactionRepository.findByTransactionType(type);
    }

    public List<Transaction> getTransactionByDateRange(LocalDateTime start, LocalDateTime end) {
        if(start.isAfter(end)) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }
        return transactionRepository.findByTimestampBetween(start, end);
    }

    public Transaction getLatestTransaction(Long accountId) {
     return transactionRepository.findTopByAccountIdOrderByTimestampDesc(accountId);
    }

    
}

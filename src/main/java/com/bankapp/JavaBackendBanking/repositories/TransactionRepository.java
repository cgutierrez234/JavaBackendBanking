package com.bankapp.JavaBackendBanking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bankapp.JavaBackendBanking.models.Transaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    
    // Get all transactions for a specific account
    List<Transaction> findByAccountId(Long accountId);

    //Get all transactions of a specific type
    List<Transaction> findByTransactionType(String transactionType);

    //Get transactions in a date range
    List<Transaction> findByTimestampBetween(LocalDateTime start, LocalDateTime end);

    //Get the latest transaction for the account
    Transaction findTopByAccountIdOrderByTimestampDesc(Long accountId);

    // Get the transaction based on the account type. Easier for customer to query off of "CHECKING" rather 
    List<Transaction> findByAccount_AccountType(String accountType); 
}


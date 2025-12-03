package com.bankapp.JavaBackendBanking.services;

import com.bankapp.JavaBackendBanking.exceptions.AccountNotFoundException;
import com.bankapp.JavaBackendBanking.exceptions.InsufficientFundsException;
import com.bankapp.JavaBackendBanking.exceptions.InvalidTransactionTypeException;
import com.bankapp.JavaBackendBanking.models.Account;
import com.bankapp.JavaBackendBanking.repositories.AccountRepository;

import com.bankapp.JavaBackendBanking.repositories.TransactionRepository;
import com.bankapp.JavaBackendBanking.models.Transaction;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

// import javax.security.auth.login.AccountNotFoundException;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        
        Account account = accountRepository.findById(transaction.getAccount().getId())
            .orElseThrow(() -> new AccountNotFoundException("Account not found."));

        switch(transaction.getTransactionType().toUpperCase()) {
            
            case "DEPOSIT":
                account.setBalance(account.getBalance() + transaction.getAmount());
                break;
            case "WITHDRAWAL":
                if(account.getBalance() < transaction.getAmount()) {
                    throw new InsufficientFundsException("Your funds are insufficient");
                }
                // Actually perform the withdrawal math
                account.setBalance(account.getBalance() - transaction.getAmount());
                break;
            case "TRANSFER":
                //Get the target account to transfer to
                Account target = accountRepository.findById(transaction.getTargetAccount().getId())
                    .orElseThrow(() -> new AccountNotFoundException("Account not found"));

                if(account.getBalance() < transaction.getAmount()) {
                    throw new IllegalArgumentException("Insufficient funds for transfer");
                }
                // Subtract from the SENDING account
                account.setBalance(account.getBalance() - transaction.getAmount());

                // Add the new amount to the target
                target.setBalance(target.getBalance() + transaction.getAmount());

                //Save receiver's updated balance
                accountRepository.save(target);
                break;
            default:
                //Throwing here also causes roll back
                throw new InvalidTransactionTypeException("Invalid transaction type" + transaction.getTransactionType());
        }
        // Save the sender's updated balance (or depositoro, or withdrawal from account)
        accountRepository.save(account);

        //Set that time stamp baybeeee
        transaction.setTimestamp(LocalDateTime.now());

        // Record the transaction itself for history
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

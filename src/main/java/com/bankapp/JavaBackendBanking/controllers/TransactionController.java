package com.bankapp.JavaBackendBanking.controllers;

import com.bankapp.JavaBackendBanking.models.Transaction;
import com.bankapp.JavaBackendBanking.services.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RestController
@RequestMapping("/transactions")
public class TransactionController {


    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/account/id/{accountId}")
    public List<Transaction> getTransactionsByAccountId(@PathVariable Long accountId) {
        return transactionService.getTransactionByAccountId(accountId);
    }

    @GetMapping("/account/type/{accountType}")
    public List<Transaction> getTransactionsByAccountType(@PathVariable String accountType) {
        return transactionService.getTransactionsByAccountType(accountType);
    }

    @PostMapping
    public ResponseEntity<?> handleCreateTransaction(@RequestBody Transaction transaction) {
        if(transaction.getAmount() <= 0) {
            return ResponseEntity.badRequest().body("Transaction amount must be positive . . .");
        }
        Transaction savedTransaction = transactionService.createTransaction(transaction);
        return ResponseEntity.ok(savedTransaction);
    }
    
}

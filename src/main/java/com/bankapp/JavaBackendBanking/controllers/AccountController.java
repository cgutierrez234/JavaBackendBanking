package com.bankapp.JavaBackendBanking.controllers;

import com.bankapp.JavaBackendBanking.services.AccountService;

import com.bankapp.JavaBackendBanking.models.Account;
import com.bankapp.JavaBackendBanking.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// The controller is the entry point for the HTTP request
@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/user/{userId}")
    public List<Account> getAccountsByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        return accountService.getAccountsByUser(user);
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        // Controller's job: receive JSON → turn into Account object → hand off to service.
        // It does NOT do business logic — just delegates to the service layer.
        return accountService.addAccount(account);
    }
    
}

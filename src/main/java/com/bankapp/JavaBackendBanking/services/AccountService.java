package com.bankapp.JavaBackendBanking.services;

import com.bankapp.JavaBackendBanking.models.Account;
import com.bankapp.JavaBackendBanking.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankapp.JavaBackendBanking.repositories.AccountRepository;

import com.bankapp.JavaBackendBanking.exceptions.AccountNotFoundException;

import java.util.List;




@Service
public class AccountService {

    private final AccountRepository accountRepository;


    @Autowired // Autowired is no long needed for SpringBoot 3+. It does it automatically for classes with only one constructor but I will leave it because I am learning. 
    public AccountService (AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
        .orElseThrow(() -> new AccountNotFoundException("Account with ID: " + id + " not found" )); // By default findById() returns Optional<Account> because Spring Data JPA's repository methods are designed to avoid null pointer exceptions. 
        // Instead of returning a plain account, which would be null if the record didn't exist, it wraps thevalue in an Optional<Account> - can hold a value or be empty.  The above utilized method unwraps it safely. 
        // If repo method starts with findBy . . it usually returns an Optional<T>
    }

    public List<Account> getAllAccounts() {
            return accountRepository.findAll();
    }

    public List<Account> getAccountsByUser(User user) {
        return accountRepository.findByUser(user);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }


    
}

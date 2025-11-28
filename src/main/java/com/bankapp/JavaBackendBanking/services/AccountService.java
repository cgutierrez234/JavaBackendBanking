package com.bankapp.JavaBackendBanking.services;

import com.bankapp.JavaBackendBanking.models.Account;
import com.bankapp.JavaBackendBanking.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankapp.JavaBackendBanking.repositories.AccountRepository;

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

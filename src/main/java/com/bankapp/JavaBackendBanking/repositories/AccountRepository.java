package com.bankapp.JavaBackendBanking.repositories;


import java.util.List;

import com.bankapp.JavaBackendBanking.models.Account;
import com.bankapp.JavaBackendBanking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // THIS CUSTOM QUERY RETURNS A LIST OF ACCOUNTS ASSOCIATED WITH A USER. THE RETURN TYPE GOES AT THE FRONT.
    List<Account> findByUser(User user);
}

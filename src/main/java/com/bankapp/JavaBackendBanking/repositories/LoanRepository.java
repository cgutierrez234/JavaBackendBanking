package com.bankapp.JavaBackendBanking.repositories;

import java.util.List;

import com.bankapp.JavaBackendBanking.models.Loan;
import com.bankapp.JavaBackendBanking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByUser(User user);

    
    /* Potential custom methods could be --findByInterestRateGreaterThan, findByRemainingBalanceLessThan */
    
}

package com.bankapp.JavaBackendBanking.models;

import jakarta.persistence.*;;

@Entity
@Table(name="Accounts")
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;

    private double balance;
    private String accountType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    
}

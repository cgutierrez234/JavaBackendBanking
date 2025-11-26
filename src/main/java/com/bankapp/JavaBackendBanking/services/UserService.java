package com.bankapp.JavaBackendBanking.services;

import com.bankapp.JavaBackendBanking.models.User;

import java.util.Map;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {
    
    private Map<String, User> users = new HashMap<>();

    public void addUser(User user) {
        if(users.containsKey(user.getEmail())) {
            System.out.println("The user already exists. No duplicates");
        } else {
            users.put(user.getEmail(), user);
            System.out.println("User added successfully");
        }
    }

    public User getUser(String email) {
        return users.get(email);
    }
}

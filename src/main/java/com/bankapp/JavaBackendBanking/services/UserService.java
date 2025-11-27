package com.bankapp.JavaBackendBanking.services;

import com.bankapp.JavaBackendBanking.models.User;
import com.bankapp.JavaBackendBanking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class UserService {
    
    private final UserRepository userRepository;

    //Constructor with Autowired. 
    @Autowired // Autowired is no long needed for SpringBoot 3+. It does it automatically for classes with only one constructor but I will leave it because I am learning. 
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

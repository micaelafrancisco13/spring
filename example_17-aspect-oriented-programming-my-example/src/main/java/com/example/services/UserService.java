package com.example.services;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final String name = "Ela Francisco";
    private String status;

    public void createUser(String status) {
        System.out.println("Creating user...");
        this.status = status;
    }

    public String getUserById(int id) throws Exception {
        System.out.println("Getting user...");

        if (id <= 0)
            throw new IllegalArgumentException("Invalid User ID");

        return name;
    }
}
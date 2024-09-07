package com.example.services;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final String name = "Ela Francisco";

    public void createUser(String status) {
        System.out.println("Creating user...");
    }

    public String getUser() {
        System.out.println("Getting user...");
        return name;
    }
}
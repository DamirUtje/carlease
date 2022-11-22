package com.damirutje.carlease.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String[] getUsers() {
        return new String[] { "User1", "User2", "User3" };
    }

}

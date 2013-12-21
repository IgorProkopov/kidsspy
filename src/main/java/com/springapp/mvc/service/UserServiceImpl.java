package com.springapp.mvc.service;

import com.springapp.mvc.reposetory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addNewUser(String name, String pass) {
        userRepository.addNewUser(name, pass);
    }

    @Override
    public int checkUser(String name, String pass) {
        return userRepository.checkUser(name, pass);
    }
}

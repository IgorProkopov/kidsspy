package com.springapp.mvc.service;

import com.springapp.mvc.reposetory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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

    @Override
    public int connectChild(String childName, String parentName) {
        return userRepository.connectChild(childName, parentName);
    }

    @Override
    public int disconnectChild(String childName, String parentName) {
        return userRepository.disconnectChild(childName, parentName);
    }

    @Override
    public String[] getConnectedChildren(String parentName) {
        return userRepository.getConnectedChildren(parentName);
    }
}

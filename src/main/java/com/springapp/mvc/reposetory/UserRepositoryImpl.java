package com.springapp.mvc.reposetory;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    Sender sender = new Sender("178.150.190.201");

    @Override
    public void addNewUser(String name, String pass) {
        sender.addNewUser(name, pass);
    }

    @Override
    public int checkUser(String name, String pass) {
        return sender.checkUser(name, pass);
    }
}

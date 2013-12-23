package com.springapp.mvc.reposetory;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    Sender sender = new Sender("127.0.0.1"/*"178.150.190.201"*/);

    @Override
    public void addNewUser(String name, String pass) {
        sender.addNewUser(name, pass);
    }

    @Override
    public int checkUser(String name, String pass) {
        return sender.checkUser(name, pass);
    }

    @Override
    public int connectChild(String childName, String parentName) {
        return sender.connectChild(childName, parentName);
    }

    @Override
    public int disconnectChild(String childName, String parentName) {
        return sender.connectChild(childName, parentName);
    }

    @Override
    public String[] getConnectedChildren(String parentName) {
        return sender.getArrayOfConnectedChildren(parentName);
    }
}
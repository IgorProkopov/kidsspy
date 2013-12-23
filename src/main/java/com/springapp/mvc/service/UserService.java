package com.springapp.mvc.service;

public interface UserService {

    public void addNewUser(String name, String pass);

    public int checkUser(String name, String pass);

    public int connectChild(String childName, String parentName);

}

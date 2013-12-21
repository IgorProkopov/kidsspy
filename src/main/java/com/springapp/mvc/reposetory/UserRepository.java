package com.springapp.mvc.reposetory;

public interface UserRepository {

    public void addNewUser(String name, String pass);

    public int checkUser(String name, String pass);

}

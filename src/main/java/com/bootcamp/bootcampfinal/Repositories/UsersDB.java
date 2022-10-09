package com.bootcamp.bootcampfinal.Repositories;

import com.bootcamp.bootcampfinal.Entities.User;

import java.util.ArrayList;

abstract public class UsersDB {
    private int totalAdded = 0;
    private int totalDeleted = 0;

    public int getTotalAdded() { return totalAdded; }
    public int getTotalDeleted() { return totalDeleted; }

    protected void increaseAddeed() { totalAdded++; }
    protected void increaseDeleted() { totalDeleted++; }

     abstract public ArrayList<User> getUser();
    abstract public User searchUser(User user);
    abstract public void create(User user);
    abstract public void delete(User user);

}

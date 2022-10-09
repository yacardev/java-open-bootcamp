package com.bootcamp.bootcampfinal.Repositories;
import com.bootcamp.bootcampfinal.Entities.User;

import java.util.ArrayList;

public class UserDBMemory extends UsersDB{
    ArrayList<User> users = new ArrayList();

    @Override
    public ArrayList<User> getUser() {
        return users;
    }

    @Override
    public User searchUser(User user) {
        for (User actualUser : getUser()) {
            if (actualUser.nickName.equalsIgnoreCase(user.nickName)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void create(User user){
        for(User actualUser : users) {
            if(actualUser.nickName.toLowerCase().equals(user.nickName.toLowerCase())){
                return;
            }
        }
        users.add(user);
        increaseAddeed();

    }

    @Override
    public void delete(User user){
        /*for(User actualUser : getUser()){
            if(actualUser.nickName.equalsIgnoreCase(user.nickName)){
                users.remove(user);
                increaseDeleted();
            }
        }*/
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).nickName.equalsIgnoreCase((user.nickName))){
                users.remove(i);
            }
        }
    }

}

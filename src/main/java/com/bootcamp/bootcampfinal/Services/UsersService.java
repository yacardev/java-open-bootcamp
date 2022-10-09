package com.bootcamp.bootcampfinal.Services;

import com.bootcamp.bootcampfinal.Builder.UserBuilder;
import com.bootcamp.bootcampfinal.Repositories.UserDBMemory;
import com.bootcamp.bootcampfinal.Repositories.UsersDB;
import com.bootcamp.bootcampfinal.Entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class UsersService {
    UsersDB usersDB = new UserDBMemory();

    public void Users(UsersDB usersDB){
        this.usersDB = usersDB;
    }

    public void Users(){}

    public ArrayList<User> usersList(){
        return usersDB.getUser();
    }

    public User searchUser(String userNickname){
        User user = new User();
        user.nickName = userNickname;
        return usersDB.searchUser(user);
    }

    public void createUser(User user){
        if(usersDB.searchUser(user) != null){
            return;
        }

        user = createUserBuilder(user);

        usersDB.create(user);
    }

    public void deleteUser(String nickName){
        User user = new User();
        user.nickName = nickName;
        usersDB.delete(user);
    }

    private User createUserBuilder(User user){
        UserBuilder userBuilder = new UserBuilder(user.nickName);
        return userBuilder
                .nickName(user.nickName)
                .name(user.name)
                .lastName(user.lastName)
                .email(user.email)
                .profile(user.profile)
                .build();
    }
}

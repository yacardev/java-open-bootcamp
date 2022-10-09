package com.bootcamp.bootcampfinal.Builder;

import com.bootcamp.bootcampfinal.Entities.User;

public class UserBuilder {

    private User user = new User();

    public UserBuilder() {}

    public UserBuilder(String nickname){
        user.name = "";
        user.lastName = "";
        user.email = "";
        user.profile = -1;

        user.nickName = nickname;
    }

    public UserBuilder nickName(String nickName){
        user.nickName = nickName.length() > 0 ? nickName : "sin nickname";
        return this;
    }

    public UserBuilder name(String name){
        user.name = name.length() > 0 ? name : "sin nombre";
        return this;
    }

    public UserBuilder lastName(String lastName){
        user.lastName = lastName.length() > 0 ? lastName : "sin lastName";
        return this;
    }

    public UserBuilder email(String email){
        user.email = email.length() > 0 ? email : "sin email";
        return this;
    }

    public UserBuilder profile(int profile){
        user.profile = profile > 0 ? profile : -1;
        return this;
    }

    public User build(){
        return user;
    }

}

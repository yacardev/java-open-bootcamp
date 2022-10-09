package com.bootcamp.bootcampfinal.Entities;

//POJO: Plain Old Java Object
public class User {
    public String nickName = "";
    public String name = "";
    public String lastName = "";
    public String email = "";
    public int profile = -1;


    @Override
    public String toString() {
        return "User{" +
                "nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}
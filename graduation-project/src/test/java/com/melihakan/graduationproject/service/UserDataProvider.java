package com.melihakan.graduationproject.service;

import com.melihakan.graduationproject.entity.User;

public class UserDataProvider {

    public static User getUser(){

        User user = new User();
        user.setId("61f41123d9cb3c36d5ee83b3");
        user.setName("Ali");
        user.setSurName("ak");
        user.setPhoneNumber("5389639897");
        user.setBirthday("1996-11-12");
        user.setSalary(7000D);
        user.setAssurance(3000D);

        return user;
    }



}

package com.example.graduationprojectpostgresql.service;

import com.example.graduationprojectpostgresql.entity.User;

import java.time.LocalDate;

public class UserDataProvider {
    public static User getUser(){

        User user = new User();
        user.setId(22L);
        user.setName("Ahmet");
        user.setSurName("Sabun");
        user.setPhoneNumber("5303339933");
        user.setBirthday(LocalDate.parse("1995-01-26"));
        user.setSalary(6000D);
        user.setAssurance(3000D);

        return user;
    }
}

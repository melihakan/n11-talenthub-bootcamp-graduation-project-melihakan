package com.example.graduationprojectpostgresql.service;


import com.example.graduationprojectpostgresql.entity.User;

public interface SmsSenderService {

    void sendSms(User user);

}

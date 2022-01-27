package com.melihakan.graduationproject.service;

import com.melihakan.graduationproject.entity.User;

public interface SmsSenderService {

    void sendSms(User user);
}

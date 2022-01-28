package com.melihakan.graduationproject.service;

import com.melihakan.graduationproject.converter.UserConverter;
import com.melihakan.graduationproject.dtos.UserDto;

import com.melihakan.graduationproject.entity.User;
import com.melihakan.graduationproject.service.entityservice.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface UserService {


    UserDto save(User user);

    void delete(String id);
    UserDto update(UserDto userDto);
    User findByTc(String tc);
    User findByTcAndBirthday(String tc, String birthday);
    User findByBirthday(String birthday);


}

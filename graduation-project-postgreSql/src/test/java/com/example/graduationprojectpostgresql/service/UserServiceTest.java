package com.example.graduationprojectpostgresql.service;


import com.example.graduationprojectpostgresql.converter.UserConverter;
import com.example.graduationprojectpostgresql.dao.UserDao;
import com.example.graduationprojectpostgresql.dtos.UserDto;
import com.example.graduationprojectpostgresql.entity.User;
import com.example.graduationprojectpostgresql.service.entityservice.UserEntityService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class UserServiceTest {


    @InjectMocks
    private UserService userService;
    @Mock
    private UserEntityService userEntityService;
    @Mock
    private UserConverter userConverter;
    @Mock
    private UserDao userDao;

    @Test
    void save() {
        UserDto userDto = new UserDto();
        User user = UserDataProvider.getUser();

        when(userEntityService.save(ArgumentMatchers.any(User.class))).thenReturn(user);
        UserDto userDto1 = userService.save(user);
        User result = userConverter.convertUserDtoToUser(userDto1);
        assertEquals(user,result);
        assertEquals(22L,result.getId());
    }

    @Test
    void delete() {
        User user = UserDataProvider.getUser();
        when(userEntityService.getById(anyLong())).thenReturn(user);

        userService.delete(22L);

        verify(userEntityService).getById(anyLong());
        verify(userEntityService).delete(user);
    }

    @Test
    void update() {
        UserDto userDto = new UserDto();
        User user = UserDataProvider.getUser();
        UserDto userDto1 = userConverter.convertUserToUserDto(user);
        when(userEntityService.save(ArgumentMatchers.any(User.class))).thenReturn(user);
        UserDto result = userService.update(userDto1);
        assertEquals(userDto1,result);
        assertEquals(22L,result.getId());
    }

    @Test
    void findByTcAndBirthday() {
        User user = UserDataProvider.getUser();
        when(userEntityService.findByTcAndBirthday(anyString(), LocalDate.parse(anyString()))).thenReturn(user);
        User byTcAndBirthday = userService.findByTcAndBirthday(user.getTc(), user.getBirthday());
        assertEquals(user,byTcAndBirthday);
    }
}
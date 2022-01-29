package com.melihakan.graduationproject.service;


import com.melihakan.graduationproject.converter.UserConverter;
import com.melihakan.graduationproject.dtos.UserDto;
import com.melihakan.graduationproject.entity.User;
import com.melihakan.graduationproject.repository.UserRepository;
import com.melihakan.graduationproject.service.entityservice.UserEntityService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserEntityService userEntityService;

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserConverter userConverter;

    @Test
    public void save() {
        UserDto userDto = new UserDto();
        User user = UserDataProvider.getUser();

        when(userEntityService.save(ArgumentMatchers.any(User.class))).thenReturn(user);
        UserDto userDto1 = userService.save(user);
        User result = userConverter.convertUserDtoToUser(userDto1);
        assertEquals(user,result);
        assertEquals("61f41123d9cb3c36d5ee83b3",result.getId());

    }

    @Test
    public void delete() {

        User user = UserDataProvider.getUser();
        when(userEntityService.getById(anyString())).thenReturn(user);

        userService.delete("61f41123d9cb3c36d5ee83b3");

        verify(userEntityService).getById(anyString());
        verify(userEntityService).delete(user);

    }


    @Test
    public void update() {
        UserDto userDto = new UserDto();
        User user = UserDataProvider.getUser();
        UserDto userDto1 = userConverter.convertUserToUserDto(user);
        when(userEntityService.save(ArgumentMatchers.any(User.class))).thenReturn(user);
        UserDto result = userService.update(userDto1);
        assertEquals(userDto1,result);
        assertEquals("61f41123d9cb3c36d5ee83b3",result.getId());
    }

    @Test
    public void findByTcAndBirthday() {

        User user = UserDataProvider.getUser();
        when(userEntityService.findByTcAndBirthday(anyString(),anyString())).thenReturn(user);
        User byTcAndBirthday = userService.findByTcAndBirthday(user.getTc(), user.getBirthday());
        assertEquals(user,byTcAndBirthday);

    }
}
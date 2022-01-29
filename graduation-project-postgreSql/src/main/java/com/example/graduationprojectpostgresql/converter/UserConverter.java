package com.example.graduationprojectpostgresql.converter;


import com.example.graduationprojectpostgresql.dtos.UserDto;
import com.example.graduationprojectpostgresql.entity.User;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserDto convertUserToUserDto(User user);

    List<UserDto> convertUserToUserDtoList(List<User> userList);

    User convertUserDtoToUser(UserDto userDto);

    List<User> convertUserDtoToUserList(List<UserDto> userDtoList);
}

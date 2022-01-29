package com.example.graduationprojectpostgresql.controller;

import com.example.graduationprojectpostgresql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.graduationprojectpostgresql.dtos.UserDto;
import com.example.graduationprojectpostgresql.entity.User;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity save(@RequestBody User user){

        UserDto userDto = userService.save(user);

        return ResponseEntity.ok(userDto);
    }
    @PutMapping
    public ResponseEntity update(@RequestBody UserDto userDto){

        UserDto update = userService.update(userDto);
        return ResponseEntity.ok(update);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @GetMapping("/check/{tc}/{birthday}")
    public User findByTcAndBirthday(@PathVariable String tc,@PathVariable String birthday){
        User byBirthdayAndTc = userService.findByTcAndBirthday(tc, LocalDate.parse(birthday));
        return byBirthdayAndTc;
    }
}

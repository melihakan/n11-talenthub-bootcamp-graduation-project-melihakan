package com.melihakan.graduationproject.controller;

import com.melihakan.graduationproject.dtos.UserDto;
import com.melihakan.graduationproject.entity.User;
import com.melihakan.graduationproject.service.UserService;
import com.melihakan.graduationproject.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

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
    public void delete(@PathVariable String id){
        userService.delete(id);
    }

    @GetMapping("/check/{tc}/{birthday}")
    public User findByTcAndBirthday(@PathVariable String tc,@PathVariable String birthday){
        User byBirthdayAndTc = userService.findByTcAndBirthday(tc, LocalDate.parse(birthday));
        return byBirthdayAndTc;
    }


}

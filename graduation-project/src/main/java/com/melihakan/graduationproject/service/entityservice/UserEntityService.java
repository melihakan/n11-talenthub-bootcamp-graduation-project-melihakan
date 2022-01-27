package com.melihakan.graduationproject.service.entityservice;



import com.melihakan.graduationproject.entity.User;

import com.melihakan.graduationproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserEntityService {

    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User save(User user){
        return userRepository.save(user);
    }
    public void delete(User user){
        userRepository.delete(user);
    }
    public Optional<User> findById(String id){
       return userRepository.findById(id);
    }
    public User getById(String id){
        User user;
        Optional<User> optionalUser = findById(id);
        if(optionalUser.isPresent()){
            user = optionalUser.get();
        }else {
            throw new RuntimeException("Item not found!");
        }
        return user;
    }
    public User findByTc(String tc){
        return userRepository.findByTc(tc);
    }
    public User findByTcAndBirthday(String tc, LocalDate birthday){
        return userRepository.findByTcAndBirthday(tc,birthday);
    }
    public User findByBirthday(LocalDate birthday){
        return userRepository.findByBirthday(birthday);
    }




}

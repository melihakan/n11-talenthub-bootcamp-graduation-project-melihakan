package com.melihakan.graduationproject.repository;

import com.melihakan.graduationproject.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    User findByTc(String tc);
    User findByTcAndBirthday(String tc, LocalDate birthday);
    User findByBirthday(LocalDate birthday);

}

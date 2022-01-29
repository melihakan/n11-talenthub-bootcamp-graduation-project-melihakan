package com.example.graduationprojectpostgresql.dao;


import com.example.graduationprojectpostgresql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    User findByTc(String tc);
    User findByTcAndBirthday(String tc, LocalDate birthday);
    User findByBirthday(LocalDate birthday);

}

package com.example.graduationprojectpostgresql.service.entityservice;



import com.example.graduationprojectpostgresql.dao.UserDao;

import com.example.graduationprojectpostgresql.entity.User;

import com.example.graduationprojectpostgresql.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserEntityService extends BaseEntityService<User, UserDao> {

    public UserEntityService(UserDao dao) {
        super(dao);
    }

    public User findByTc(String tc){
        return getDao().findByTc(tc);
    }
    public User findByTcAndBirthday(String tc, LocalDate birthday){
        return getDao().findByTcAndBirthday(tc,birthday);
    }
    public User findByBirthday(LocalDate birthday){
        return getDao().findByBirthday(birthday);
    }









/*    public User findUserByLoanScoreIsLess(Long id){
       return getDao().findUserByLoanScoreIsLess(id);
    }*/




}

package com.example.graduationprojectpostgresql.service;



import com.example.graduationprojectpostgresql.converter.UserConverter;
import com.example.graduationprojectpostgresql.dtos.UserDto;
import com.example.graduationprojectpostgresql.entity.User;
import com.example.graduationprojectpostgresql.enums.EnumYesNo;
import com.example.graduationprojectpostgresql.exceptions.BirthdayAndTcDoNotEqualException;
import com.example.graduationprojectpostgresql.service.entityservice.UserEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserEntityService userEntityService;
    private final TwilioSmsSenderService twilioSmsSenderService;
    private int creditLimitMultiplier = 4;
    private double loanScoreMin = 500;
    private double loanScoreMax = 1000;
    private double salaryMin= 5000;
    private double salaryMax = 10000;

    public UserDto save(User user) {

        user = userLoanScoreCheck(user);
        UserDto userDto = UserConverter.INSTANCE.convertUserToUserDto(user);
        Double loanLimit = userDto.getLoanLimit();
        log.info("Current loanLimit" + loanLimit);
        return userDto;
    }

    public void delete(Long id) {

        User User = userEntityService.getById(id);

        userEntityService.delete(User);
        log.info("Delete: User is deleted");
    }
    public UserDto update(UserDto userDto){

        User user = UserConverter.INSTANCE.convertUserDtoToUser(userDto);
        user = userLoanScoreCheck(user);


        UserDto userDtos = UserConverter.INSTANCE.convertUserToUserDto(user);
        log.info("Update: User is updated");
        return userDtos;

    }
    public User findByTc(String tc){
        User findByTc = userEntityService.findByTc(tc);
        UserDto userDto = UserConverter.INSTANCE.convertUserToUserDto(findByTc);

        return findByTc;

    }
    private void sendSms(User user){
        twilioSmsSenderService.sendSms(user);
    }

    public User findByTcAndBirthday(String tc, LocalDate birthday){

        User findUserByTc = userEntityService.findByTc(tc);
        //User findUserByBirthday = userEntityService.findByBirthday(birthday);
        User byBirthdayAndTc = userEntityService.findByTcAndBirthday(tc, birthday);
        //if(findUserByTc.getId().equals(findUserByBirthday.getId()))
        if(byBirthdayAndTc.getTc().equals(findUserByTc.getTc())){
            log.info("Found: birthday and tc matchup");
            return byBirthdayAndTc;
        }else {
            throw new BirthdayAndTcDoNotEqualException("Birthday and Tc do not equal");
        }
    }

    private User userLoanScoreCheck(User user) {
        double currentLoanScore = user.getSalary() / 10;
        user.setLoanScore(currentLoanScore);
        if(currentLoanScore < loanScoreMin){
            user = userEntityService.save(user);
            log.info("DENIAL: Your loanScore is lower");
            user.setLoanResult(EnumYesNo.DENIAL);

        }else {
            if(currentLoanScore >= loanScoreMin && currentLoanScore <= loanScoreMax && user.getSalary() < salaryMin ){
                log.info("Confirm: Your loanScore is valid");
                user.setLoanResult(EnumYesNo.CONFIRMATION);
                user.setLoanLimit(10000D);
                if(!user.getAssurance().isInfinite()){
                    double v = user.getAssurance() * 10 / 100;
                    v = v+ user.getLoanLimit();
                    user.setLoanLimit(v);
                }

            }
            else if (currentLoanScore >= loanScoreMin && currentLoanScore <= loanScoreMax && user.getSalary() >= salaryMin && user.getSalary() <salaryMax){
                log.info("Confirm: Your loanScore is valid");
                user.setLoanResult(EnumYesNo.CONFIRMATION);
                user.setLoanLimit(20000D);
                if(!user.getAssurance().isInfinite()){
                    double v = user.getAssurance() * 20 /100;
                    v = v+ user.getLoanLimit();
                    user.setLoanLimit(v);
                }
            }
            else if (currentLoanScore >= loanScoreMin && currentLoanScore <= loanScoreMax && user.getSalary() >=salaryMax){
                log.info("Confirm: Your loanScore is valid");
                user.setLoanResult(EnumYesNo.CONFIRMATION);
                user.setLoanLimit(user.getSalary()*creditLimitMultiplier/2);
                if(!user.getAssurance().isInfinite()){
                    double v = user.getAssurance() * 25 /100;
                    v = v+ user.getLoanLimit();
                    user.setLoanLimit(v);
                }
            }
            else if (currentLoanScore >= loanScoreMax){
                log.info("Confirm: Your loanScore is valid");
                user.setLoanResult(EnumYesNo.CONFIRMATION);
                user.setLoanLimit(user.getSalary()*creditLimitMultiplier);
                if(!user.getAssurance().isInfinite()){
                    double v = user.getAssurance() * 50 / 100;
                    v = v+ user.getLoanLimit();
                    user.setLoanLimit(v);
                }
            }

            user = userEntityService.save(user);
            log.info("Save: User is saved");
            //sendSms(user); //TODO bunu açınca sms atar
            log.info("SMS: Sms is sent");
        }
        return user;
    }

}

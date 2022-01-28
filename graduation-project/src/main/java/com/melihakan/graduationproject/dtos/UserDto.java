package com.melihakan.graduationproject.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.melihakan.graduationproject.enums.EnumYesNo;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Date;

@Data
public class UserDto {

    private String id;
    private String tc;
    private String name;
    private String surName;
    private Double salary;
    private String phoneNumber;
    private String birthday;
    private Double assurance;
    private Double loanScore;
    private Double loanLimit;
    private EnumYesNo loanResult;



}

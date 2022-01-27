package com.melihakan.graduationproject.dtos;

import com.melihakan.graduationproject.enums.EnumYesNo;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {

    private String id;
    private String tc;
    private String name;
    private String surName;
    private Double salary;
    private String phoneNumber;
    private LocalDate birthday;
    private Double assurance;
    private Double loanScore;
    private Double loanLimit;
    private EnumYesNo loanResult;



}

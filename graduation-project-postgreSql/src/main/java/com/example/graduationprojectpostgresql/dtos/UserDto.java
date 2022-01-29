package com.example.graduationprojectpostgresql.dtos;


import com.example.graduationprojectpostgresql.enums.EnumYesNo;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {

    private Long id;
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

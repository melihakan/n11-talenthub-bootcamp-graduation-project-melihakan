package com.example.graduationprojectpostgresql.entity;


import com.example.graduationprojectpostgresql.enums.EnumYesNo;
import com.example.graduationprojectpostgresql.gen.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "USR_USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 11, max = 11)
    private String tc;
    private String name;
    private String surName;
    private Double salary;
    private String phoneNumber;
    private LocalDate birthday;
    private Double assurance;
    private Double loanScore;
    private Double loanLimit;

    @Enumerated(EnumType.STRING)
    private EnumYesNo loanResult;



}

package com.melihakan.graduationproject.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.melihakan.graduationproject.enums.EnumYesNo;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;


@Document(collection = "user")
@Data

public class User {

    @Id
    private String id;
    @Size(min = 11, max = 11)
    private String tc;
    private String name;
    private String surName;
    private Double salary;
    private String phoneNumber;

    private String birthday;

    private Double assurance;
    private Double loanScore;
    private Double loanLimit;

    @Enumerated(EnumType.STRING)
    private EnumYesNo loanResult;

}

package com.melihakan.graduationproject.entity;


import com.melihakan.graduationproject.enums.EnumYesNo;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;


@Document(collection = "user")
@Data
public class User {

    @Id
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

    @Enumerated(EnumType.STRING)
    private EnumYesNo loanResult;

}

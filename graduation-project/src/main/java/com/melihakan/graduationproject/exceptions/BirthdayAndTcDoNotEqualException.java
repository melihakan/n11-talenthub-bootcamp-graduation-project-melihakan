package com.melihakan.graduationproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BirthdayAndTcDoNotEqualException extends RuntimeException{

    public BirthdayAndTcDoNotEqualException(String message) {
        super(message);
    }
}

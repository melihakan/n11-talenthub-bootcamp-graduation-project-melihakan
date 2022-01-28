package com.melihakan.graduationproject.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
public class ExceptionResponse {

    public ExceptionResponse(Date errorDate, String message, String detail) {
        this.errorDate = errorDate;
        this.message = message;
        this.detail = detail;
    }

    private Date errorDate;
    private String message;
    private String detail;
}

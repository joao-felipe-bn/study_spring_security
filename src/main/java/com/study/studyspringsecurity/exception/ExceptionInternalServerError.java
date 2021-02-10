package com.study.studyspringsecurity.exception;

import lombok.Data;

@Data
public class ExceptionInternalServerError extends RuntimeException{

    public ExceptionInternalServerError(String message, String error){
        super();
        this.message = message;
        this.error = error;
    }

    private String message;
    private String error;

}

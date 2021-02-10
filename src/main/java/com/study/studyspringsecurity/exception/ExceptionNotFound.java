package com.study.studyspringsecurity.exception;

import lombok.Data;

@Data
public class ExceptionNotFound extends RuntimeException{

    public ExceptionNotFound(String message,String error){
        super();
        this.message = message;
        this.error = error;
    }

    private String message;
    private String error;

}

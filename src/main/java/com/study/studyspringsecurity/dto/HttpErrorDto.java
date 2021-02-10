package com.study.studyspringsecurity.dto;

import lombok.Data;

@Data
public class HttpErrorDto {

    private String httpError;

    private String message;
    private String error;
}

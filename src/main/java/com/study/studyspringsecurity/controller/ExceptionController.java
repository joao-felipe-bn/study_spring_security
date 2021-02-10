package com.study.studyspringsecurity.controller;

import com.study.studyspringsecurity.dto.HttpErrorDto;
import com.study.studyspringsecurity.exception.ExceptionInternalServerError;
import com.study.studyspringsecurity.exception.ExceptionNotFound;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@AllArgsConstructor
@ControllerAdvice
public class ExceptionController extends RuntimeException {

    @ExceptionHandler(ExceptionNotFound.class)
    public ResponseEntity<HttpErrorDto> handler(ExceptionNotFound exception){
        HttpErrorDto dto = new HttpErrorDto();
        dto.setHttpError(HttpStatus.NOT_FOUND.toString());

        dto.setError(exception.getError());
        dto.setMessage(exception.getMessage());

        return new ResponseEntity<HttpErrorDto>(dto,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExceptionInternalServerError.class)
    public ResponseEntity<HttpErrorDto> handler(ExceptionInternalServerError exception){
        HttpErrorDto dto = new HttpErrorDto();
        dto.setHttpError(HttpStatus.INTERNAL_SERVER_ERROR.toString());

        dto.setMessage(exception.getMessage());
        dto.setError(exception.getError());

        return new ResponseEntity<HttpErrorDto>(dto,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

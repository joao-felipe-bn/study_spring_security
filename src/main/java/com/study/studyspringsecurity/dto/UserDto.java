package com.study.studyspringsecurity.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long idUser;
    private String emailUser;
    private String nameUser;
    private String passwordUser;
    private boolean adminUser;

}

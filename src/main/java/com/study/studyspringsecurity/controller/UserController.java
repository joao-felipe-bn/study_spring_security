package com.study.studyspringsecurity.controller;


import com.study.studyspringsecurity.business.UserBusiness;
import com.study.studyspringsecurity.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@Api(value = "SPRING SECURITY")
@RequiredArgsConstructor
public class UserController {

    private final UserBusiness userBusiness;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        return new ResponseEntity(userBusiness.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        return new ResponseEntity(userBusiness.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> insert(@RequestBody UserDto dto) {
        return new ResponseEntity(userBusiness.saveAndUpdate(dto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto dto) {
        return new ResponseEntity(userBusiness.saveAndUpdate(dto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UserDto> delete(@PathVariable Long id) {
        userBusiness.delete(id);
        return ResponseEntity.noContent().build();
    }

}

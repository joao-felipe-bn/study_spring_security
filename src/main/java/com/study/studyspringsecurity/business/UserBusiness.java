package com.study.studyspringsecurity.business;

import com.study.studyspringsecurity.dto.UserDto;
import com.study.studyspringsecurity.entity.User;
import com.study.studyspringsecurity.exception.ExceptionInternalServerError;
import com.study.studyspringsecurity.exception.ExceptionNotFound;
import com.study.studyspringsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class UserBusiness {

    private final UserRepository userRepository;

    public UserDto saveAndUpdate(UserDto dto) {
        try {
            return entityToDto(userRepository.save(dtoToEntity(dto)));
        } catch (Exception e) {
            throw new ExceptionInternalServerError("Erro ao inserir usuário", e.getLocalizedMessage());
        }
    }

    public List<UserDto> findAll() {
        try {
            return entityToDto(userRepository.findAll());
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Recurso não Encontrado: " + e.getLocalizedMessage());
        } catch (Exception e) {
            throw new ExceptionInternalServerError("Erro ao consultar usuário: ", e.getLocalizedMessage());
        }
    }


    public UserDto findById(Long id) {
        try {
            return entityToDto(userRepository.findById(id).get());
        } catch (NoSuchElementException e) {
            throw new ExceptionNotFound("Recurso não Encontrado: ", e.getLocalizedMessage());
        } catch (Exception e) {
            throw new ExceptionInternalServerError("Erro ao consultar usuário: ", e.getLocalizedMessage());
        }
    }

    public void delete(Long id) {
        try {
            UserDto dto = findById(id);
            userRepository.delete(dtoToEntity(dto));
        } catch (Exception e) {
            throw new ExceptionInternalServerError("Erro ao deletar usuário: ", e.getLocalizedMessage());
        }
    }

    private List<UserDto> entityToDto(List<User> users) {
        List<UserDto> usersDto = new ArrayList<UserDto>();
        users.forEach(user -> {
            usersDto.add(entityToDto(user));
        });
        return usersDto;
    }

    private User dtoToEntity(UserDto dto) {
        User user = new User();

        user.setAdmin(dto.isAdminUser());
        user.setEmail(dto.getEmailUser());
        user.setName(dto.getNameUser());
        user.setPassword(dto.getPasswordUser());
        user.setId(dto.getIdUser());

        return user;
    }

    private UserDto entityToDto(User user) {
        UserDto dto = new UserDto();
        dto.setAdminUser(user.isAdmin());
        dto.setEmailUser(user.getEmail());
        dto.setNameUser(user.getName());
        dto.setPasswordUser(user.getPassword());
        dto.setIdUser(user.getId());

        return dto;
    }


}


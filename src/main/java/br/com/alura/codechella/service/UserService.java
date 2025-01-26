package br.com.alura.codechella.service;

import br.com.alura.codechella.model.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto user);

    List<UserDto> getAllUsers();
}

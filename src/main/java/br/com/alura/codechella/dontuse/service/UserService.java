package br.com.alura.codechella.dontuse.service;

import br.com.alura.codechella.dontuse.model.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto user);

    List<UserDto> getAllUsers();
}

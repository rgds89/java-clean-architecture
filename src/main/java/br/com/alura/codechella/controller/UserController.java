package br.com.alura.codechella.controller;


import br.com.alura.codechella.model.dto.UserDto;
import br.com.alura.codechella.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @Transactional
    public ResponseEntity<UserDto> addUser(@RequestBody @Valid UserDto userDto, UriComponentsBuilder uriBuilder) {
        userService.addUser(userDto);
        var uri = uriBuilder.path("users/{id}").buildAndExpand(userDto.social_identification()).toUri();
        return ResponseEntity.created(uri).body(userDto);

    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
}

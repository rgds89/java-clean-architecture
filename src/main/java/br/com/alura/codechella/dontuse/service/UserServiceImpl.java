package br.com.alura.codechella.dontuse.service;


import br.com.alura.codechella.dontuse.model.User;
import br.com.alura.codechella.dontuse.model.dto.UserDto;
import br.com.alura.codechella.dontuse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = buildUser(userDto);
        userRepository.save(user);
        return buildDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> usersDto = new ArrayList<>();
        List<User> users = userRepository.findAll();
        users.forEach(user -> usersDto.add(buildDto(user)));
        return usersDto;
    }

    private User buildUser(UserDto userDto) {
        return new User(userDto);
    }

    private UserDto buildDto(User user) {
        return UserDto.builder()
                .social_identification(user.getSocial_identification())
                .name(user.getName())
                .birth_date(user.getBirth_date())
                .mail(user.getMail())
                .build();
    }

}

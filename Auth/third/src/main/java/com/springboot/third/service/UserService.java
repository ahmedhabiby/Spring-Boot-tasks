package com.springboot.third.service;

import com.springboot.third.DTO.UserDto;
import org.springframework.security.core.userdetails.User;

import java.util.List;


public interface UserService {
    void saveUser(UserDto userDto);
    UserDto getUserByName(String name);
    void deleteUserById(Long id);
    void updateUser(UserDto userDto);
    List<UserDto> getAllUsers();
}

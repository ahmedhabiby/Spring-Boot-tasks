package com.springboot.third.service.serviceImpl;

import com.springboot.third.DTO.UserDto;
import com.springboot.third.mapper.UserMapper;
import com.springboot.third.model.User11;
import com.springboot.third.repo.UserRepo;
import com.springboot.third.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;
    @Autowired
    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    @Override
    public void saveUser(UserDto userDto) {
        if(Objects.nonNull(userDto.getId()))
            throw new IllegalArgumentException("Id must not be null");
          User11 user=userMapper.toEntity(userDto);
          userRepo.save(user);
    }

    @Override
    public UserDto getUserByName(String name) {
        User11 user=userRepo.findByUsername(name);
        return userMapper.toDto(user);
    }

    @Override
    public void deleteUserById(Long id) {
        if(Objects.isNull(userRepo.findById(id).orElse(null)))throw new
                IllegalArgumentException("User11 not found");
        userRepo.deleteById(id);

    }

    @Override
    public void updateUser(UserDto userDto) {
        if(Objects.isNull(userRepo.findById(userDto.getId()).orElse(null)))throw new
                IllegalArgumentException("User11 not found");
        User11 user=userMapper.toEntity(userDto);
        userRepo.save(user);

    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User11> user=userRepo.findAll();
        return user.stream().map(user1 -> userMapper.toDto(user1)).toList();
    }
}

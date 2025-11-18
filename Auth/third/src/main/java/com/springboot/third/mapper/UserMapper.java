package com.springboot.third.mapper;

import com.springboot.third.DTO.UserDto;
import com.springboot.third.model.User11;
import org.mapstruct.Mapper;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User11 toEntity(UserDto userDto);
    UserDto toDto(User11 user);
    List<User11> toListEntity(List<UserDto> userDtos);
    List<UserDto> toListDto(List<User11> users);
}

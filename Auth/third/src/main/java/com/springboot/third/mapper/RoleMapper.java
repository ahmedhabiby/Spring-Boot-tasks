package com.springboot.third.mapper;

import com.springboot.third.DTO.RoleDto;
import com.springboot.third.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toEntity(RoleDto RoleDto);
    RoleDto toDto(Role role);
    List<Role> toListEntity(List<RoleDto> roleDtos);
    List<RoleDto> toListDto(List<Role> roles);
}


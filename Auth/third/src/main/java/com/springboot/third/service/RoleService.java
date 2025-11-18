package com.springboot.third.service;

import com.springboot.third.DTO.RoleDto;

public interface RoleService {
    void saveRole(RoleDto roleDto);
    RoleDto getRoleByName(String code);
    void deleteRoleById(Long id);
    void updateRole(String code);
}

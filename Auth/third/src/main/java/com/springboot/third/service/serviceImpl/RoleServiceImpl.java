package com.springboot.third.service.serviceImpl;

import com.springboot.third.DTO.RoleDto;
import com.springboot.third.mapper.RoleMapper;
import com.springboot.third.model.Role;
import com.springboot.third.repo.RoleRepo;
import com.springboot.third.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;
    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo, RoleMapper roleMapper) {
        this.roleRepo = roleRepo;
        this.roleMapper = roleMapper;
    }
    @Override
    public void saveRole(RoleDto roleDto) {

        if(Objects.isNull(roleDto.getId()))throw
                new IllegalArgumentException("Id must be null");
        Role role = roleMapper.toEntity(roleDto);
        roleRepo.save(role);

    }

    @Override
    public RoleDto getRoleByName(String code) {
        Role role =roleRepo.findByCode(code);
        return roleMapper.toDto(role);
    }

    @Override
    public void deleteRoleById(Long id) {
        if(Objects.isNull(roleRepo.findById(id).orElse(null)))throw new
                IllegalArgumentException("Role not found");
        roleRepo.deleteById(id);

    }

    @Override
    public void updateRole(String name) {
        Role role = roleRepo.findByCode(name);
        if(Objects.isNull(role))throw new IllegalArgumentException("Role not found");
        roleRepo.save(role);
    }
}

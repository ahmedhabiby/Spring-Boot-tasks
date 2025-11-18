package com.springboot.third.service.serviceImpl;

import com.springboot.third.DTO.RoleDto;
import com.springboot.third.DTO.UserDto;
import com.springboot.third.config.TokenHandler;
import com.springboot.third.controllers.Vm.RequestLoginVm;
import com.springboot.third.controllers.Vm.RequestSignUpVm;
import com.springboot.third.controllers.Vm.ResponseLoginVm;
import com.springboot.third.controllers.Vm.ResponseSignUpVm;
import com.springboot.third.mapper.RoleMapper;
import com.springboot.third.mapper.UserMapper;
import com.springboot.third.model.User11;
import com.springboot.third.repo.UserRepo;
import com.springboot.third.service.AuthService;
import com.springboot.third.service.RoleService;
import com.springboot.third.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private  UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private TokenHandler tokenHandler;
    @Override
    public ResponseLoginVm login(RequestLoginVm requestLoginVm) {
       UserDto userDto= userService.getUserByName(requestLoginVm.getUserName());
       if(!userDto.getPassword().equals(requestLoginVm.getPassword())) throw new BadCredentialsException("Wrong password");
       return new ResponseLoginVm(tokenHandler.CreateToken(userDto));
    }

    @Override
    public ResponseSignUpVm signUp(RequestSignUpVm requestSignUpVm) {
       UserDto userDto=new UserDto();
       RoleDto roleDto=roleService.getRoleByName(requestSignUpVm.getCode());
       userDto.setRoles(List.of(roleMapper.toEntity(roleDto)));
       userDto.setUsername(requestSignUpVm.getUserName());
       userDto.setPassword(requestSignUpVm.getPassword());
       userService.saveUser(userDto);
       return new ResponseSignUpVm(tokenHandler.CreateToken(userDto));
    }
}

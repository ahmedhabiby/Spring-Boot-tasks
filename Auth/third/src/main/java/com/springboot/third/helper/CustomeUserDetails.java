package com.springboot.third.helper;

import com.springboot.third.DTO.UserDto;
import com.springboot.third.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomeUserDetails implements UserDetails {
    private UserDto userDto;
    public CustomeUserDetails(UserDto userDto) {
        this.userDto = userDto;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles =userDto.getRoles();
        return roles.stream().map(role->new SimpleGrantedAuthority("Role_"+role.getCode())).toList();
    }

    @Override
    public String getPassword() {
        return "{noop}" +userDto.getPassword();
    }

    @Override
    public String getUsername() {
        return userDto.getUsername();
    }
}

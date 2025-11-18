package com.springboot.third.config;

import com.springboot.third.DTO.UserDto;
import com.springboot.third.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

//@Component
public class AuthProvider implements AuthenticationProvider {
    private final UserService userService;

   // @Autowired
    public AuthProvider(UserService userService) {
        this.userService = userService;
    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        UserDto userDto=userService.getUserByName(username);
        if(!userDto.getPassword().equals(password)) throw new BadCredentialsException("Wrong password");
        List<SimpleGrantedAuthority> simpleGrantedAuthorityList =  userDto.getRoles().stream().
                map(role -> new SimpleGrantedAuthority("Role_"+role.getCode())).collect(Collectors.toList());
        return new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword(), simpleGrantedAuthorityList);

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

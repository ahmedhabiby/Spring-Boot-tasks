package com.springboot.third.service.serviceImpl;

import com.springboot.third.DTO.UserDto;
import com.springboot.third.helper.CustomeUserDetails;
import com.springboot.third.model.User11;
import com.springboot.third.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDto userDto = userService.getUserByName(username);

        if (userDto == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return new CustomeUserDetails(userDto);
    }

}

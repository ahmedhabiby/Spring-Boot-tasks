package com.springboot.third.config;


import com.springboot.third.DTO.UserDto;
import com.springboot.third.helper.JwtToken;
import com.springboot.third.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Component
public class TokenHandler {

    private final JwtToken jwtToken;
    private JwtBuilder jwtBuilder;
    private JwtParser jwtParser;
    private Duration duration;
    @Autowired
    private UserService userService;

    public TokenHandler(JwtToken jwtToken){
        duration=jwtToken.getDuration();
        Key key= Keys.hmacShaKeyFor(jwtToken.getSecret().getBytes());
        jwtBuilder=Jwts.builder().signWith(key);
        jwtParser= Jwts.parser().setSigningKey(key);
        this.jwtToken = jwtToken;
    }


    public String CreateToken(UserDto userDto){
       return jwtBuilder.setSubject(userDto.getUsername())
        .setIssuedAt(new Date())
        .setExpiration(Date.from(Instant.now().plus(duration)))
                .claim("roles",userDto.getRoles().stream().map(role->role.getCode()).toList())
                .compact();

    }

    public UserDto ValidateToken(String token){
        if(!jwtParser.isSigned(token)) return null;
        Claims claims= jwtParser.parseClaimsJws(token).getBody();
        String user=claims.getSubject();
        Date expiration=claims.getExpiration();
        Date issuedAt=claims.getIssuedAt();
        UserDto userDto=userService.getUserByName(user);
        boolean isValidToken= Objects.nonNull(userDto)&&expiration.after(new Date())&&issuedAt.before(expiration);
        if(isValidToken) return userDto;

        return null;
    }
}

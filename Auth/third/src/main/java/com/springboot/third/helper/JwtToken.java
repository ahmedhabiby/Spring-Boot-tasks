package com.springboot.third.helper;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Date;

@Getter
@Setter
@ConfigurationProperties(prefix = "token")
public class JwtToken {
    private String secret;
    private Duration duration;
}

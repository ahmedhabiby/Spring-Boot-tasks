package com.springboot.third.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot.third.model.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class UserDto {


    private Long id;


    private String username;


    private String password;

    private List<Role> roles;


}

package com.springboot.third.controllers.Vm;

import com.springboot.third.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RequestSignUpVm {
    private String userName;
    private String password;
    private String code;
}

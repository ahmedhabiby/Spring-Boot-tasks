package com.springboot.third.controllers;

import com.springboot.third.controllers.Vm.RequestLoginVm;
import com.springboot.third.controllers.Vm.RequestSignUpVm;
import com.springboot.third.controllers.Vm.ResponseLoginVm;
import com.springboot.third.controllers.Vm.ResponseSignUpVm;
import com.springboot.third.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
private AuthService authService;
    @PostMapping("/login")
    private ResponseEntity<ResponseLoginVm> login(@RequestBody RequestLoginVm requestLoginVm){
        return ResponseEntity.ok().body(authService.login(requestLoginVm));
    }
    @PostMapping("/signUp")
    private ResponseEntity<ResponseSignUpVm> signUp(@RequestBody RequestSignUpVm requestSignUpVm){
        return ResponseEntity.ok().body(authService.signUp(requestSignUpVm));
    }
}

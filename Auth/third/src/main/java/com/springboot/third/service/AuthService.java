package com.springboot.third.service;

import com.springboot.third.controllers.Vm.RequestLoginVm;
import com.springboot.third.controllers.Vm.RequestSignUpVm;
import com.springboot.third.controllers.Vm.ResponseLoginVm;
import com.springboot.third.controllers.Vm.ResponseSignUpVm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthService {
    ResponseLoginVm login(RequestLoginVm requestLoginVm);
    ResponseSignUpVm signUp(@RequestBody RequestSignUpVm requestSignUpVm);
}

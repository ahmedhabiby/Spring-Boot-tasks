package com.springboot.third.exceptions;

import com.springboot.third.helper.ExceptionResponse;
import com.springboot.third.service.serviceImpl.MesageBundleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice

public class HandleException {

    private MesageBundleServiceImpl messageBundleServiceImpl;

    @Autowired
    public HandleException(MesageBundleServiceImpl messageBundleServiceImpl){
        this.messageBundleServiceImpl=messageBundleServiceImpl;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(
                messageBundleServiceImpl.getMessage(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionResponse>> handleException(MethodArgumentNotValidException ex){

        List<FieldError> errors= ex.getBindingResult().getFieldErrors();
        List<ExceptionResponse> exceptionResponses=errors.stream().map(fieldError ->
               messageBundleServiceImpl.getMessage(fieldError.getDefaultMessage())).toList();
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(exceptionResponses);
    }
}

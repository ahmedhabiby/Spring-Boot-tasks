package com.springboot.third.controllers;

import com.springboot.third.DTO.EmailDto;
import com.springboot.third.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmailController {
    private EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    @PostMapping("/save/email")
    public ResponseEntity<Void> saveEmail(@RequestBody @Valid EmailDto emailDto){
        emailService.saveEmail(emailDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/update/email")
    public ResponseEntity<Void> updateEmail(@RequestBody @Valid EmailDto emailDto){
        emailService.updateEmail(emailDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/delete/email/{id}")
    public ResponseEntity<Void> deleteEmailById(@PathVariable @Valid Long id){
        emailService.deleteEmailById(id);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/get/email/by/name")
    public ResponseEntity<EmailDto> getEmailByName(@RequestParam @Valid String name){
        return ResponseEntity.status(HttpStatus.OK).body(emailService.getEmailByName(name));
    }
    @GetMapping("/by-content")
    public ResponseEntity<EmailDto> getEmailByContent(@RequestBody @Valid String content) {
        return ResponseEntity.status(HttpStatus.OK).body(emailService.getEmailByContent(content));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmailDto>> getAllEmails() {
        return ResponseEntity.status(HttpStatus.OK).body(emailService.getAllEmails());
    }

    @GetMapping("/by-names")
    public ResponseEntity<List<EmailDto>> getEmailsByName(@RequestBody @Valid List<String> names) {
        return ResponseEntity.status(HttpStatus.OK).body(emailService.getEmailsByName(names));
    }

}

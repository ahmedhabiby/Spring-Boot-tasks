package com.springboot.third.service;

import com.springboot.third.DTO.EmailDto;
import com.springboot.third.model.Email;

import java.util.List;

public interface EmailService {
    void saveEmail(EmailDto emailDto );
    EmailDto getEmailByName(String name);
    void deleteEmailById(Long id);
    void updateEmail(EmailDto emailDto);
    EmailDto getEmailByContent(String content);
    List<EmailDto> getAllEmails();
    List<EmailDto> getEmailsByName(List<String> names);
}

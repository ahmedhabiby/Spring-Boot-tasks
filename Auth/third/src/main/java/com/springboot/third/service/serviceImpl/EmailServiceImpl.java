package com.springboot.third.service.serviceImpl;

import com.springboot.third.DTO.EmailDto;
import com.springboot.third.mapper.EmailMapper;
import com.springboot.third.model.Email;
import com.springboot.third.repo.EmailRepo;
import com.springboot.third.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmailServiceImpl implements EmailService {
    private EmailRepo emailRepo;
    private EmailMapper emailMapper;

    @Autowired
    public EmailServiceImpl(EmailRepo emailRepo, EmailMapper emailMapper) {
        this.emailRepo = emailRepo;
        this.emailMapper = emailMapper;
    }


    @Override
    public void saveEmail(EmailDto emailDto) {
        if(Objects.nonNull(emailDto.getId()))throw
                new IllegalArgumentException("Id must be null");
        Email email = emailMapper.toEntity(emailDto);
        emailRepo.save(email);
    }

    @Override
    public EmailDto getEmailByName(String name) {
        Email email=emailRepo.findByName(name);
        if(email==null) throw new RuntimeException("Email not found");
        return emailMapper.toDto(email);
    }

    @Override
    public void deleteEmailById(Long id) {
        if(!emailRepo.existsById(id)) throw new RuntimeException("Email not found");
        emailRepo.deleteById(id);
    }

    @Override
    public void updateEmail(EmailDto emailDto) {
        if(!emailRepo.existsById(emailDto.getId())) throw new RuntimeException("Email not found");
      Email email=emailMapper.toEntity(emailDto);
      emailRepo.save(email);
    }

    @Override
    public EmailDto getEmailByContent(String content) {
        Email email=emailRepo.findByContent(content);
        return emailMapper.toDto(email);
    }

    @Override
    public List<EmailDto> getAllEmails() {
        List<Email> emails=emailRepo.findAll();
        return emails.stream().map(email -> emailMapper.toDto(email)).toList();
    }

    @Override
    public List<EmailDto> getEmailsByName(List<String> names) {
        List<Email> emails=emailRepo.findByNameIn(names);
        return emails.stream().map(email -> emailMapper.toDto(email)).toList();
    }
}

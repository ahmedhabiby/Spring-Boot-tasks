package com.springboot.third.mapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot.third.DTO.EmailDto;
import com.springboot.third.model.Email;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailMapper {
    Email toEntity(EmailDto emailDto);
    EmailDto toDto(Email email);
    List<EmailDto> toDtoList(List<Email> emails);
    List<Email> toEntityList(List<EmailDto> emailDtos);

}

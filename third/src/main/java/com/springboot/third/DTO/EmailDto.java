package com.springboot.third.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailDto {

    private Long id;
    @NotNull(message = "name.notNull")
    @NotEmpty(message = "name.notEmpty")
    private String name;
    @Email(message = "email.inValid")
    private String content;


}

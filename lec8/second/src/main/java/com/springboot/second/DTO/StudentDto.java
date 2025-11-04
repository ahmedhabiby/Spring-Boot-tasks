package com.springboot.second.DTO;

import com.springboot.second.model.Course;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    @NotNull
    private Long id;
    @Size(min = 10, max = 50)
    @NotNull
    private String name;


    @Email
    @NotNull
    private String email;

    private List<CourseDto> courseDtos;

    public StudentDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

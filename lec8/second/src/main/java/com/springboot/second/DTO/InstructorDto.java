package com.springboot.second.DTO;

import com.springboot.second.model.Course;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDto {

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 5, max = 50)
    private String name;

    @NotNull
    @Email
    private String email;

    private List<CourseDto> courseDtos;
    private List<StudentDto> studentDtos;

    public InstructorDto(Long id, String name, String email, List<CourseDto> courseDtos) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.courseDtos = courseDtos;
    }
    public InstructorDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
    }
}

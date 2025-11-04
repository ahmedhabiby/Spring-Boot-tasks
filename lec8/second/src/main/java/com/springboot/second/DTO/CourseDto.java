package com.springboot.second.DTO;

import com.springboot.second.model.Instructor;
import com.springboot.second.model.Student;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CourseDto {

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 5, max = 50)
    private String title;

    @NotNull
    @Size(min = 10, max = 255)
    private String description;
    private InstructorDto instructorDto;
    private List<StudentDto> studentDtos;

    public CourseDto(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public CourseDto(Long id, String title, String description, InstructorDto instructorDto) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.instructorDto = instructorDto;
    }

    public CourseDto(Long id, String title, String description, List<StudentDto> studentDtos) {
        this.id = id;
        this.title = title;
    }
}

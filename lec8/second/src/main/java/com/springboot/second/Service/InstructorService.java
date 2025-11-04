package com.springboot.second.Service;

import com.springboot.second.DTO.CourseDto;
import com.springboot.second.DTO.InstructorDto;

import java.util.List;

public interface InstructorService {
    InstructorDto saveInstructor(InstructorDto instructorDto);
    List<InstructorDto> getAllInstructors();
    List<CourseDto> getAllCoursesOfInstructor(Long id);
    InstructorDto findInstructorById(Long id);
}

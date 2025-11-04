package com.springboot.second.Service;

import com.springboot.second.DTO.CourseDto;
import com.springboot.second.DTO.InstructorDto;
import com.springboot.second.DTO.StudentDto;
import com.springboot.second.model.Student;

import java.util.List;

public interface StudentService {
    StudentDto  saveStudent(StudentDto studentDto);
    List<StudentDto> getAllStudents();
    void registerStudentInCourse(Long studentId, Long courseId);
    StudentDto findStudentById(Long id);


}

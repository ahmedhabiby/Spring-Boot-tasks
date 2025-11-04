package com.springboot.second.Controller;

import com.springboot.second.DTO.StudentDto;
import com.springboot.second.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public StudentDto saveStudent(@RequestBody StudentDto studentDto){
        return studentService.saveStudent(studentDto);
    }

    @GetMapping("/getAllStudents")
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }
    @PostMapping("/setStudentInCourse/{studentId}/{courseId}")
    public void registerStudentInCourse(@PathVariable @Valid Long studentId, @PathVariable @Valid Long courseId){
        studentService.registerStudentInCourse(studentId,courseId);
    }
    @GetMapping("/api/students/{studentId}")
    public StudentDto getStudentById(@PathVariable @Valid Long studentId){
        return studentService.findStudentById(studentId);
    }
}

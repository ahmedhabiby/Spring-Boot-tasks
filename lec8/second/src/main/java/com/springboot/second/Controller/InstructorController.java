package com.springboot.second.Controller;

import com.springboot.second.DTO.CourseDto;
import com.springboot.second.DTO.InstructorDto;
import com.springboot.second.Service.InstructorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController {
    private InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping("/saveInstructor")
    public InstructorDto saveInstructor(@RequestBody InstructorDto instructorDto){
        return instructorService.saveInstructor(instructorDto);
    }

    @GetMapping("/getAllInstructors")
    public List<InstructorDto> getAllStudents(){
        return instructorService.getAllInstructors();
    }
    @GetMapping("/getAllCoursesOfInstructor/{id}")
    public List<CourseDto> getAllCoursesOfInstructor(@PathVariable @Valid Long id){
        return instructorService.getAllCoursesOfInstructor(id);
    }
    @GetMapping("/api/instructors/{id}")
    public InstructorDto getInstructorById(@PathVariable @Valid Long id){
        return instructorService.findInstructorById(id);
    }
}

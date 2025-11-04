package com.springboot.second.Controller;

import com.springboot.second.DTO.CourseDto;
import com.springboot.second.Service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private  CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/saveCourse")
    public CourseDto saveCourse(@RequestBody CourseDto courseDto){
        return courseService.saveCourse(courseDto);
    }

    @GetMapping("/getAllCourses")
    public List<CourseDto> getAllCourses(){
        return courseService.getAllCourses();
    }

    @PostMapping("/assignInstructorToCourse/{courseId}/{instructorId}")
    public void assignInstructorToCourse(@PathVariable @Valid Long courseId, @PathVariable @Valid Long instructorId){
        courseService.assignInstructorToCourse(courseId,instructorId);
    }
    @GetMapping("/api/course/{courseId}")
    public CourseDto getCourse(@PathVariable @Valid Long courseId){
        return courseService.findCourseById(courseId);
    }
}

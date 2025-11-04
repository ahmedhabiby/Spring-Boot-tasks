package com.springboot.second.Service;

import com.springboot.second.DTO.CourseDto;


import java.util.List;

public interface CourseService {

    CourseDto saveCourse(CourseDto courseDto);
    List <CourseDto> getAllCourses();
    void assignInstructorToCourse(Long courseId, Long instructorId);
    CourseDto findCourseById(Long id);

}

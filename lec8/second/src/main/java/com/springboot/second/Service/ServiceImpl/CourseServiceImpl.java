package com.springboot.second.Service.ServiceImpl;

import com.springboot.second.DTO.CourseDto;
import com.springboot.second.DTO.InstructorDto;
import com.springboot.second.DTO.StudentDto;
import com.springboot.second.Repository.CourseRepo;
import com.springboot.second.Repository.InstructorRepo;
import com.springboot.second.Service.CourseService;
import com.springboot.second.model.Course;
import com.springboot.second.model.Instructor;
import com.springboot.second.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepo courseRepo;
    private InstructorRepo instructorRepo;

    @Autowired
    CourseServiceImpl(CourseRepo courseRepo,InstructorRepo instructorRepo){
        this.instructorRepo = instructorRepo;
        this.courseRepo = courseRepo;
    }
    @Override
    public CourseDto saveCourse(CourseDto courseDto) {
        Course course = new Course(courseDto.getTitle(),courseDto.getDescription());
        courseRepo.save(course);
        courseDto.setId(course.getId());
        return courseDto;
    }

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepo.findAll();
        List<CourseDto> courseDtos= courses.stream().map(course ->
                new CourseDto(course.getId(),course.getTitle(),course.getDescription())).collect(java.util.stream.Collectors.toList());
        return courseDtos;
    }

    @Override
    public void assignInstructorToCourse(Long courseId, Long instructorId) {
        Instructor instructor = instructorRepo.findById(instructorId).get();
        Course course = courseRepo.findById(courseId).get();
        course.setInstructor(instructor);
        courseRepo.save(course);
    }

    @Override
    public CourseDto findCourseById(Long id) {
        Course course=courseRepo.findById(id).orElseThrow();
        List<Student> students= course.getStudents();
        List<StudentDto> studentDtos=students.stream().map(student ->new StudentDto(
                student.getId(),student.getName(),student.getEmail()
        )).toList();
        Instructor instructor=course.getInstructor();
        InstructorDto instructorDto=new InstructorDto(instructor.getId(),instructor.getName(),instructor.getEmail());
        return new CourseDto(course.getId(),course.getTitle(),course.getDescription(),instructorDto,studentDtos);
    }
}

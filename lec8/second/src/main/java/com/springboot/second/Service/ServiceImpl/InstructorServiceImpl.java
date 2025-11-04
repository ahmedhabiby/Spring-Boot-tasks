package com.springboot.second.Service.ServiceImpl;

import com.springboot.second.DTO.CourseDto;
import com.springboot.second.DTO.InstructorDto;
import com.springboot.second.DTO.StudentDto;
import com.springboot.second.Repository.InstructorRepo;
import com.springboot.second.Service.InstructorService;
import com.springboot.second.model.Course;
import com.springboot.second.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstructorServiceImpl implements InstructorService {
    private InstructorRepo instructorRepo;

    @Autowired
    public InstructorServiceImpl(InstructorRepo instructorRepo) {
        this.instructorRepo = instructorRepo;
    }
    @Override
    public InstructorDto saveInstructor(InstructorDto instructorDto) {
        Instructor instructor=new Instructor(instructorDto.getName(),instructorDto.getEmail());
        instructorRepo.save(instructor);
        instructorDto.setId(instructor.getId());
        return instructorDto;
    }

    @Override
    public List<InstructorDto> getAllInstructors() {
        List<Instructor> instructors = instructorRepo.findAll();
        List<InstructorDto> instructorDtos= instructors.stream().map(instructor ->
                new InstructorDto(instructor.getId(),instructor.getName(),instructor.getEmail())).collect(Collectors.toList());
        return instructorDtos;
    }

    @Override
    public List<CourseDto> getAllCoursesOfInstructor(Long id) {
        List<Course> courses = instructorRepo.findAllByInstructorId(id);
        List<CourseDto> courseDtos= courses.stream().map(course ->
                new CourseDto(course.getId(),course.getTitle(),course.getDescription())).collect(Collectors.toList());
        return courseDtos;
    }

    @Override
    public InstructorDto findInstructorById(Long id) {
        Instructor instructor=instructorRepo.findById(id).orElseThrow();
      List<StudentDto> studentDtos=instructor.getCourses().stream()
              .flatMap(course -> course.getStudents().stream())
              .map(student -> new StudentDto(student.getId(),student.getName(),student.getEmail())).collect(Collectors.toList());

        List<CourseDto> courseDtos=instructor.getCourses().stream().map(course -> new CourseDto(
                course.getId(),course.getTitle(),course.getDescription(), studentDtos
        )).toList();
        InstructorDto instructorDto=new InstructorDto(
                instructor.getId(),instructor.getName(),instructor.getEmail(),courseDtos,studentDtos
        );
        return instructorDto;
    }
}

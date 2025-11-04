package com.springboot.second.Service.ServiceImpl;

import com.springboot.second.DTO.CourseDto;
import com.springboot.second.DTO.InstructorDto;
import com.springboot.second.DTO.StudentDto;
import com.springboot.second.Repository.CourseRepo;
import com.springboot.second.Repository.StudentRepo;
import com.springboot.second.Service.StudentService;
import com.springboot.second.model.Course;
import com.springboot.second.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private  StudentRepo studentRepo;
    private CourseRepo courseRepo;
    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo,CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        Student student = new Student(studentDto.getName(),studentDto.getEmail());
        studentRepo.save(student);
        studentDto.setId(student.getId()); // or create constructor new to return id
        //StudentDto student1=new StudentDto(student.getId(),student.getName(),student.getEmail());
        return studentDto;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        List<StudentDto> studentDtos= students.stream().map(student ->
                new StudentDto(student.getId(),student.getName(),student.getEmail())).collect(Collectors.toList());
        return studentDtos;
    }

    @Override
    public void registerStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepo.findById(studentId).get();
        Course course= courseRepo.findById(courseId).get();
        course.getStudents().add(student);
        courseRepo.save(course);
    }

    @Override
    public StudentDto findStudentById(Long id) {
        Student student = studentRepo.findById(id).orElseThrow();
        List<CourseDto> courseDtos= student.getCourses().stream().map(course ->
                new CourseDto(course.getId(),course.getTitle(),course.getDescription(),new InstructorDto(course.getInstructor().getId()
                ,course.getInstructor().getName(),course.getInstructor().getEmail()))).collect(Collectors.toList());
        return new StudentDto(student.getId(),student.getName(),student.getEmail(),courseDtos);
    }

}

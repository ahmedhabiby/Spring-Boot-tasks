package com.springboot.second.Repository;

import com.springboot.second.model.Course;
import com.springboot.second.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course, Long> {
    Optional<Course> findById(Long id);

}

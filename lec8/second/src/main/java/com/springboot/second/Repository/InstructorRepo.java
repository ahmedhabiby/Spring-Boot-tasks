package com.springboot.second.Repository;

import com.springboot.second.model.Course;
import com.springboot.second.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InstructorRepo extends JpaRepository<Instructor, Long> {

    @Query("SELECT c FROM Course c WHERE c.instructor.id=:id")
    List<Course> findAllByInstructorId(Long id);
    Optional<Instructor> findById(Long id);
}

package com.springboot.second.Repository;

import com.springboot.second.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Long> {
    @Override
    Optional<Student> findById(Long id);
}

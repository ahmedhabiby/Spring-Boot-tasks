package com.springboot.first.Repo;

import com.springboot.first.model.Employee2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee2, Long> {
    @Query("SELECT e FROM Employee2 e WHERE e.name LIKE CONCAT(:name, '%')")
    List<Employee2> findByNameStartingWith(@Param("name") String name);
}

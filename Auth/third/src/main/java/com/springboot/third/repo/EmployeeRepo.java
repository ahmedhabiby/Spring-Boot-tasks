package com.springboot.third.repo;

import com.springboot.third.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    @Query("select e from Employee e where e.name in :names")
    List<Employee> findAllByNames(List<String> names);
}

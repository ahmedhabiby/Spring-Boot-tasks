package com.springboot.third.repo;

import com.springboot.third.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepo extends JpaRepository<Email, Long> {
    Email findByName(String name);
    @Query("select e from Email e where e.content = :content")
    Email findByContent(String content);
    List<Email> findByNameIn(List<String> names);

}

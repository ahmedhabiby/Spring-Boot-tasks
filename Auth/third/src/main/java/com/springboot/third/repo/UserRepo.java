package com.springboot.third.repo;

import com.springboot.third.model.User11;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User11, Long> {
    User11 findByUsername(String username);
}

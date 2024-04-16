package com.example.postcreating.repository;

import com.example.postcreating.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    boolean existsById(Long id);

    boolean existsByEmail(String email);
}

package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByCode(String code);
<<<<<<< HEAD
}
=======
}
>>>>>>> 9c6331db6efbf2b8197414cfe5cd8c91495d5e3c

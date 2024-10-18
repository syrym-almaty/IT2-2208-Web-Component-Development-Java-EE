package com.example.demo.repository;

import com.example.demo.entity.Grade;
import com.example.demo.entity.GradeId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GradeRepository extends JpaRepository<Grade, GradeId> {
    List<Grade> findByStudentId(UUID studentId);
}

package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
<<<<<<< HEAD
import lombok.Data;
=======
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
>>>>>>> 9c6331db6efbf2b8197414cfe5cd8c91495d5e3c

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Course name is required")
    private String name;

    @NotBlank(message = "Course code is required")
    @Column(unique = true)
    private String code;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();
<<<<<<< HEAD
=======

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
>>>>>>> 9c6331db6efbf2b8197414cfe5cd8c91495d5e3c
}

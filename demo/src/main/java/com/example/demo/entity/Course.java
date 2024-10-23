package com.example.demo.entity;

import com.example.demo.entity.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.internal.icu.text.UnicodeSet;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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

    public UnicodeSet getStudents() {
        return null;
    }
}

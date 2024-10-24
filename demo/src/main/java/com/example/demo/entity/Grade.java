package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "grades")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
<<<<<<< HEAD
    @EmbeddedId
=======
    @Id
>>>>>>> 9c6331db6efbf2b8197414cfe5cd8c91495d5e3c
    private GradeId id = new GradeId();

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    private Course course;

    @NotNull
    private Double score;
<<<<<<< HEAD
=======

    public void setId(GradeId id) {
        this.id = id;
    }

    public GradeId getId() {
        return id;
    }
>>>>>>> 9c6331db6efbf2b8197414cfe5cd8c91495d5e3c
}

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class GradeId implements Serializable {
    private Long studentId;
    private Long courseId;
}
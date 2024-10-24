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
    @Id
    private GradeId id = new GradeId();

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    private Course course;

    @NotNull
    private Double score;

    public void setId(GradeId id) {
        this.id = id;
    }

    public GradeId getId() {
        return id;
    }
}

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class GradeId implements Serializable {
    private Long studentId;
    private Long courseId;
}
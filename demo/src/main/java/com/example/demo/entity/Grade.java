package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "grades")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
	@EmbeddedId
	private GradeId id = new GradeId();

	@ManyToOne
	@MapsId("studentId")
	private Student student;

	@ManyToOne
	@MapsId("courseId")
	private Course course;

	@NotNull
	private Double score;
}
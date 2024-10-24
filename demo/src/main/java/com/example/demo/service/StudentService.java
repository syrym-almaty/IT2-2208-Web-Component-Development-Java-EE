package com.example.demo.service;

import com.example.demo.entity.Grade;
import com.example.demo.entity.Student;
<<<<<<< HEAD
import com.example.demo.exception.ResourceNotFoundException;
=======
>>>>>>> 9c6331db6efbf2b8197414cfe5cd8c91495d5e3c
import com.example.demo.repository.GradeRepository;
import com.example.demo.repository.StudentRepository;
import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GradeRepository gradeRepository;

<<<<<<< HEAD

=======
>>>>>>> 9c6331db6efbf2b8197414cfe5cd8c91495d5e3c
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(UUID id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudent(UUID id) {
        studentRepository.deleteById(id);
    }

<<<<<<< HEAD

=======
>>>>>>> 9c6331db6efbf2b8197414cfe5cd8c91495d5e3c
    public Double calculateGPA(UUID studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + studentId));

        List<Grade> grades = gradeRepository.findByStudent(student);

        if(grades.isEmpty()){
            return 0.0;
        }

        double totalScore = grades.stream()
                .mapToDouble(Grade::getScore)
                .sum();

        double gpa = totalScore / grades.size();

        student.setGpa(gpa);
<<<<<<< HEAD
        studentRepository.save(student);
=======
        studentRepository.save(student)
>>>>>>> 9c6331db6efbf2b8197414cfe5cd8c91495d5e3c

        return gpa;
    }


<<<<<<< HEAD

    public Student updateStudent(UUID id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setEmail(updatedStudent.getEmail());
                    // Add other fields as necessary
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
    }
=======
>>>>>>> 9c6331db6efbf2b8197414cfe5cd8c91495d5e3c
}

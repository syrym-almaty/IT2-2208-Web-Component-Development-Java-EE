package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

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
}

@Autowired
private StudentRepository studentRepository;

@Autowired
private GradeRepository gradeRepository;

public List<Student> getAllStudents() {
    return studentRepository.findAll();
}
@@ -30,6 +33,30 @@ public Student getStudentById(UUID id) {
    public void deleteStudent(UUID id) {
        studentRepository.deleteById(id);
    }

    public Double calculateGPA(UUID studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + studentId))

        List<Grade> grades = gradeRepository.findByStudent(student)

        if(grades.isEmpty()){
            return 0.0;
        }

        double totalScore = grades.stream()
                .mapToDouble(Grade::getScore)
                .sum();

        double gpa = totalScore / grades.size();

        student.setGpa(gpa);
        studentRepository.save(student)

        return gpa;
    }


    public Student updateStudent(UUID id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
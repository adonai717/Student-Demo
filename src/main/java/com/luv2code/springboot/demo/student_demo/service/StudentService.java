package com.luv2code.springboot.demo.student_demo.service;

import com.luv2code.springboot.demo.student_demo.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student createStudent(Student student);
    Optional<Student> getStudentById(Long id);

    List<Student> getAllStudents();

    Student updateStudent(Student student);

    void deleteStudentId(Long student);

    List<Student> getStudentsByName(String name);
}

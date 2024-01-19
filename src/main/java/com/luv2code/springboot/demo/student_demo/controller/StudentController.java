package com.luv2code.springboot.demo.student_demo.controller;


import com.luv2code.springboot.demo.student_demo.model.Student;
import com.luv2code.springboot.demo.student_demo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/createNewStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        log.info("creating a new Student");
        Student newStudent =  studentService.createStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable Long id) {
        log.info("getting a Student by id");
        Optional<Student> student =  studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/allStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        log.info("Getting all Students");
        List<Student> student =  studentService.getAllStudents();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student updatedStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        log.info("Deleting a Student by id");
        studentService.deleteStudentId(id);
    }

    @GetMapping("/getByName/{name}")
    public List<Student> getStudentsByName(@PathVariable String name) {
        log.info("Getting students by name");

        return studentService.getStudentsByName(name);
    }


}

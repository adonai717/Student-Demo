package com.luv2code.springboot.demo.student_demo.service;

import com.luv2code.springboot.demo.student_demo.model.Student;
import com.luv2code.springboot.demo.student_demo.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudentById(Long id){
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student){

        Student existingStudent = studentRepository.findById(student.getId())
                .orElseThrow(() -> new IllegalArgumentException("Student not found with this id: " + student.getId()));

        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());

        return studentRepository.save(existingStudent);

    }

    @Override
    public void deleteStudentId(Long id){
        studentRepository.deleteById(id);
    }


    @Override
    public List<Student> getStudentsByName(String name) {

        List<Student> allStudents = studentRepository.findByName(name);

        for (Student s:allStudents) {
            s.setName(s.getName() + " temeharayna eyu");
        }

        return allStudents;
    }
}

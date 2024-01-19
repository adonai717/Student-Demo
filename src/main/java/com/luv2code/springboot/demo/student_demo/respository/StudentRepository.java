package com.luv2code.springboot.demo.student_demo.respository;

import com.luv2code.springboot.demo.student_demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);

}

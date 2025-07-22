package com.example.demo.Student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student , Long> {

    //SELECT * FROM Student where email =?
    Optional<Student> findStudentByEmail(String email);

}

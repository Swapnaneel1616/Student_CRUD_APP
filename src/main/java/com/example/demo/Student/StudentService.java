package com.example.demo.Student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){

        return  studentRepository.findAll();

    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("EMAIL ALREADY TAKEN");
        }

        studentRepository.save(student);
    }


    public void deleteStudent(Long studentID) {
        boolean b = studentRepository.existsById(studentID);
        if(!b){
            throw new IllegalStateException("STUDENT WITH ID"+studentID+"doesn't exists");
        }
        studentRepository.deleteById(studentID);
    }

    public List<Student> addStudentById(Long studentID) {
        Optional<Student> student = studentRepository.findById(studentID);
        if(student.isPresent()) {
            return List.of(student.get());
        } else {
            throw new IllegalStateException("Student with ID " + studentID + " not found");
        }

    }

    @Transactional
    public void updateStudents(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new IllegalStateException("Student ID NOT FOUND!!!"));
        if(name !=null && name.length()>0 && !Objects.equals(student.getName() , name)){
            student.setName(name);
        }
        if(email != null && email.length()>0 && !Objects.equals(student.getEmail() , email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("EMAIL ALREADY TAKEN PLEASE PROVIDE ANOTHER EMAIL");
            }
                student.setEmail(email);
        }
    }
}

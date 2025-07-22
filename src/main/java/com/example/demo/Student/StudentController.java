package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();

    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentID}")
    public void deleteStudent(@PathVariable("studentID") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @GetMapping(path = "{studentID}")
    public List<Student> getStudentByID(@PathVariable("studentID") Long studentID){
        return studentService.addStudentById(studentID);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudents(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){

        studentService.updateStudents(studentId,name,email);

    }
}

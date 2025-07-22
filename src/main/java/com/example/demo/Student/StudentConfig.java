package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
                    Student Neel = new Student(
                            "neel",
                            23,
                            "neel.in.16"
                    );

                    Student shreya = new Student(
                            "shreya",
                            23,
                            "shreya.in.11"
                    );


                    repository.saveAll(
                            List.of(Neel , shreya));


        };
    }
}

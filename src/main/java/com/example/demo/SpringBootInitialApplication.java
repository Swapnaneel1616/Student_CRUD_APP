package com.example.demo;

import com.example.demo.Student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class SpringBootInitialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootInitialApplication.class, args);
	}



}

package com.example.mywebsite.controller;

import com.example.mywebsite.model.Student;
import com.example.mywebsite.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // இது மிக முக்கியம்: உங்கள் HTML மற்றும் Spring Boot-ஐ இணைக்க உதவும்
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    @PostMapping("/login")
    public String login(@RequestBody Student loginData) {

        Student student = studentRepository.findByEmail(loginData.getEmail());

        if (student != null) {

            if (student.getPassword().equals(loginData.getPassword())) {
                return "success";
            } else {
                return "wrong_password";
            }
        }
        return "user_not_found";
    }


    @PostMapping("/register")
    public Student register(@RequestBody Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


}
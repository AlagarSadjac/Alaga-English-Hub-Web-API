package com.example.mywebsite.controller;

import com.example.mywebsite.model.Student;
import com.example.mywebsite.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "*") // இது மிக முக்கியம்: உங்கள் HTML மற்றும் Spring Boot-ஐ இணைக்க உதவும்
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // லாகின் செய்வதற்கான API
    @PostMapping("/login")
    public String login(@RequestBody Student loginData) {
        // 1. ஈமெயில் மூலம் மாணவரைத் தேடுதல்
        Student student = studentRepository.findByEmail(loginData.getEmail());

        if (student != null) {
            // 2. பாஸ்வேர்ட் சரியாக இருக்கிறதா என்று பார்த்தல்
            if (student.getPassword().equals(loginData.getPassword())) {
                return "success"; // லாகின் வெற்றி
            } else {
                return "wrong_password"; // பாஸ்வேர்ட் தவறு
            }
        }
        return "user_not_found"; // இந்த ஈமெயில் டேட்டாபேஸில் இல்லை
    }

    // புதிய மாணவரைப் பதிவு செய்ய (Sign Up) இது உதவும்
    @PostMapping("/register")
    public Student register(@RequestBody Student newStudent) {
        return studentRepository.save(newStudent);
    }


}
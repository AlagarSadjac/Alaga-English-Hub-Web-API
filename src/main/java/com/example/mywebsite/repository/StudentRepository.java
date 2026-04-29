package com.example.mywebsite.repository;

import com.example.mywebsite.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // லாகின் செய்யும்போது ஈமெயில் மூலம் தேட இந்த மெத்தட் பயன்படும்
    Student findByEmail(String email);
}
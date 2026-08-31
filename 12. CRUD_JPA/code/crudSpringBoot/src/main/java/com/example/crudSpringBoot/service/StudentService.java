package com.example.crudSpringBoot.service;

import com.example.crudSpringBoot.entity.Student;
import com.example.crudSpringBoot.repository.StudentRepository;
import org.hibernate.query.sqm.sql.internal.PluralValuedSimplePathInterpretation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.PublicKey;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Student createStudent(Student studentreq){
        System.out.println("Inside Student serivce");
        Student studentResp= studentRepository.saveStudent(studentreq);
        System.out.println("Exiting Student serivce");
        return studentResp;
    }

}

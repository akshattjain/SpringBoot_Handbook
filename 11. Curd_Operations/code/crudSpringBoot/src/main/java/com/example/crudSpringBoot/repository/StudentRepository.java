package com.example.crudSpringBoot.repository;

import com.example.crudSpringBoot.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    public Student saveStudent(Student studentreq){
        System.out.println("Inside Student Repo");
        return null;
    }
}

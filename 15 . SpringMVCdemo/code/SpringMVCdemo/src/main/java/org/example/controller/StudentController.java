package org.example.controller;

import org.example.Service.StudentService;
import org.example.entity.Student;
import org.example.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student studentReq){
        Student studentResp= studentService.creatStudent(studentReq);

        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id){

        Student studentResp=studentService.getStudent(id);

        if(studentResp==null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResp);
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getAllStudent(){

        List<Student> studentResp=studentService.getAllStudent();

        if(studentResp.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResp);
    }


}

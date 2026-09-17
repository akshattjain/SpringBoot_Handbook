package com.example.crudSpringBoot.service;

import com.example.crudSpringBoot.dto.StudentRequestDTO;
import com.example.crudSpringBoot.dto.StudentResponseDTO;
import com.example.crudSpringBoot.entity.Student;
import com.example.crudSpringBoot.repository.StudentRepository;
import org.hibernate.query.sqm.sql.internal.PluralValuedSimplePathInterpretation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO){
        Student student= mapToEntity(studentRequestDTO);

        Student studentResp = studentRepository.save(student);

        return mapToDTO(studentResp);
    }

    public Student getStudent(Long id){

         Optional<Student> studentResp= studentRepository.findById(id);

         if(studentResp.isPresent()){
             return studentResp.get();
         }

         return null;
    }


    public List<Student> getAllStudent(){

         List<Student> studentList= studentRepository.findAll();

         return studentList;
    }

    public Student updateStudent(Long id , Student studentReq){

        Optional<Student> existingStudent= studentRepository.findById(id);

        if(existingStudent.isEmpty()){
            return null;
        }

        Student studentToSave = existingStudent.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setSubject(studentReq.getSubject());

        return studentRepository.save(studentToSave);
    }

    public Boolean deleteStudent(Long id){
        Boolean isStudent= studentRepository.existsById(id);

        if(!isStudent){
            return false;
        }

        studentRepository.deleteById(id);

        return true;
    }

    private Student mapToEntity(StudentRequestDTO studentRequestDTO){
        Student student =new Student();

        student.setName(studentRequestDTO.getName());
        student.setSubject(studentRequestDTO.getSubject());
        student.setAge(studentRequestDTO.getAge());
        student.setEmail(studentRequestDTO.getEmail());
        student.setRollNo(studentRequestDTO.getRollNo());

        return student;
    }

    private StudentResponseDTO mapToDTO(Student student){
        StudentResponseDTO studentResponseDTO=new StudentResponseDTO();

        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setAge(student.getAge());
        studentResponseDTO.setEmail(student.getEmail());
        studentResponseDTO.setSubject(student.getSubject());
        studentResponseDTO.setRollNo(student.getRollNo());
        studentResponseDTO.setMessage("Student saved successfully");

        return studentResponseDTO;


    }
}

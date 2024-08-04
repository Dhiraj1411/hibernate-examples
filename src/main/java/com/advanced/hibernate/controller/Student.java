package com.advanced.hibernate.controller;

import com.advanced.hibernate.dto.StudentDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class Student {

    private com.advanced.hibernate.service.Student student;

    @Autowired
    public Student(com.advanced.hibernate.service.Student student) {
        this.student = student;
    }

    @PostMapping(path = "/save-student")
    public ResponseEntity<String> saveStudent(@RequestBody @Valid List<StudentDTO> students){

        ResponseEntity<String> response ;
        System.out.println(students.get(0));
        try{
            student.saveStudent(students);
            response = new ResponseEntity<>("Data saved",HttpStatus.OK) ;
        }catch (Exception ex){
            ex.printStackTrace();
            response = new ResponseEntity<>("Error occurred", HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
        return response;
    }

    @GetMapping(path = "/get-all-students")
    public ResponseEntity<List<StudentDTO>> getStudents(){
        ResponseEntity<List<StudentDTO>> response ;
        try{
            List<StudentDTO> studentDTOList = student.getSudents();
            response = new ResponseEntity<>(studentDTOList,HttpStatus.OK) ;
        }catch (Exception ex){
            response = new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
        return response;
    }
}

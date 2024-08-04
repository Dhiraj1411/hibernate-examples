package com.advanced.hibernate.service;

import com.advanced.hibernate.dto.StudentDTO;
import com.advanced.hibernate.entity.StudentEntity;
import com.advanced.hibernate.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentImpl implements Student {

    StudentRepo student;

    @Autowired
    public StudentImpl(StudentRepo student) {
        this.student = student;
    }

    @Override
    public void saveStudent(List<StudentDTO> studentDtos) {
        List<StudentEntity> studentEntityList = new ArrayList<>();

        studentDtos.forEach(item -> {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setFirstName(item.getFirstName());
            studentEntity.setLastName(item.getLastName());
            studentEntity.setEmail(item.getEmail());
            studentEntityList.add(studentEntity);
        });
        student.saveAll(studentEntityList);
    }

    @Override
    public List<StudentDTO> getSudents() {
        List<StudentEntity> studentEntityList = student.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        studentEntityList.forEach(item -> {
            StudentDTO studentDto = new StudentDTO();
            studentDto.setFirstName(item.getFirstName());
            studentDto.setLastName(item.getLastName());
            studentDto.setEmail(item.getEmail());
            studentDTOList.add(studentDto);
        });
        return studentDTOList;
    }
}

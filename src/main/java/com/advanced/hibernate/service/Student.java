package com.advanced.hibernate.service;

import com.advanced.hibernate.dto.StudentDTO;

import java.util.List;

public interface Student {
    void saveStudent(List<StudentDTO> student);
    List<StudentDTO> getSudents();
}

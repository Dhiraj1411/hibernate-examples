package com.advanced.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "image")
@Setter
@Getter
public class ImageEntity {

    @Id
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "file_name")
    private String fileName;
}

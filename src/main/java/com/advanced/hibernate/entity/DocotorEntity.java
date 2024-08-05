package com.advanced.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "DOCTOR")
public class DocotorEntity extends UserEntity{

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "salary")
    private String salary;

    public DocotorEntity(String firstName, String lastName, String email, String speciality, String salary) {
        super(firstName, lastName, email);
        this.speciality = speciality;
        this.salary = salary;
    }
}

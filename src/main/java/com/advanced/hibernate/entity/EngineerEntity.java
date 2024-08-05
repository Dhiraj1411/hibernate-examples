package com.advanced.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ENGINEER")
public class EngineerEntity extends UserEntity{

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    private String salary;

    public EngineerEntity(String firstName, String lastName, String email, String department, String salary) {
        super(firstName, lastName, email);
        this.department = department;
        this.salary = salary;
    }
}

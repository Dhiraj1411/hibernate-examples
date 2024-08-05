package com.advanced.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class PlumberEntity extends EmployeeEntity {

    @Column(name = "company")
    private String companyName;

    public PlumberEntity(String name, boolean fullTime, String salary, String companyName) {
        super(name, fullTime, salary);
        this.companyName = companyName;
    }
}

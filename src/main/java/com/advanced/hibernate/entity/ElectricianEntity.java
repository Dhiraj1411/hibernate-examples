package com.advanced.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ElectricianEntity extends EmployeeEntity {

    @Column(name = "job_type")
    private String jobType;

    public ElectricianEntity(String name, boolean fullTime, String salary, String jobType) {
        super(name, fullTime, salary);
        this.jobType = jobType;
    }
}

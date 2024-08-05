package com.advanced.hibernate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long employeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "FTE")
    private boolean fullTime;

    @Column(name = "salary")
    private String salary;

    public EmployeeEntity(String name, boolean fullTime, String salary) {
        this.name = name;
        this.fullTime = fullTime;
        this.salary = salary;
    }
}

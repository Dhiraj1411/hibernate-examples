package com.advanced.hibernate.entity.mappedSuperClassStrategy;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@MappedSuperclass
public abstract class Shape {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String name;

    public Shape(String name) {
        this.name = name;
    }
}

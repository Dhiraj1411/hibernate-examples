package com.advanced.hibernate.entity.mappedSuperClassStrategy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "circle")
public class CircleEntity extends Shape {

    @Column(name = "radius")
    private Long radius;

    public CircleEntity(String name, Long radius) {
        super(name);
        this.radius = radius;
    }
}

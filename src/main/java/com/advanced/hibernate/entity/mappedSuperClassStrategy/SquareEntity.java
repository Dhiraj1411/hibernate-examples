package com.advanced.hibernate.entity.mappedSuperClassStrategy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "square")
public class SquareEntity extends Shape {

    @Column(name = "perimeter")
    private Long perimeter;

    public SquareEntity(String name, Long perimeter) {
        super(name);
        this.perimeter = perimeter;
    }
}

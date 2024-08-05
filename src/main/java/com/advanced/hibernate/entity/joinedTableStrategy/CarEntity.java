package com.advanced.hibernate.entity.joinedTableStrategy;

import jakarta.persistence.*;

@Entity
public class CarEntity extends VehicleEntity{


    @Column(name = "body_type")
    private String bodyType;

    @Column(name = "seating_capacity")
    private Integer seatingCapacity;

    public CarEntity(Long engineCapacity, String bodyType, Integer seatingCapacity) {
        super(engineCapacity);
        this.bodyType = bodyType;
        this.seatingCapacity = seatingCapacity;
    }
}

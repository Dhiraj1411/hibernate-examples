package com.advanced.hibernate.entity.joinedTableStrategy;

import jakarta.persistence.*;

@Entity
public class MotorcycleEntity extends VehicleEntity{

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private Integer price;

    public MotorcycleEntity(Long engineCapacity, String type, Integer price) {
        super(engineCapacity);
        this.type = type;
        this.price = price;
    }
}

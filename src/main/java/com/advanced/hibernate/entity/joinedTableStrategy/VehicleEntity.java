package com.advanced.hibernate.entity.joinedTableStrategy;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "engine_capacity")
    private Long engineCapacity;

    public VehicleEntity(Long engineCapacity) {
        this.engineCapacity = engineCapacity;
    }
}

package com.advanced.hibernate.repository;

import com.advanced.hibernate.entity.mappedSuperClassStrategy.Shape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShapeRepo extends JpaRepository<Shape, Long> {
}

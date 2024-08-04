package com.advanced.hibernate.repository;

import com.advanced.hibernate.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<ImageEntity, Long> {
}

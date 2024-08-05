package com.advanced.hibernate.repository;

import com.advanced.hibernate.entity.ElectricianEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricianRepo extends JpaRepository<ElectricianEntity, Long> {
}

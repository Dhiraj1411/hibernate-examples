package com.advanced.hibernate.repository;

import com.advanced.hibernate.entity.PlumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlumberRepo extends JpaRepository<PlumberEntity, Long> {
}

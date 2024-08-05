package com.advanced.hibernate.repository;

import com.advanced.hibernate.entity.singleTablStrategy.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
}

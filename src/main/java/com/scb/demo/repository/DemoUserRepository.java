package com.scb.demo.repository;

import com.scb.demo.model.DemoUserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DemoUserRepository extends JpaRepository<DemoUserEntity, Long>{
}

package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.application.entity.Age;

@Repository
public interface AgeRepository extends JpaRepository<Age, Long>{
    
}

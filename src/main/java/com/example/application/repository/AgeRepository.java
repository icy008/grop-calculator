package com.example.application.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.entity.Age;


public interface AgeRepository extends JpaRepository<Age, Integer> {
}
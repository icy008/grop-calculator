package com.example.application.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Getter;

@Entity
public class PlaceholderEntity {
    @Id
    private Long id;  // Define this just to satisfy the entity structure
    @Getter
    private String label;
    @Getter
    private Float value;
    @Getter
    private LocalDateTime timestamp;
    @Getter
    private String sourceTable;

}
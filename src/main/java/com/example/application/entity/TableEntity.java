package com.example.application.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Getter;


@Entity
public class TableEntity {
    @Id

    private Long id;  
    @Getter
    private String label;
    @Getter
    private Float value;
    @Getter
    private LocalDateTime timestamp;
    @Getter
    private String sourceTable;

    public TableEntity() {
    }
}








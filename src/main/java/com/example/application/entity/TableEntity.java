package com.example.application.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class TableEntity {
    @Id
    @Getter
    @Setter
    private Long id;  // Define this just to satisfy the entity structure
    @Getter
    @Setter
    private String label;
    @Getter
    @Setter
    private Float value;
    @Getter
    @Setter
    private LocalDateTime timestamp;
    @Getter
    @Setter
    private String sourceTable;

    public TableEntity() {
    }
       // Constructor
    public TableEntity(Long id, String label, Float value, LocalDateTime timestamp, String sourceTable) {
        this.id = id;
        this.label = label;
        this.value = value;
        this.timestamp = timestamp;
        this.sourceTable = sourceTable;
    }
 


}
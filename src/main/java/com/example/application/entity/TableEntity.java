package com.example.application.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class TableEntity {
    @Id
    // @Getter
    private Long id;  // Define this just to satisfy the entity structure
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

       // Constructor
    // public TableEntity(Long id, String label, Float value, LocalDateTime timestamp, String sourceTable) {
    //     this.id = id;
    //     this.label = label;
    //     this.value = value;
    //     this.timestamp = timestamp;
    //     this.sourceTable = sourceTable;
    // }






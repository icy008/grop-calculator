package com.example.application.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "combined_tables") 
public class TableEntity {
    @Id
    @Getter
    @Setter
    private Long id;  
    @Getter
    @Setter
    private String label;
    @Getter
    @Setter
    private Float value;
    @Getter
    @Setter
    private String units;
    @Getter
    @Setter
    private LocalDateTime timestamp;
    @Getter
    @Setter
    private String sourceTable;

    public TableEntity() {
    }

    public TableEntity(Long id, String label, Float value, String units ,LocalDateTime timestamp, String sourceTable) {
        this.id = id;
        this.label = label;
        this.value = value;
        this.units = units;
        this.timestamp = timestamp;
        this.sourceTable = sourceTable;
    }

}








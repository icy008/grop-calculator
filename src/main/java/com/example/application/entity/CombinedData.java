package com.example.application.entity;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "combined_data") 
public class CombinedData {

    @Id
    private Long id;
    private String label;
    private Float value;
    private LocalDateTime timestamp;
    private String sourceTable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public Float getValue() {
        return value;
    }
    public void setValue(Float value) {
        this.value = value;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public String getSourceTable() {
        return sourceTable;
    }
    public void setSourceTable(String sourceTable) {
        this.sourceTable = sourceTable;
    }

}



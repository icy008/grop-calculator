package com.example.application.entity;

import jakarta.persistence.Id;
import lombok.Getter;

public class AllData {
    @Id
    @Getter
    private int id;
    @Getter
    private String label;
    @Getter
    private Object value; 
    @Getter
    private String timestamp;
    @Getter
    private String sourceTable;


    public AllData(int id, String label, Object value, String timestamp, String sourceTable) {
        this.id = id;
        this.label = label;
        this.value = value;
        this.timestamp = timestamp;
        this.sourceTable = sourceTable;
    }
    

}
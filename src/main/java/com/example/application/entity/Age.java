package com.example.application.entity;

import java.sql.Timestamp;

// import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import jakarta.persistence.Entity;

@Entity
@Table(name = "age")
public class Age {
    @Id
    @Getter
    private Integer id;
    @Getter
    private String label;
    @Getter
    private Double value;
    @Getter
    private Timestamp timestamp;

    // Empty constructor required by JPA
    public Age() {}



}

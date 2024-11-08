package com.example.application.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;


@Entity
public class Age {
    @Id
    @Getter
    private Long id;  

    @Getter
    private String label;

    @Getter
    private Float value;

    @Getter
    private LocalDateTime timestamp;


    // public Age() {
    // }

}

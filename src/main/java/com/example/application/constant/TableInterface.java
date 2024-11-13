package com.example.application.constant;

import java.time.LocalDateTime;


public interface TableInterface {
    Long getId();
    String getLabel();
    Float getValue();
    LocalDateTime getTimestamp();
    String getSourceTable();
}
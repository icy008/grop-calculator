package com.example.application.utils;
import java.time.LocalDateTime;

public interface CombinedDataProjection {
    Long getId();
    String getLabel();
    float getValue();
    LocalDateTime getTimestamp();  // Adjusted to LocalDateTime to match typical timestamp types
    String getSourceTable();
}
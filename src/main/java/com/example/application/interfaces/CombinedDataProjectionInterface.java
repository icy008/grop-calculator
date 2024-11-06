package com.example.application.interfaces;
import java.time.LocalDateTime;

public interface CombinedDataProjectionInterface {
    Long getId();
    String getLabel();
    float getValue();
    LocalDateTime getTimestamp();  // Adjusted to LocalDateTime to match typical timestamp types
    String getSourceTable();
}
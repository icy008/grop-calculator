package com.example.application.utils;



import java.time.LocalDateTime;

import com.vaadin.hilla.Nonnull;



public interface TableInterface {
    @Nonnull
    Long getId();
    @Nonnull
    String getLabel();
    @Nonnull
    Float getValue();
    @Nonnull
    String getUnits();
    LocalDateTime getTimestamp();
    @Nonnull
    String getSourceTable();
}


package com.example.application.components;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Component
public class DataSeeder {

    private final JdbcTemplate jdbcTemplate;

    public DataSeeder(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void seedData() {
        System.out.println("Starting data seeding...");
        try {
            seedAllTables();
            System.out.println("Data seeding completed successfully.");
        } catch (Exception e) {
            System.err.println("Data seeding failed: " + e.getMessage());
        }
    }

    @Transactional
    public void seedAllTables() {
        // Table definitions and data
        seedTableWithSchema("age",
                "CREATE TABLE age (id SERIAL PRIMARY KEY, label VARCHAR(255), value FLOAT, units VARCHAR(255), timestamp TIMESTAMPTZ)",
                List.of(
                        Map.of("label", "80-84", "value", 0.29129, "units", "(years)"),
                        Map.of("label", "85 above", "value", 0.29129, "units", "(years)"),
                        Map.of("label", "≥90", "value", 0.43853, "units", "(years)")
                ));

        seedTableWithSchema("gender",
                "CREATE TABLE gender (id SERIAL PRIMARY KEY, label VARCHAR(255), value FLOAT, units VARCHAR(255), timestamp TIMESTAMPTZ)",
                List.of(
                        Map.of("label", "Male", "value", 0.51578, "units", ""),
                        Map.of("label", "Female", "value", 0.48422, "units", "")
                ));

        seedTableWithSchema("barthel_index",
                "CREATE TABLE barthel_index (id SERIAL PRIMARY KEY, label VARCHAR(255), value FLOAT, units VARCHAR(255), timestamp TIMESTAMPTZ)",
                List.of(
                        Map.of("label", "≥90", "value", 0.0, "units", ""),
                        Map.of("label", "61-90", "value", 0.34902, "units", ""),
                        Map.of("label", "≤60", "value", 0.78954, "units", "")
                ));

        seedTableWithSchema("history_hf",
                "CREATE TABLE history_hf (id SERIAL PRIMARY KEY, label VARCHAR(255), value FLOAT, units VARCHAR(255), timestamp TIMESTAMPTZ)",
                List.of(
                        Map.of("label", "No", "value", 0.0, "units", ""),
                        Map.of("label", "Yes", "value", 0.35664, "units", "")
                ));

        seedTableWithSchema("sbp_admission",
                "CREATE TABLE sbp_admission (id SERIAL PRIMARY KEY, label VARCHAR(255), value FLOAT, units VARCHAR(255), timestamp TIMESTAMPTZ)",
                List.of(
                        Map.of("label", "≥100", "value", 0.0, "units", "(mmHg)"),
                        Map.of("label", "<100", "value", 0.31585, "units", "(mmHg)")
                ));

        seedTableWithSchema("hemoglobin",
                "CREATE TABLE hemoglobin (id SERIAL PRIMARY KEY, label VARCHAR(255), value FLOAT, units VARCHAR(255), timestamp TIMESTAMPTZ)",
                List.of(
                        Map.of("label", "≥12", "value", 0.0, "units", "(g/dL)"),
                        Map.of("label", "10-11.9", "value", 0.23813, "units", "(g/dL)"),
                        Map.of("label", "<10", "value", 0.40091, "units", "(g/dL)")
                ));

        seedTableWithSchema("albumin",
                "CREATE TABLE albumin (id SERIAL PRIMARY KEY, label VARCHAR(255), value FLOAT, units VARCHAR(255), timestamp TIMESTAMPTZ)",
                List.of(
                        Map.of("label", "≥3", "value", 0.0, "units", "(g/dL)"),
                        Map.of("label", "<3", "value", 0.37812, "units", "(g/dL)")
                ));

        seedTableWithSchema("bun",
                "CREATE TABLE bun (id SERIAL PRIMARY KEY, label VARCHAR(255), value FLOAT, units VARCHAR(255), timestamp TIMESTAMPTZ)",
                List.of(
                        Map.of("label", "<25", "value", 0.0, "units", "(mg/dL)"),
                        Map.of("label", "≥25", "value", 0.21341, "units", "(mg/dL)")
                ));

        seedTableWithSchema("bnp",
                "CREATE TABLE bnp (id SERIAL PRIMARY KEY, label VARCHAR(255), value FLOAT, units VARCHAR(255), timestamp TIMESTAMPTZ)",
                List.of(
                        Map.of("label", "<300", "value", 0.0, "units", "(pg/dL)"),
                        Map.of("label", "≥300", "value", 0.29743, "units", "(pg/dL)")
                ));

        seedTableWithSchema("sodium",
                "CREATE TABLE sodium (id SERIAL PRIMARY KEY, label VARCHAR(255), value FLOAT, units VARCHAR(255), timestamp TIMESTAMPTZ)",
                List.of(
                        Map.of("label", "≥130", "value", 0.0, "units", "(mEq/L)"),
                        Map.of("label", "<130", "value", 0.60705, "units", "(mEq/L)")
                ));

        seedTableWithSchema("ace_arm_use",
                "CREATE TABLE ace_arm_use (id SERIAL PRIMARY KEY, label VARCHAR(255), value FLOAT, units VARCHAR(255), timestamp TIMESTAMPTZ)",
                List.of(
                        Map.of("label", "No", "value", 0.20517, "units", ""),
                        Map.of("label", "Yes", "value", 0.79483, "units", "")
                ));
    }

    private void seedTableWithSchema(String tableName, String createTableSql, List<Map<String, Object>> data) {
        // Create table if not exists
        try {
            jdbcTemplate.execute("SELECT 1 FROM " + tableName + " LIMIT 1");
        } catch (Exception e) {
            System.out.println("Table " + tableName + " does not exist. Creating...");
            jdbcTemplate.execute(createTableSql);
        }

        // Seed data
        System.out.println("Seeding table: " + tableName);
        for (Map<String, Object> record : data) {
            String label = (String) record.get("label");
            Double value = (Double) record.get("value");
            String units = (String) record.get("units");

            // Check if record exists
            String query = "SELECT COUNT(*) FROM " + tableName + " WHERE label = ?";
            Integer count = jdbcTemplate.queryForObject(query, Integer.class, label);

            if (count != null && count == 0) {
                // Insert missing record
                String insertSql = "INSERT INTO " + tableName + " (label, value, units, timestamp) VALUES (?, ?, ?, NOW())";
                jdbcTemplate.update(insertSql, label, value, units);
                System.out.println("Inserted missing record into " + tableName + ": " + record);
            }
        }
    }
}




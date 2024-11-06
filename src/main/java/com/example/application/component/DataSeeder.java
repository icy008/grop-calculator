package com.example.application.component;



import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) {
        seedTableIfEmpty("lnOutAge", "age_label");
        seedTableIfEmpty("lnOutSex", "sex_label");
        seedTableIfEmpty("lnOutBarthelIndex", "barthel_label");
        // Call for each table in similar fashion...
    }

    private void seedTableIfEmpty(String tableName, String label) {
        Long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM " + tableName, Long.class);
        
        if (count == 0) {
            System.out.println("No records found in " + tableName + ", seeding data...");

            String insertQuery = "INSERT INTO " + tableName + " (id, label, value, timestamp) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(insertQuery, 1, label, 0.0, Timestamp.from(Instant.now()));
            
            System.out.println("Seeded data in " + tableName);
        } else {
            System.out.println(tableName + " already contains data.");
        }
    }
}
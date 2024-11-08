// package com.example.application.component;

// import java.util.*;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;

// import com.example.application.entity.TableEntity;
// import com.example.application.repository.TableRepository;

// import jakarta.transaction.Transactional;

// import java.time.LocalDateTime;
// @Component
// public class DataSeeder {

//     @Autowired
//     private TableRepository tableRepository;

//     @Transactional
//     public void seedDatabase() {
//         List<TableEntity> data = tableRepository.getCombinedDatas();

//         if (data.isEmpty()) {
//             System.out.println("No data found. Seeding database...");

//             // Define default values for missing data
//             List<TableEntity> defaultData = Arrays.asList(
//                 new TableEntity(1L, "Age", 30.0f, LocalDateTime.now(), "age"),
//                 new TableEntity(2L, "Age", 30.0f, LocalDateTime.now(), "age"),
//                 new TableEntity(3L, "Age", 30.0f, LocalDateTime.now(), "age"),

//                 new TableEntity(2L, "Gender", 1.0f, LocalDateTime.now(), "gender"),
//                 new TableEntity(3L, "Barthel Index", 85.0f, LocalDateTime.now(), "barthel_index"),
//                 new TableEntity(4L, "History HF", 0.0f, LocalDateTime.now(), "history_hf"),
//                 new TableEntity(5L, "SBP Admission", 120.0f, LocalDateTime.now(), "sbp_admission"),
//                 new TableEntity(6L, "Hemoglobin", 13.5f, LocalDateTime.now(), "hemoglobin"),
//                 new TableEntity(7L, "Albumin", 4.0f, LocalDateTime.now(), "albumin"),
//                 new TableEntity(8L, "BUN", 18.0f, LocalDateTime.now(), "bun"),
//                 new TableEntity(9L, "BNP", 100.0f, LocalDateTime.now(), "bnp"),
//                 new TableEntity(10L, "Sodium", 140.0f, LocalDateTime.now(), "sodium"),
//                 new TableEntity(11L, "ACE/ARB Use", 1.0f, LocalDateTime.now(), "ace_arm_use")
//             );

//             tableRepository.saveAll(defaultData);
//             System.out.println("Database seeded successfully.");
//         } else {
//             System.out.println("Data already exists. No seeding needed.");
//         }
//     }
// }
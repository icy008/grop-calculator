package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.application.entity.TableEntity;
import com.example.application.utils.TableInterface;
import java.util.List;



@Repository
public interface TableRepository  extends JpaRepository<TableEntity, Long> {
    
        String query = """
		  SELECT id, label, value, units , timestamp, source_table  FROM ( 
                    SELECT id, label, value,  units , timestamp, 'Age' AS source_table FROM age
                    UNION ALL  
                    SELECT id, label, value,  units , timestamp, 'Gender' AS source_table FROM gender  
                    UNION ALL  
                    SELECT id, label, value,  units , timestamp, 'Barthel Index' AS source_table FROM barthel_index  
                    UNION ALL  
                    SELECT id, label, value,  units , timestamp, 'History-hf' AS source_table FROM history_hf  
                    UNION ALL  
                    SELECT id, label, value,  units , timestamp, 'SBP-Admission' AS source_table FROM sbp_admission  
                    UNION ALL  
                    SELECT id, label, value,  units , timestamp, 'Hemoglobin' AS source_table FROM hemoglobin  
                    UNION ALL  
                    SELECT id, label, value,  units , timestamp, 'Albumin' AS source_table FROM albumin  
                    UNION ALL  
                    SELECT id, label, value,  units , timestamp, 'BUN' AS source_table FROM bun  
                    UNION ALL  
                    SELECT id, label, value,  units , timestamp, 'BNP' AS source_table FROM bnp  
                    UNION ALL  
                    SELECT id, label, value,  units , timestamp, 'Sodium' AS source_table FROM sodium  
                    UNION ALL  
                    SELECT id, label, value,  units , timestamp, 'Ace-Arm-Use' AS source_table FROM ace_arm_use 
                ) AS combined_tables;
                """;
    
    @Query(value = query, nativeQuery = true)    
    List<TableInterface> getCombinedDatas();
}


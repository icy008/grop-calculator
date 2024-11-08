package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.application.entity.TableEntity;
// import com.example.application.utils.CombinedDataProjection;
import java.util.List;



@Repository
public interface TableRepository  extends JpaRepository<TableEntity, Long> {
    
        String query = """
            SELECT id, label, value, timestamp, source_table FROM ( 
                    SELECT id, label, value, timestamp, 'age' AS source_table FROM age  
                    UNION ALL  
                    SELECT id, label, value, timestamp, 'gender' AS source_table FROM gender  
                    UNION ALL  
                    SELECT id, label, value, timestamp, 'barthel_index' AS source_table FROM barthel_index  
                    UNION ALL  
                    SELECT id, label, value, timestamp, 'history_hf' AS source_table FROM history_hf  
                    UNION ALL  
                    SELECT id, label, value, timestamp, 'sbp_admission' AS source_table FROM sbp_admission  
                    UNION ALL  
                    SELECT id, label, value, timestamp, 'hemoglobin' AS source_table FROM hemoglobin  
                    UNION ALL  
                    SELECT id, label, value, timestamp, 'albumin' AS source_table FROM albumin  
                    UNION ALL  
                    SELECT id, label, value, timestamp, 'bun' AS source_table FROM bun  
                    UNION ALL  
                    SELECT id, label, value, timestamp, 'bnp' AS source_table FROM bnp  
                    UNION ALL  
                    SELECT id, label, value, timestamp, 'sodium' AS source_table FROM sodium  
                    UNION ALL  
                    SELECT id, label, value, timestamp, 'ace_arm_use' AS source_table FROM ace_arm_use 
                ) AS combined_data;
                """;
    
    @Query(value = query, nativeQuery = true)    
    List<TableEntity> getCombinedDatas();

}
package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.application.entity.PlaceholderEntity;
import com.example.application.utils.CombinedDataProjection;


import java.util.List;

@Repository
public interface SomeEntityRepository  extends JpaRepository<PlaceholderEntity, Long> {
    
        String query = """
            SELECT id, label, value, timestamp, source_table FROM ( 
                SELECT id, label, value, timestamp, 'lnOutAge' AS source_table FROM lnOutAge  
                UNION ALL  
                SELECT id, label, value, timestamp, 'lnOutSex' AS source_table FROM lnOutSex  
                UNION ALL  
                SELECT id, label, value, timestamp, 'lnOutBarthelIndex' AS source_table FROM lnOutBarthelIndex  
                UNION ALL  
                SELECT id, label, value, timestamp, 'lnOutHistoryHf' AS source_table FROM lnOutHistoryHf  
                UNION ALL  
                SELECT id, label, value, timestamp, 'lnOutSbp' AS source_table FROM lnOutSbp  
                UNION ALL  
                SELECT id, label, value, timestamp, 'lnOutHemoglobin' AS source_table FROM lnOutHemoglobin  
                UNION ALL  
                SELECT id, label, value, timestamp, 'lnOutAlbumin' AS source_table FROM lnOutAlbumin  
                UNION ALL  
                SELECT id, label, value, timestamp, 'lnOutBun' AS source_table FROM lnOutBun  
                UNION ALL  
                SELECT id, label, value, timestamp, 'lnOutBnp' AS source_table FROM lnOutBnp  
                UNION ALL  
                SELECT id, label, value, timestamp, 'lnOutSodium' AS source_table FROM lnOutSodium  
                UNION ALL  
                SELECT id, label, value, timestamp, 'lnOutAceArbUse' AS source_table FROM lnOutAceArbUse 
            ) AS combined_data;
            """;
    
    @Query(value = query, nativeQuery = true)    
    List<CombinedDataProjection> getCombinedDatas();

}
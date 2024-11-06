package com.example.application.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import com.example.application.entity.AllData;
import com.vaadin.hilla.BrowserCallable;


// @BrowserCallable
@Service
public class QueryData {
        @Autowired
    private JdbcTemplate jdbcTemplate;

        public List<AllData> getAllData() {
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

        return jdbcTemplate.query(query, new QueryDataRowMapper());
    }
                private class QueryDataRowMapper implements RowMapper<AllData> {
                @Override
                public AllData mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new AllData(
                        rs.getInt("id"),
                        rs.getString("label"),
                        rs.getFloat("value"),  // Adjust the type if needed
                        rs.getString("timestamp"),
                        rs.getString("source_table")
                    );
                }
            }
    
}

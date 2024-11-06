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

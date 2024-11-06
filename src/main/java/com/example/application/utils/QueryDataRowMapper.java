package com.example.application.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.application.entity.AllData;
import org.springframework.jdbc.core.RowMapper;


public class QueryDataRowMapper implements RowMapper<AllData> {
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

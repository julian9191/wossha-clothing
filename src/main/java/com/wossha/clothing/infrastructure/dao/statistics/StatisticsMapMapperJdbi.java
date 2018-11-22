package com.wossha.clothing.infrastructure.dao.statistics;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import com.wossha.clothing.dto.StatisticsMapDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticsMapMapperJdbi implements ResultSetMapper<StatisticsMapDTO> {

    @Override
    public StatisticsMapDTO map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        
		return new StatisticsMapDTO(
                r.getString("KEY"),
                r.getString("VALUE")
        );
        
    }
}
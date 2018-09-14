package com.wossha.clothing.infrastructure.dao.color;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import com.wossha.clothing.dto.ColorDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ColorMapperJdbi implements ResultSetMapper<ColorDTO> {
	
    @Override
    public ColorDTO map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        
		return new ColorDTO(
                r.getInt("ID"),
                r.getString("HEXA"),
                r.getInt("BASE_COLOR")
        );
        
    }
}
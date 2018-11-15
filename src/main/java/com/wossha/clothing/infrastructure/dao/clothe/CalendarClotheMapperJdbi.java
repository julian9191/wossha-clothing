package com.wossha.clothing.infrastructure.dao.clothe;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import com.wossha.clothing.dto.CalendarClotheDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CalendarClotheMapperJdbi implements ResultSetMapper<CalendarClotheDTO> {
	
    @Override
    public CalendarClotheDTO map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        
		return new CalendarClotheDTO(
				r.getString("NAME"), 
				r.getTimestamp("DAY"), 
				r.getString("COLOR_CODE"), 
				true, 
				r.getString("PICTURE"), 
				r.getString("DESCRIPTION")
			);
        
    }
}
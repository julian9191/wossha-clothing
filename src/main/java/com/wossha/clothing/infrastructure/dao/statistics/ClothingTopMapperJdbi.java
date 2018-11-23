package com.wossha.clothing.infrastructure.dao.statistics;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import com.wossha.clothing.dto.ClothigTopDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClothingTopMapperJdbi implements ResultSetMapper<ClothigTopDTO> {

    @Override
    public ClothigTopDTO map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        
		return new ClothigTopDTO(
				r.getInt("ID"),
                r.getString("UUID"),
                r.getString("NAME"),
                r.getString("TYPE"),
                r.getString("PICTURE"),
                r.getInt("TOTAL")
        );
        
    }
}
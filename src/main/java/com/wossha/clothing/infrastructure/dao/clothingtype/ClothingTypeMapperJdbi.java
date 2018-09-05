package com.wossha.clothing.infrastructure.dao.clothingtype;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import com.wossha.clothing.dto.ClothingTypeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClothingTypeMapperJdbi implements ResultSetMapper<ClothingTypeDTO> {
	
    @Override
    public ClothingTypeDTO map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        
		return new ClothingTypeDTO(
                r.getInt("ID"),
                r.getString("NAME")
        );
        
    }
}
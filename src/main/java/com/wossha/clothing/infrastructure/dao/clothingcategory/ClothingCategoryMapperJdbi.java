package com.wossha.clothing.infrastructure.dao.clothingcategory;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import com.wossha.clothing.dto.ClothingCategoryDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClothingCategoryMapperJdbi implements ResultSetMapper<ClothingCategoryDTO> {
	
    @Override
    public ClothingCategoryDTO map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        
		return new ClothingCategoryDTO(
                r.getInt("ID"),
                r.getString("NAME")
        );
        
    }
}
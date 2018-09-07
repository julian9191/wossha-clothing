package com.wossha.clothing.infrastructure.dao.brand;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import com.wossha.clothing.dto.BrandDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandMapperJdbi implements ResultSetMapper<BrandDTO> {
	
    @Override
    public BrandDTO map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        
		return new BrandDTO(
                r.getInt("ID"),
                r.getString("NAME")
        );
        
    }
}
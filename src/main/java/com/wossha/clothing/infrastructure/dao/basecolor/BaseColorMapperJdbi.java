package com.wossha.clothing.infrastructure.dao.basecolor;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.wossha.clothing.dto.BaseColorDTO;
import com.wossha.clothing.dto.BrandDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseColorMapperJdbi implements ResultSetMapper<BaseColorDTO> {
	
    @Override
    public BaseColorDTO map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        
		return new BaseColorDTO(
                r.getInt("ID"),
                r.getString("NAME"),
                r.getString("HEXA")
        );
        
    }
}
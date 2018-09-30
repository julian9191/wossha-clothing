package com.wossha.clothing.infrastructure.dao.clothe;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import com.wossha.clothing.dto.ClotheDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClothesMapperJdbi implements ResultSetMapper<ClotheDTO> {

    @Override
    public ClotheDTO map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        
		return new ClotheDTO(
                r.getInt("ID"),
                r.getString("UUID"),
                r.getString("USERNAME"),
                r.getString("NAME"),
                r.getString("DESCRIPTION"),
                r.getString("TYPE"),
                r.getString("CATEGORY"),
                r.getTimestamp("PURCHASE_DATE"),
                r.getInt("HOW_LIKE"),
                r.getString("BRAND"),
                r.getInt("STATE"),
                r.getString("COLOR_CODE"),
                r.getInt("BASE_COLOR"),
                r.getString("PICTURE")
        );
        
    }
}
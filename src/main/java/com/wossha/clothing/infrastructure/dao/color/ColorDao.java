package com.wossha.clothing.infrastructure.dao.color;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.springframework.stereotype.Repository;
import com.wossha.clothing.dto.ColorDTO;

@Repository
public abstract  class ColorDao {
	
	//SELECTS--------------------------------------------------------------------------------------------------------------------------------------
	
	@RegisterMapper(ColorMapperJdbi.class)
	@SqlQuery("SELECT * FROM TWSS_COLORS")
    public abstract List<ColorDTO> getAllColors();
}
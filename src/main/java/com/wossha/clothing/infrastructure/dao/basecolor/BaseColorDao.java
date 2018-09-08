package com.wossha.clothing.infrastructure.dao.basecolor;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.springframework.stereotype.Repository;
import com.wossha.clothing.dto.BaseColorDTO;

@Repository
public abstract  class BaseColorDao {
	
	//SELECTS--------------------------------------------------------------------------------------------------------------------------------------
	
	@RegisterMapper(BaseColorMapperJdbi.class)
	@SqlQuery("SELECT * FROM TWSS_BASE_COLORS order by NAME")
    public abstract List<BaseColorDTO> getAllBaseColors();
}
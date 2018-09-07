package com.wossha.clothing.infrastructure.dao.brand;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.springframework.stereotype.Repository;
import com.wossha.clothing.dto.BrandDTO;

@Repository
public abstract  class BrandDao {
	
	//SELECTS--------------------------------------------------------------------------------------------------------------------------------------
	
	@RegisterMapper(BrandMapperJdbi.class)
	@SqlQuery("SELECT * FROM TWSS_BRANDS order by NAME")
    public abstract List<BrandDTO> getAllBrands();
	
	@RegisterMapper(BrandMapperJdbi.class)
	@SqlQuery("SELECT * FROM TWSS_BRANDS WHERE NAME LIKE :word order by NAME FETCH FIRST 5 ROWS ONLY")
    public abstract List<BrandDTO> searchBrands(@Bind("word") String word);

}
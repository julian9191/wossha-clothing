package com.wossha.clothing.infrastructure.dao.clothingtype;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.springframework.stereotype.Repository;

import com.wossha.clothing.dto.ClothingTypeDTO;

@Repository
public abstract  class ClothingTypeDao {
	
	//SELECTS--------------------------------------------------------------------------------------------------------------------------------------
	
	@RegisterMapper(ClothingTypeMapperJdbi.class)
	@SqlQuery("SELECT * FROM TWSS_CLOTHING_TYPES order by NAME")
    public abstract List<ClothingTypeDTO> getAllClothingTypes();
	
	@RegisterMapper(ClothingTypeMapperJdbi.class)
	@SqlQuery("SELECT * FROM TWSS_CLOTHING_TYPES WHERE NAME LIKE :word order by NAME")
    public abstract List<ClothingTypeDTO> searchClothingTypes(@Bind("word") String word);

}
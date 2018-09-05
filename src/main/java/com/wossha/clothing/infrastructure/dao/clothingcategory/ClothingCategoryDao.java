package com.wossha.clothing.infrastructure.dao.clothingcategory;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.springframework.stereotype.Repository;

import com.wossha.clothing.dto.ClothingCategoryDTO;

@Repository
@RegisterMapper(ClothingCategoryMapperJdbi.class)
public abstract  class ClothingCategoryDao {
	
	//SELECTS--------------------------------------------------------------------------------------------------------------------------------------
	
	@SqlQuery("SELECT * FROM TWSS_CLOTHING_CATEGORIES order by NAME")
    public abstract List<ClothingCategoryDTO> getAllClothingCategories();

}
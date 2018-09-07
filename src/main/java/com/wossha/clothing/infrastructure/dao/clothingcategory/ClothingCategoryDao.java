package com.wossha.clothing.infrastructure.dao.clothingcategory;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.springframework.stereotype.Repository;

import com.wossha.clothing.dto.ClothingCategoryDTO;
import com.wossha.clothing.infrastructure.dao.clothingtype.ClothingTypeMapperJdbi;

@Repository
@RegisterMapper(ClothingCategoryMapperJdbi.class)
public abstract  class ClothingCategoryDao {
	
	//SELECTS--------------------------------------------------------------------------------------------------------------------------------------
	
	@SqlQuery("SELECT * FROM TWSS_CLOTHING_CATEGORIES order by NAME")
    public abstract List<ClothingCategoryDTO> getAllClothingCategories();
	
	@RegisterMapper(ClothingTypeMapperJdbi.class)
	@SqlQuery("SELECT * FROM TWSS_CLOTHING_CATEGORIES WHERE NAME LIKE :word order by NAME FETCH FIRST 5 ROWS ONLY")
    public abstract List<ClothingCategoryDTO> searchClothingCategories(@Bind("word") String word);

}
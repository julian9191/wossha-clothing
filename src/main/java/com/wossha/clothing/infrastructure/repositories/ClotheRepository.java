package com.wossha.clothing.infrastructure.repositories;

import java.util.List;

import org.skife.jdbi.v2.IDBI;
import org.springframework.beans.factory.annotation.Autowired;
import com.wossha.clothing.dto.ClotheDTO;
import com.wossha.clothing.dto.ClothingCategoryDTO;
import com.wossha.clothing.dto.ClothingTypeDTO;
import com.wossha.clothing.infrastructure.dao.clothe.ClothesDao;
import com.wossha.clothing.infrastructure.dao.clothingcategory.ClothingCategoryDao;
import com.wossha.clothing.infrastructure.dao.clothingtype.ClothingTypeDao;

public class ClotheRepository implements Repository<ClotheDTO> {

	@Autowired
	private IDBI dbi;
	
	private ClothesDao clothesDao;
	private ClothingTypeDao clothingTypeDao;
	private ClothingCategoryDao clothingCategoryDao;
    
	@Override
	public void add(ClotheDTO clothe) {
		clothesDao = dbi.onDemand(ClothesDao.class);
    	clothesDao.add(clothe);
	}
	
	public ClotheDTO findClotheByUuid(String uuid) {
		clothesDao = dbi.onDemand(ClothesDao.class);
    	return clothesDao.findClotheByUuid(uuid);
	}
	
	public List<ClothingTypeDTO> getAllClothingTypes() {
		clothingTypeDao = dbi.onDemand(ClothingTypeDao.class);
    	return clothingTypeDao.getAllClothingTypes();
	}
	
	public List<ClothingCategoryDTO> getAllClothingCategories() {
		clothingCategoryDao = dbi.onDemand(ClothingCategoryDao.class);
    	return clothingCategoryDao.getAllClothingCategories();
	}
	
	public List<ClothingTypeDTO> searchClothingTypes(String word) {
		clothingTypeDao = dbi.onDemand(ClothingTypeDao.class);
		word = "%" + word.toUpperCase() + "%";
    	return clothingTypeDao.searchClothingTypes(word);
	}
	
    @Override
    public void update(ClotheDTO clothe) {

    }

    @Override
    public void remove(ClotheDTO clothe) {
    	
    }

}

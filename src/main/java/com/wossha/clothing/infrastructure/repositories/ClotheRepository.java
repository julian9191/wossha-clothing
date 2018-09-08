package com.wossha.clothing.infrastructure.repositories;

import java.util.List;

import org.skife.jdbi.v2.IDBI;
import org.springframework.beans.factory.annotation.Autowired;

import com.wossha.clothing.dto.BaseColorDTO;
import com.wossha.clothing.dto.BrandDTO;
import com.wossha.clothing.dto.ClotheDTO;
import com.wossha.clothing.dto.ClothingCategoryDTO;
import com.wossha.clothing.dto.ClothingTypeDTO;
import com.wossha.clothing.infrastructure.dao.basecolor.BaseColorDao;
import com.wossha.clothing.infrastructure.dao.brand.BrandDao;
import com.wossha.clothing.infrastructure.dao.clothe.ClothesDao;
import com.wossha.clothing.infrastructure.dao.clothingcategory.ClothingCategoryDao;
import com.wossha.clothing.infrastructure.dao.clothingtype.ClothingTypeDao;

public class ClotheRepository implements Repository<ClotheDTO> {

	@Autowired
	private IDBI dbi;
	
	private ClothesDao clothesDao;
	private ClothingTypeDao clothingTypeDao;
	private ClothingCategoryDao clothingCategoryDao;
	private BrandDao brandDao;
    private BaseColorDao baseColorDao;
	
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
	
	public List<ClothingCategoryDTO> searchClothingCategories(String word) {
		clothingCategoryDao = dbi.onDemand(ClothingCategoryDao.class);
		word = "%" + word.toUpperCase() + "%";
    	return clothingCategoryDao.searchClothingCategories(word);
	}
	
	public List<BrandDTO> searchBrands(String word) {
		brandDao = dbi.onDemand(BrandDao.class);
		word = "%" + word.toUpperCase() + "%";
    	return brandDao.searchBrands(word);
	}
	
	public List<BaseColorDTO> getAllBaseColors() {
		baseColorDao = dbi.onDemand(BaseColorDao.class);
    	return baseColorDao.getAllBaseColors();
	}
	
    @Override
    public void update(ClotheDTO clothe) {

    }

    @Override
    public void remove(ClotheDTO clothe) {
    	
    }

}

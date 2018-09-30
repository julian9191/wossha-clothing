package com.wossha.clothing.infrastructure.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.skife.jdbi.v2.IDBI;
import org.springframework.beans.factory.annotation.Autowired;

import com.wossha.clothing.commands.createClothe.model.Clothe;
import com.wossha.clothing.dto.BaseColorDTO;
import com.wossha.clothing.dto.BrandDTO;
import com.wossha.clothing.dto.ClotheDTO;
import com.wossha.clothing.dto.ClothingCategoryDTO;
import com.wossha.clothing.dto.ClothingTypeDTO;
import com.wossha.clothing.dto.ColorDTO;
import com.wossha.clothing.infrastructure.dao.basecolor.BaseColorDao;
import com.wossha.clothing.infrastructure.dao.brand.BrandDao;
import com.wossha.clothing.infrastructure.dao.clothe.ClothesDao;
import com.wossha.clothing.infrastructure.dao.clothingcategory.ClothingCategoryDao;
import com.wossha.clothing.infrastructure.dao.clothingtype.ClothingTypeDao;
import com.wossha.clothing.infrastructure.dao.color.ColorDao;
import com.wossha.msbase.models.Pagination;

public class ClotheRepository implements Repository<Clothe> {

	@Autowired
	private IDBI dbi;
	
	private ClothesDao clothesDao;
	private ClothingTypeDao clothingTypeDao;
	private ClothingCategoryDao clothingCategoryDao;
	private BrandDao brandDao;
    private BaseColorDao baseColorDao;
    private ColorDao colorDao;
	
	@Override
	public void add(Clothe clothe) {
		
	}
	
	public void addClothe(ClotheDTO clothe) {
		clothesDao = dbi.onDemand(ClothesDao.class);
    	clothesDao.add(clothe);
	}
	
	public ClotheDTO findClotheByUuid(String uuid) {
		clothesDao = dbi.onDemand(ClothesDao.class);
    	return clothesDao.findClotheByUuid(uuid);
	}
	
	public Map<String, Object> findClothesByUser(String username, String orderedBy, int init, int limit) {
		clothesDao = dbi.onDemand(ClothesDao.class);
		Integer count = clothesDao.countFindAllClothesByUser(username);
		List<ClotheDTO> clothes = clothesDao.findClothesByUser(username, init, limit, orderedBy);
		
		Pagination pagination = new Pagination(count, init, limit);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("pagination", pagination);
        resultMap.put("result", clothes);
        return resultMap;
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
	
	public List<ColorDTO> getAllColors() {
		colorDao = dbi.onDemand(ColorDao.class);
    	return colorDao.getAllColors();
	}
	
	public Map<String, Integer> getColorsMap() {
		colorDao = dbi.onDemand(ColorDao.class);
		List<ColorDTO> colorsList = colorDao.getAllColors();
		Map<String, Integer> colorsMap = new HashMap<String, Integer>();
		for (ColorDTO color : colorsList) {
			if(!colorsMap.containsKey(color.getHexa())) {
				colorsMap.put("#"+color.getHexa(), color.getBaseColor());
			}
		}

    	return colorsMap; 
	}
	
    @Override
    public void update(Clothe clothe) {

    }

    @Override
    public void remove(Clothe clothe) {
    	
    }

	
}

package com.wossha.clothing.infrastructure.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.skife.jdbi.v2.IDBI;
import org.springframework.beans.factory.annotation.Autowired;

import com.wossha.clothing.commands.clothing.createClothe.model.Clothe;
import com.wossha.clothing.dto.BaseColorDTO;
import com.wossha.clothing.dto.BrandDTO;
import com.wossha.clothing.dto.ClotheDTO;
import com.wossha.clothing.dto.ClotheViewDTO;
import com.wossha.clothing.dto.ClothingCategoryDTO;
import com.wossha.clothing.dto.ClothingTypeDTO;
import com.wossha.clothing.dto.ColorDTO;
import com.wossha.clothing.dto.SearchCriteriaDTO;
import com.wossha.clothing.infrastructure.dao.basecolor.BaseColorDao;
import com.wossha.clothing.infrastructure.dao.brand.BrandDao;
import com.wossha.clothing.infrastructure.dao.clothe.ClothesDao;
import com.wossha.clothing.infrastructure.dao.clothingcategory.ClothingCategoryDao;
import com.wossha.clothing.infrastructure.dao.clothingtype.ClothingTypeDao;
import com.wossha.clothing.infrastructure.dao.color.ColorDao;
import com.wossha.clothing.infrastructure.dao.statistics.StatisticsDao;
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
	private StatisticsDao statisticsDao;

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

	public Map<String, Object> findClothesByUser(String username, SearchCriteriaDTO searchCriteria, String orderedBy, int init, int limit) {
		clothesDao = dbi.onDemand(ClothesDao.class);
		
		List<String> types = searchCriteria.getTypes().stream().map(x -> x.getId())
				.collect(Collectors.toList());
		List<String> categories = searchCriteria.getCategories().stream().map(x -> x.getId())
				.collect(Collectors.toList());
		List<String> brands = searchCriteria.getBrands().stream().map(x -> x.getId())
				.collect(Collectors.toList());
		List<String> colors = searchCriteria.getColors().stream().map(x -> x.getId())
				.collect(Collectors.toList());
		
		//Integer count = clothesDao.countFindAllClothesByUser(username);
		Integer count = clothesDao.countSearchClothesByUser(dbi, username, types, categories, brands, colors, searchCriteria.getHowLike(), searchCriteria.getNoWearingDaysSimbol(), searchCriteria.getNoWearingDays());
		
		//List<ClotheDTO> clothes = clothesDao.findClothesByUser(username, init, limit, orderedBy);
		List<ClotheDTO> clothes = clothesDao.searchClothesByUser(dbi, username, types, categories, brands, colors, searchCriteria.getHowLike(), orderedBy, init, limit, searchCriteria.getNoWearingDaysSimbol(), searchCriteria.getNoWearingDays());

		Pagination pagination = new Pagination(count, init, limit);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("pagination", pagination);
		resultMap.put("result", clothes);
		return resultMap;
	}
	
	public Map<String, Object> searchClothesByUser(String username, SearchCriteriaDTO searchCriteria, int init, int limit) {
		clothesDao = dbi.onDemand(ClothesDao.class);
		
		List<String> types = searchCriteria.getTypes().stream().map(x -> x.getId())
				.collect(Collectors.toList());
		List<String> categories = searchCriteria.getCategories().stream().map(x -> x.getId())
				.collect(Collectors.toList());
		List<String> brands = searchCriteria.getBrands().stream().map(x -> x.getId())
				.collect(Collectors.toList());
		List<String> colors = searchCriteria.getColors().stream().map(x -> x.getId())
				.collect(Collectors.toList());
		
		Integer count = clothesDao.countSearchClothesByUser(dbi, username, types, categories, brands, colors, searchCriteria.getHowLike(), searchCriteria.getNoWearingDaysSimbol(), searchCriteria.getNoWearingDays());

		List<ClotheDTO> clothes = clothesDao.searchClothesByUser(dbi, username, types, categories, brands, colors, searchCriteria.getHowLike(), null, init, limit, searchCriteria.getNoWearingDaysSimbol(), searchCriteria.getNoWearingDays());

		Pagination pagination = new Pagination(count, init, limit);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("pagination", pagination);
		resultMap.put("result", clothes);
		return resultMap;
	}
	
	public List<ClotheDTO> getOutfit(String username, SearchCriteriaDTO searchCriteria, String uuid, String type) {
clothesDao = dbi.onDemand(ClothesDao.class);
		
		List<ClotheDTO> clothes = new ArrayList<>();
		List<String> types = new ArrayList<>();
		List<String> uuids = new ArrayList<>();

		if(type==null || type.equals("") || type.equals("null")) {
			types = searchCriteria.getTypes().stream().map(x -> x.getId())
					.collect(Collectors.toList());
		}else {
			types.add(type);
		}
		
		if(uuid!= null) {
			String[] parts = uuid.split(",");
			uuids.addAll(Arrays.asList(parts));
		}
		
		List<String> categories = searchCriteria.getCategories().stream().map(x -> x.getId())
				.collect(Collectors.toList());
		List<String> brands = searchCriteria.getBrands().stream().map(x -> x.getId())
				.collect(Collectors.toList());
		List<String> colors = searchCriteria.getColors().stream().map(x -> x.getId())
				.collect(Collectors.toList());
		
		if(types.isEmpty()) {
			types = clothesDao.getTypesByUser(username);
		}
		
		for (String item : types) {
			ClotheDTO clothe = clothesDao.getOutfit(dbi, username, item, categories, brands, colors, searchCriteria.getHowLike(), uuids, searchCriteria.getNoWearingDaysSimbol(), searchCriteria.getNoWearingDays());
			if(clothe != null) {
				clothes.add(clothe);
			}
			
		}
		return clothes;
	}
	

	public ClotheDTO findClotheByUuid(String username, String uuid) {
		clothesDao = dbi.onDemand(ClothesDao.class);
		return clothesDao.findClotheByUuid(username, uuid);
	}
	
	public ClotheViewDTO getClotheViewByUuid(String username, String uuid) {
		clothesDao = dbi.onDemand(ClothesDao.class);
		statisticsDao = dbi.onDemand(StatisticsDao.class);
		
		ClotheViewDTO view = new ClotheViewDTO();
		view.setClothe(clothesDao.findClotheByUuid(username, uuid));
		view.setUseTimesByMonth(statisticsDao.getUseTimesByMonth(username, view.getClothe().getId()));
		view.setUseTimes(statisticsDao.getUseTimes(username, view.getClothe().getId()));
		view.setUseDates(statisticsDao.getUseDates(username, view.getClothe().getId()));
		
		return view;
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
			if (!colorsMap.containsKey(color.getHexa())) {
				colorsMap.put("#" + color.getHexa(), color.getBaseColor());
			}
		}

		return colorsMap;
	}
	
	public void updateClothe(ClotheDTO clothe) {
		clothesDao = dbi.onDemand(ClothesDao.class);
		if (clothe.getPicture() == null) {
			clothesDao.updateWithoutPicture(clothe);
		} else {
			clothesDao.updateWithPicture(clothe);
		}

	}

	public void removeClothe(String uuid) {
		clothesDao = dbi.onDemand(ClothesDao.class);
		clothesDao.remove(uuid);
	}

	@Override
	public void update(Clothe clothe) {

	}

	@Override
	public void remove(Clothe clothe) {

	}

	
	//STADISTICS-----------------------------------------------------------------------------------------------------------------
	

}

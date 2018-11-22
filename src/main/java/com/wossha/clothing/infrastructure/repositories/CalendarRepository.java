package com.wossha.clothing.infrastructure.repositories;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.skife.jdbi.v2.IDBI;
import org.springframework.beans.factory.annotation.Autowired;

import com.wossha.clothing.commands.clothing.createClothe.model.Clothe;
import com.wossha.clothing.dto.CalendarClotheDTO;
import com.wossha.clothing.dto.ClotheDTO;
import com.wossha.clothing.dto.MultiselectItem;
import com.wossha.clothing.dto.SearchCriteriaParamsDTO;
import com.wossha.clothing.infrastructure.dao.clothe.ClothesDao;


public class CalendarRepository implements Repository<Clothe> {

	@Autowired
	private IDBI dbi;

	private ClothesDao clothesDao;
	
	
	public SearchCriteriaParamsDTO getSearchCriteriaParamsByUser(String username) {
		SearchCriteriaParamsDTO searchCriteriaParams = new SearchCriteriaParamsDTO();

		clothesDao = dbi.onDemand(ClothesDao.class);

		List<MultiselectItem> types = clothesDao.getTypesByUser(username).stream().map(x -> new MultiselectItem(x, x))
				.collect(Collectors.toList());
		List<MultiselectItem> Categories = clothesDao.getCategoriesByUser(username).stream().map(x -> new MultiselectItem(x, x))
				.collect(Collectors.toList());
		List<MultiselectItem> brands = clothesDao.getBrandsByUser(username).stream().map(x -> new MultiselectItem(x, x))
				.collect(Collectors.toList());
		List<MultiselectItem> colors = clothesDao.getColorNamesByUser(username).stream().map(x -> new MultiselectItem(x.getId()+"", x.getName()))
				.collect(Collectors.toList());

		searchCriteriaParams.setTypes(types);
		searchCriteriaParams.setCategories(Categories);
		searchCriteriaParams.setBrands(brands);
		searchCriteriaParams.setColors(colors);

		return searchCriteriaParams;
	}
	
	public ClotheDTO findClotheByDate(String uuid, Timestamp day) {
		clothesDao = dbi.onDemand(ClothesDao.class);
		return clothesDao.findClotheByDate(uuid, day);
	}

	public void addToCalendar(String username, Timestamp day, Integer idClothe, String uuidClothe) {
		clothesDao = dbi.onDemand(ClothesDao.class);
		clothesDao.addToCalendar(username, day, idClothe, uuidClothe);
	}

	public List<ClotheDTO> getDayClothing(String username, Date date) {
		clothesDao = dbi.onDemand(ClothesDao.class);
		return clothesDao.getDayClothing(username, date);
	}

	public String getDayDescription(String username, Date date) {
		clothesDao = dbi.onDemand(ClothesDao.class);
		return clothesDao.getDayDescription(username, date);
	}

	public void addDayDescription(String username, Timestamp day, String description) {
		clothesDao = dbi.onDemand(ClothesDao.class);
		clothesDao.addDayDescription(username, day, description);
	}

	public void editDayDescription(String username, Timestamp day, String description) {
		clothesDao = dbi.onDemand(ClothesDao.class);
		clothesDao.editDayDescription(username, new Date(day.getTime()), description);
	}

	public void removeClotheFromDay(String username, Timestamp day, String uuidClothe) {
		clothesDao = dbi.onDemand(ClothesDao.class);
		clothesDao.removeClotheFromDay(username, new Date(day.getTime()), uuidClothe);
	}

	public List<CalendarClotheDTO> getEventsByView(String username, Date startDate, Date endDate) {
		clothesDao = dbi.onDemand(ClothesDao.class);
		return clothesDao.getEventsByView(username, startDate, endDate);
	}
	
	@Override
	public void add(Clothe clothe) {

	}

	

	@Override
	public void update(Clothe clothe) {

	}

	@Override
	public void remove(Clothe clothe) {

	}

}

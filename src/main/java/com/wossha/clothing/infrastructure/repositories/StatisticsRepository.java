package com.wossha.clothing.infrastructure.repositories;

import org.skife.jdbi.v2.IDBI;
import org.springframework.beans.factory.annotation.Autowired;
import com.wossha.clothing.commands.clothing.createClothe.model.Clothe;
import com.wossha.clothing.dto.StatisticsDTO;
import com.wossha.clothing.infrastructure.dao.clothe.ClothesDao;
import com.wossha.clothing.infrastructure.dao.statistics.StatisticsDao;


public class StatisticsRepository implements Repository<Clothe> {

	@Autowired
	private IDBI dbi;
	private ClothesDao clothesDao;
	private StatisticsDao statisticsDao;

	
	public StatisticsDTO getTypePieData(String username) {
		StatisticsDTO statistics = new StatisticsDTO();
		
		clothesDao = dbi.onDemand(ClothesDao.class);
		Integer count = clothesDao.countFindAllClothesByUser(username);
		
		statisticsDao = dbi.onDemand(StatisticsDao.class);
		statistics.setTotal(count);
		statistics.setTypes(statisticsDao.getTypePieData(username, count));
		statistics.setCategories(statisticsDao.getCategoryPieData(username, count));
		statistics.setHowLike(statisticsDao.getHowLikePieData(username, count));
		statistics.setBrands(statisticsDao.getBrandPieData(username, count));
		statistics.setColors(statisticsDao.getColorPieData(username, count));
		statistics.setMostUsedClothing(statisticsDao.getMostUsedClothing(username));

		return statistics;
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

package com.wossha.clothing.infrastructure.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.skife.jdbi.v2.IDBI;
import org.springframework.beans.factory.annotation.Autowired;
import com.wossha.clothing.commands.clothing.createClothe.model.Clothe;
import com.wossha.clothing.dto.ClotheDTO;
import com.wossha.clothing.dto.StatisticsDTO;
import com.wossha.clothing.dto.StatisticsMapDTO;
import com.wossha.clothing.infrastructure.dao.clothe.ClothesDao;
import com.wossha.clothing.infrastructure.dao.statistics.StatisticsDao;
import com.wossha.msbase.models.Pagination;


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
		statistics.setTypes(statisticsDao.getTypePieData(username, count));

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

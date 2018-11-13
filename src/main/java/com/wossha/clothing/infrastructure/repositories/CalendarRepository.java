package com.wossha.clothing.infrastructure.repositories;

import org.skife.jdbi.v2.IDBI;
import org.springframework.beans.factory.annotation.Autowired;

import com.wossha.clothing.commands.clothing.createClothe.model.Clothe;
import com.wossha.clothing.infrastructure.dao.clothe.ClothesDao;


public class CalendarRepository implements Repository<Clothe> {

	@Autowired
	private IDBI dbi;

	private ClothesDao clothesDao;
	
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

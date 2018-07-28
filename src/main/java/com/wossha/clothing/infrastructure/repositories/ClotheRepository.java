package com.wossha.clothing.infrastructure.repositories;

import org.skife.jdbi.v2.IDBI;
import org.springframework.beans.factory.annotation.Autowired;
import com.wossha.clothing.dto.ClotheDTO;
import com.wossha.clothing.infrastructure.dao.user.ClothesDao;

public class ClotheRepository implements Repository<ClotheDTO> {

	@Autowired
	private IDBI dbi;
	
	private ClothesDao clothesDao;
    
	@Override
	public void add(ClotheDTO clothe) {
		clothesDao = dbi.onDemand(ClothesDao.class);
    	clothesDao.add(clothe);
	}
	
	public ClotheDTO findClotheByUuid(String uuid) {
		clothesDao = dbi.onDemand(ClothesDao.class);
    	return clothesDao.findClotheByUuid(uuid);
	}
	
    @Override
    public void update(ClotheDTO clothe) {

    }

    @Override
    public void remove(ClotheDTO clothe) {
    	
    }
	

}

package com.wossha.clothing.infrastructure.dao.clothe;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.springframework.stereotype.Repository;

import com.wossha.clothing.dto.ClotheDTO;

@Repository
public abstract  class ClothesDao {
	
	//SELECTS--------------------------------------------------------------------------------------------------------------------------------------
	
	@RegisterMapper(ClothesMapperJdbi.class)
	@SqlQuery("SELECT * FROM TWSS_CLOTHES WHERE UUID = :uuid")
    public abstract ClotheDTO findClotheByUuid(@Bind("uuid") String uuid);
    
    //INSERTS--------------------------------------------------------------------------------------------------------------------------------------
    
	@RegisterMapper(ClothesMapperJdbi.class)
    @SqlUpdate("Insert into TWSS_CLOTHES (UUID,USERNAME,NAME,DESCRIPTION,TYPE,CATEGORY,PURCHASE_DATE,HOW_LIKE,BRAND,COLOR_CODE,BASE_COLOR) values (:clothe.uuid, :clothe.username, :clothe.name, :clothe.description, :clothe.type, :clothe.category, :clothe.purchaseDate, :clothe.howLike, :clothe.brand, :clothe.colorCode, :clothe.baseColor)")
    public abstract void add(@BindBean("clothe") ClotheDTO clothe);
    
    
    //UPDATES----------------------------------------------------------------------------------------------------------------------------------------
    
    //@RegisterMapper(ClothesMapperJdbi.class)
    //@SqlUpdate("UPDATE TWSS_USERS SET FIRST_NAME=:user.firstName, LAST_NAME=:user.lastName, EMAIL=:user.email, BIRTHDAY=:user.birthday, ABOUT=:user.about, COUNTRY_ID=:user.country, GENDER=:user.gender, MODIFIED=SYSDATE WHERE USERNAME=:user.username")
    //public abstract void update(@BindBean("user") UserRecord user);

    
    public abstract void close();

}
package com.wossha.clothing.infrastructure.dao.clothe;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Define;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;
import org.springframework.stereotype.Repository;

import com.wossha.clothing.commands.createClothe.model.Clothe;
import com.wossha.clothing.dto.ClotheDTO;

@Repository
@UseStringTemplate3StatementLocator
public abstract  class ClothesDao {
	
	//SELECTS--------------------------------------------------------------------------------------------------------------------------------------
	
	@RegisterMapper(ClothesMapperJdbi.class)
	@SqlQuery("SELECT * FROM TWSS_CLOTHES WHERE UUID = :uuid")
    public abstract ClotheDTO findClotheByUuid(@Bind("uuid") String uuid);
	
	@RegisterMapper(ClothesMapperJdbi.class)
	@SqlQuery("SELECT * FROM TWSS_CLOTHES WHERE USERNAME = :username ORDER BY <orderedBy> OFFSET :init ROWS FETCH NEXT :limit ROWS ONLY")
    public abstract List<ClotheDTO> findClothesByUser(@Bind("username") String username, @Bind("init") int init, @Bind("limit") int limit, @Define("orderedBy") String orderedBy);
	
	@RegisterMapper(ClothesMapperJdbi.class)
	@SqlQuery("SELECT COUNT(0) FROM TWSS_CLOTHES WHERE USERNAME = :username")
    public abstract Integer countFindAllClothesByUser(@Bind("username") String username);
    
    //INSERTS--------------------------------------------------------------------------------------------------------------------------------------
    
	@RegisterMapper(ClothesMapperJdbi.class)
    @SqlUpdate("Insert into TWSS_CLOTHES (UUID,USERNAME,NAME,DESCRIPTION,TYPE,CATEGORY,PURCHASE_DATE,HOW_LIKE,BRAND,COLOR_CODE,BASE_COLOR,PICTURE) values (:clothe.uuid, :clothe.username, :clothe.name, :clothe.description, :clothe.type, :clothe.category, :clothe.purchaseDate, :clothe.howLike, :clothe.brand, :clothe.colorCode, :clothe.baseColor, :clothe.picture)")
    public abstract void add(@BindBean("clothe") ClotheDTO clothe);
    
    
    //UPDATES----------------------------------------------------------------------------------------------------------------------------------------
    
    //@RegisterMapper(ClothesMapperJdbi.class)
    //@SqlUpdate("UPDATE TWSS_USERS SET FIRST_NAME=:user.firstName, LAST_NAME=:user.lastName, EMAIL=:user.email, BIRTHDAY=:user.birthday, ABOUT=:user.about, COUNTRY_ID=:user.country, GENDER=:user.gender, MODIFIED=SYSDATE WHERE USERNAME=:user.username")
    //public abstract void update(@BindBean("user") UserRecord user);

    
    public abstract void close();

}
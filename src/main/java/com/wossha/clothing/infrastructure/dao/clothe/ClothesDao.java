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
import com.wossha.clothing.dto.BaseColorDTO;
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
	@SqlQuery("SELECT * FROM TWSS_CLOTHES WHERE USERNAME = :username AND UUID = :uuid")
    public abstract ClotheDTO findClotheByUuid(@Bind("username") String username, @Bind("uuid") String uuid);
	
	@RegisterMapper(ClothesMapperJdbi.class)
	@SqlQuery("SELECT COUNT(0) FROM TWSS_CLOTHES WHERE USERNAME = :username")
    public abstract Integer countFindAllClothesByUser(@Bind("username") String username);
	
	@SqlQuery("SELECT TYPE FROM TWSS_CLOTHES WHERE USERNAME = :username GROUP BY TYPE ORDER BY TYPE")
    public abstract List<String> getTypesByUser(@Bind("username") String username);
	
	@SqlQuery("SELECT CATEGORY FROM TWSS_CLOTHES WHERE USERNAME = :username GROUP BY CATEGORY ORDER BY CATEGORY")
    public abstract List<String> getCategoriesByUser(@Bind("username") String username);
	
	@SqlQuery("SELECT BRAND FROM TWSS_CLOTHES WHERE USERNAME = :username GROUP BY BRAND ORDER BY BRAND")
    public abstract List<String> getBrandsByUser(@Bind("username") String username);
	
	@RegisterMapper(BaseColorMapperJdbi.class)
	@SqlQuery("SELECT CO.ID, CO.NAME FROM TWSS_CLOTHES CL JOIN TWSS_BASE_COLORS CO ON CL.BASE_COLOR = CO.ID WHERE CL.USERNAME = :username GROUP BY CO.ID, CO.NAME ORDER BY CO.NAME")
    public abstract List<BaseColorDTO> getColorNamesByUser(@Bind("username") String username);
    
    //INSERTS--------------------------------------------------------------------------------------------------------------------------------------
    
	@RegisterMapper(ClothesMapperJdbi.class)
    @SqlUpdate("Insert into TWSS_CLOTHES (UUID,USERNAME,NAME,DESCRIPTION,TYPE,CATEGORY,PURCHASE_DATE,HOW_LIKE,BRAND,COLOR_CODE,BASE_COLOR,PICTURE) values (:clothe.uuid, :clothe.username, :clothe.name, :clothe.description, :clothe.type, :clothe.category, :clothe.purchaseDate, :clothe.howLike, :clothe.brand, :clothe.colorCode, :clothe.baseColor, :clothe.picture)")
    public abstract void add(@BindBean("clothe") ClotheDTO clothe);
    
    
    //UPDATES----------------------------------------------------------------------------------------------------------------------------------------
    
    @RegisterMapper(ClothesMapperJdbi.class)
    @SqlUpdate("UPDATE TWSS_CLOTHES SET NAME = :clothe.name, DESCRIPTION = :clothe.description, TYPE = :clothe.type, CATEGORY = :clothe.category, PURCHASE_DATE = :clothe.purchaseDate, HOW_LIKE = :clothe.howLike, BRAND = :clothe.brand, COLOR_CODE = :clothe.colorCode, BASE_COLOR = :clothe.baseColor, PICTURE = :clothe.picture, MODIFIED=SYSDATE WHERE UUID=:clothe.uuid")
    public abstract void updateWithPicture(@BindBean("clothe") ClotheDTO clothe);
    
    @RegisterMapper(ClothesMapperJdbi.class)
    @SqlUpdate("UPDATE TWSS_CLOTHES SET NAME = :clothe.name, DESCRIPTION = :clothe.description, TYPE = :clothe.type, CATEGORY = :clothe.category, PURCHASE_DATE = :clothe.purchaseDate, HOW_LIKE = :clothe.howLike, BRAND = :clothe.brand, COLOR_CODE = :clothe.colorCode, BASE_COLOR = :clothe.baseColor, MODIFIED=SYSDATE WHERE UUID=:clothe.uuid")
    public abstract void updateWithoutPicture(@BindBean("clothe") ClotheDTO clothe);

    
    //REMOVES----------------------------------------------------------------------------------------------------------------------------------------
    @RegisterMapper(ClothesMapperJdbi.class)
    @SqlUpdate("DELETE FROM TWSS_CLOTHES WHERE UUID=:uuid")
    public abstract void remove(@Bind("uuid") String uuid);

    
    
    public abstract void close();

}
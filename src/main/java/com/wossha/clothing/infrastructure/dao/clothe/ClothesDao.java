package com.wossha.clothing.infrastructure.dao.clothe;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.IDBI;
import org.skife.jdbi.v2.Query;
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
import com.wossha.clothing.infrastructure.dao.BaseDao;

@Repository
@UseStringTemplate3StatementLocator
public abstract class ClothesDao {

	// SELECTS--------------------------------------------------------------------------------------------------------------------------------------

	@RegisterMapper(ClothesMapperJdbi.class)
	@SqlQuery("SELECT * FROM TWSS_CLOTHES WHERE UUID = :uuid")
	public abstract ClotheDTO findClotheByUuid(@Bind("uuid") String uuid);

	@RegisterMapper(ClothesMapperJdbi.class)
	@SqlQuery("SELECT * FROM TWSS_CLOTHES WHERE USERNAME = :username ORDER BY <orderedBy> OFFSET :init ROWS FETCH NEXT :limit ROWS ONLY")
	public abstract List<ClotheDTO> findClothesByUser(@Bind("username") String username, @Bind("init") int init,
			@Bind("limit") int limit, @Define("orderedBy") String orderedBy);

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

	
	public List<ClotheDTO> searchClothesByUser(IDBI dbi, String username, List<String> types, List<String> categories,
			List<String> brands, List<String> colors, Integer howLike, int init, int limit) {
		
		BaseDao<ClotheDTO> baseDao = new BaseDao<>();
		String query = "SELECT * FROM TWSS_CLOTHES ";
		query += "WHERE USERNAME = :username ";
		query += !types.isEmpty() ? "AND TYPE IN (<types>) " : " ";
		query += !categories.isEmpty() ? "AND CATEGORY IN (<categories>) " : " ";
		query += !brands.isEmpty() ? "AND BRAND IN (<brands>) " : " ";
		query += !colors.isEmpty() ? "AND BASE_COLOR IN (<colors>) " : " ";
		query += howLike != null ? "AND HOW_LIKE = :howLike " : " ";
		query += "ORDER BY NAME";
		
		Map<String, List<String>> typesBindMap = new HashMap<>();
		typesBindMap.put("types", types);
		typesBindMap.put("categories", categories);
		typesBindMap.put("brands", brands);
		typesBindMap.put("colors", colors);
		query = baseDao.generateBingIdentifier(query, typesBindMap);
		
		
		Handle h = dbi.open();
		@SuppressWarnings("unchecked")
		Query<ClotheDTO> q = h.createQuery(query)
				.map(new ClothesMapperJdbi())
				.bind("username", username)
				.bind("howLike", howLike);
		
		q = baseDao.addInClauseBind(q, typesBindMap);
		List<ClotheDTO> output = (List<ClotheDTO>) q.list();
          
        return output;
    }
	
	public Integer countSearchClothesByUser(IDBI dbi, String username, List<String> types, List<String> categories,
			List<String> brands, List<String> colors, Integer howLike) {
		
		BaseDao<Integer> baseDao = new BaseDao<>();
		String query = "SELECT COUNT(0) FROM TWSS_CLOTHES ";
		query += "WHERE USERNAME = :username ";
		query += !types.isEmpty() ? "AND TYPE IN (<types>) " : " ";
		query += !categories.isEmpty() ? "AND CATEGORY IN (<categories>) " : " ";
		query += !brands.isEmpty() ? "AND BRAND IN (<brands>) " : " ";
		query += !colors.isEmpty() ? "AND BASE_COLOR IN (<colors>) " : " ";
		query += howLike != null ? "AND HOW_LIKE = :howLike " : " ";
		query += "ORDER BY NAME";
		
		Map<String, List<String>> typesBindMap = new HashMap<>();
		typesBindMap.put("types", types);
		typesBindMap.put("categories", categories);
		typesBindMap.put("brands", brands);
		typesBindMap.put("colors", colors);
		query = baseDao.generateBingIdentifier(query, typesBindMap);
		
		
		Handle h = dbi.open();
		@SuppressWarnings("unchecked")
		Query<Integer> q = h.createQuery(query)
				.mapTo(Integer.class)
				.bind("username", username)
				.bind("howLike", howLike);
		
		q = baseDao.addInClauseBind(q, typesBindMap);
		Integer output =  q.first();
          
        return output;
    }
	
	@RegisterMapper(ClothesMapperJdbi.class)
	@SqlQuery("SELECT cl.* FROM TWSS_CALENDAR ca JOIN TWSS_CLOTHES cl ON ca.ID_CLOTHE = cl.ID WHERE ca.UUID_CLOTHE = :uuid AND TRUNC(ca.DAY) = TRUNC(:day) ")
	public abstract ClotheDTO findClotheByDate(@Bind("uuid") String uuid, @Bind("day") Date day);
	
	@RegisterMapper(ClothesMapperJdbi.class)
	@SqlQuery("SELECT cl.* FROM TWSS_CALENDAR ca JOIN TWSS_CLOTHES cl ON ca.ID_CLOTHE = cl.ID WHERE cl.USERNAME = :username AND TRUNC(ca.DAY) = TRUNC(:date)")
	public abstract List<ClotheDTO> getDayClothing(@Bind("username") String username, @Bind("date") Date date);
	
	@SqlQuery("SELECT DESCRIPTION FROM TWSS_CALENDAR_DESCRIPTION WHERE USERNAME = :username AND TRUNC(DAY) = TRUNC(:date)")
	public abstract String getDayDescription(@Bind("username") String username, @Bind("date") Date date);
	
	
	

	// INSERTS--------------------------------------------------------------------------------------------------------------------------------------

	@RegisterMapper(ClothesMapperJdbi.class)
	@SqlUpdate("Insert into TWSS_CLOTHES (UUID,USERNAME,NAME,DESCRIPTION,TYPE,CATEGORY,PURCHASE_DATE,HOW_LIKE,BRAND,COLOR_CODE,BASE_COLOR,PICTURE) values (:clothe.uuid, :clothe.username, :clothe.name, :clothe.description, :clothe.type, :clothe.category, :clothe.purchaseDate, :clothe.howLike, :clothe.brand, :clothe.colorCode, :clothe.baseColor, :clothe.picture)")
	public abstract void add(@BindBean("clothe") ClotheDTO clothe);
	
	@RegisterMapper(ClothesMapperJdbi.class)
	@SqlUpdate("Insert into TWSS_CALENDAR (ID_CLOTHE,UUID_CLOTHE,USERNAME,DAY) values (:idClothe, :uuidClothe, :username, :day)")
	public abstract void addToCalendar(@Bind("username") String username, @Bind("day") Date day, @Bind("idClothe") Integer idClothe, @Bind("uuidClothe") String uuidClothe);
	
	@RegisterMapper(ClothesMapperJdbi.class)
	@SqlUpdate("Insert into TWSS_CALENDAR_DESCRIPTION (USERNAME,DAY,DESCRIPTION) values (:username, :day, :description)")
	public abstract void addDayDescription(@Bind("username") String username, @Bind("day") Date day, @Bind("description") String description);

	// UPDATES----------------------------------------------------------------------------------------------------------------------------------------

	@RegisterMapper(ClothesMapperJdbi.class)
	@SqlUpdate("UPDATE TWSS_CLOTHES SET NAME = :clothe.name, DESCRIPTION = :clothe.description, TYPE = :clothe.type, CATEGORY = :clothe.category, PURCHASE_DATE = :clothe.purchaseDate, HOW_LIKE = :clothe.howLike, BRAND = :clothe.brand, COLOR_CODE = :clothe.colorCode, BASE_COLOR = :clothe.baseColor, PICTURE = :clothe.picture, MODIFIED=SYSDATE WHERE UUID=:clothe.uuid")
	public abstract void updateWithPicture(@BindBean("clothe") ClotheDTO clothe);

	@RegisterMapper(ClothesMapperJdbi.class)
	@SqlUpdate("UPDATE TWSS_CLOTHES SET NAME = :clothe.name, DESCRIPTION = :clothe.description, TYPE = :clothe.type, CATEGORY = :clothe.category, PURCHASE_DATE = :clothe.purchaseDate, HOW_LIKE = :clothe.howLike, BRAND = :clothe.brand, COLOR_CODE = :clothe.colorCode, BASE_COLOR = :clothe.baseColor, MODIFIED=SYSDATE WHERE UUID=:clothe.uuid")
	public abstract void updateWithoutPicture(@BindBean("clothe") ClotheDTO clothe);
	
	@RegisterMapper(ClothesMapperJdbi.class)
	@SqlUpdate("UPDATE TWSS_CALENDAR_DESCRIPTION SET DESCRIPTION = :description, MODIFIED=SYSDATE WHERE USERNAME = :username AND TRUNC(DAY) = TRUNC(:day)")
	public abstract void editDayDescription(@Bind("username") String username, @Bind("day") Date day, @Bind("description") String description);

	// REMOVES----------------------------------------------------------------------------------------------------------------------------------------
	@RegisterMapper(ClothesMapperJdbi.class)
	@SqlUpdate("DELETE FROM TWSS_CLOTHES WHERE UUID=:uuid")
	public abstract void remove(@Bind("uuid") String uuid);

	public abstract void close();

}
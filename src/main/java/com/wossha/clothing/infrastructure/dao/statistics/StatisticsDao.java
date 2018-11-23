package com.wossha.clothing.infrastructure.dao.statistics;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Define;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;
import org.springframework.stereotype.Repository;

import com.wossha.clothing.dto.ClothigTopDTO;
import com.wossha.clothing.dto.StatisticsMapDTO;

@Repository
@UseStringTemplate3StatementLocator
public abstract class StatisticsDao {

	// SELECTS--------------------------------------------------------------------------------------------------------------------------------------

	@RegisterMapper(StatisticsMapMapperJdbi.class)
	@SqlQuery("SELECT " + 
			"    CL.TYPE KEY, " + 
			"    ROUND(( COUNT(*) / :total )*100,1) VALUE, " + 
			"    ROUND(COUNT(*),1) TOTAL " + 
			"FROM " + 
			"TWSS_CLOTHES CL " + 
			"WHERE " + 
			"CL.USERNAME = :username " + 
			"GROUP BY CL.TYPE")
	public abstract List<StatisticsMapDTO> getTypePieData(@Bind("username") String username, @Bind("total") Integer total);
	
	@RegisterMapper(StatisticsMapMapperJdbi.class)
	@SqlQuery("SELECT " + 
			"    CL.CATEGORY KEY, " + 
			"    ROUND(( COUNT(*) / :total )*100,1) VALUE, " + 
			"    ROUND(COUNT(*),1) TOTAL " + 
			"FROM " + 
			"TWSS_CLOTHES CL " + 
			"WHERE " + 
			"CL.USERNAME = :username " + 
			"GROUP BY CL.CATEGORY")
	public abstract List<StatisticsMapDTO> getCategoryPieData(@Bind("username") String username, @Bind("total") Integer total);
	
	@RegisterMapper(StatisticsMapMapperJdbi.class)
	@SqlQuery("SELECT " + 
			"    CL.HOW_LIKE KEY, " + 
			"    ROUND(( COUNT(*) / :total )*100,1) VALUE, " + 
			"    ROUND(COUNT(*),1) TOTAL " + 
			"FROM " + 
			"TWSS_CLOTHES CL " + 
			"WHERE " + 
			"CL.USERNAME = :username " + 
			"GROUP BY CL.HOW_LIKE")
	public abstract List<StatisticsMapDTO> getHowLikePieData(@Bind("username") String username, @Bind("total") Integer total);
	
	@RegisterMapper(StatisticsMapMapperJdbi.class)
	@SqlQuery("SELECT " + 
			"    NVL(CL.BRAND, 'DESCONOCIDA') KEY, " + 
			"    ROUND(( COUNT(*) / :total )*100,1) VALUE, " + 
			"    ROUND(COUNT(*),1) TOTAL " + 
			"FROM " + 
			"TWSS_CLOTHES CL " + 
			"WHERE " + 
			"CL.USERNAME = :username " + 
			"GROUP BY CL.BRAND")
	public abstract List<StatisticsMapDTO> getBrandPieData(@Bind("username") String username, @Bind("total") Integer total);
	
	
	@RegisterMapper(StatisticsMapMapperJdbi.class)
	@SqlQuery("SELECT " + 
			"    C.NAME KEY, " + 
			"    ROUND(( COUNT(*) / :total )*100,1) VALUE, " + 
			"    ROUND(COUNT(*),1) TOTAL " + 
			"FROM " + 
			"TWSS_CLOTHES CL JOIN TWSS_BASE_COLORS C ON CL.BASE_COLOR=C.ID " + 
			"WHERE " + 
			"CL.USERNAME = :username " + 
			"GROUP BY C.NAME")
	public abstract List<StatisticsMapDTO> getColorPieData(@Bind("username") String username, @Bind("total") Integer total);
	
	@RegisterMapper(ClothingTopMapperJdbi.class)
	@SqlQuery("SELECT CL2.ID, CL2.UUID, CL2.NAME, CL2.TYPE, CL2.PICTURE, Q.TOTAL FROM " + 
			"(SELECT CL.ID, COUNT(*) TOTAL FROM TWSS_CALENDAR CA JOIN TWSS_CLOTHES CL ON CA.ID_CLOTHE = CL.ID " + 
			"WHERE CL.USERNAME = :username GROUP BY CL.ID) Q " + 
			"JOIN WSSCLOTHINGCXN1.TWSS_CLOTHES CL2 ON Q.ID = CL2.ID ORDER BY Q.TOTAL DESC " +
			"OFFSET 0 ROWS FETCH NEXT 5 ROWS ONLY")
	public abstract List<ClothigTopDTO> getMostUsedClothing(@Bind("username") String username);
	

	public List<StatisticsMapDTO> getUseTimesByMonth(String username,Integer id){
		return getUseTimesByMonth(username, id, "<=");
	}
	
	@RegisterMapper(StatisticsMapMapperJdbi.class)
	@SqlQuery("SELECT " + 
			"	   TO_CHAR(CL.DAY, 'mm') as KEY, count(*) as VALUE, '' as TOTAL " + 
			"	FROM " + 
			"	    TWSS_CALENDAR CL " + 
			"	WHERE " + 
			"	    CL.ID_CLOTHE = :id " + 
			"	    AND CL.USERNAME = :username " + 
			"	    AND TO_CHAR(CL.DAY, 'YYYY') = TO_CHAR(CURRENT_DATE, 'YYYY') " + 
			"	    AND CL.DAY <relationalOperator> sysdate " +
			"	group by TO_CHAR(CL.DAY, 'mm')")
	public abstract List<StatisticsMapDTO> getUseTimesByMonth(@Bind("username") String username, @Bind("id") Integer id, @Define("relationalOperator") String relationalOperator);
	
	
	public Integer getUseTimes(String username,Integer id){
		return getUseTimes(username, id, "<=");
	}
	
	@SqlQuery("SELECT " + 
			"   count(*) as TIMES " + 
			"FROM " + 
			"    TWSS_CALENDAR CL " + 
			"WHERE " + 
			"    CL.ID_CLOTHE = :id " + 
			"    AND CL.USERNAME = :username " + 
			"	 AND TRUNC(CL.DAY) <relationalOperator> TRUNC(sysdate) " +
			"group by CL.ID_CLOTHE")
	public abstract Integer getUseTimes(@Bind("username") String username, @Bind("id") Integer id, @Define("relationalOperator") String relationalOperator);
	
	public List<StatisticsMapDTO> getUseDates(String username,Integer id){
		return getUseDates(username, id, "<=");
	}
	
	@RegisterMapper(StatisticsMapMapperJdbi.class)
	@SqlQuery("SELECT " + 
			"   to_char(CL.DAY, 'YYYY-MM-DD') AS KEY, " + 
			"   TRUNC(sysdate)-TRUNC(CL.DAY) AS VALUE, " + 
			"   '' as TOTAL  " + 
			"FROM " + 
			"    TWSS_CALENDAR CL " + 
			"WHERE " + 
			"    CL.ID_CLOTHE = :id " + 
			"    AND CL.USERNAME = :username " + 
			"	 AND CL.DAY <relationalOperator> sysdate " +
			"ORDER BY CL.DAY DESC")
	public abstract List<StatisticsMapDTO> getUseDates(@Bind("username") String username, @Bind("id") Integer id, @Define("relationalOperator") String relationalOperator);
	
	public abstract void close();

}
package com.wossha.clothing.infrastructure.dao.statistics;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;
import org.springframework.stereotype.Repository;
import com.wossha.clothing.dto.StatisticsMapDTO;

@Repository
@UseStringTemplate3StatementLocator
public abstract class StatisticsDao {

	// SELECTS--------------------------------------------------------------------------------------------------------------------------------------

	@RegisterMapper(StatisticsMapMapperJdbi.class)
	@SqlQuery("SELECT " + 
			"    CL.TYPE KEY, " + 
			"    ROUND(( COUNT(*) / :total )*100,1) VALUE " + 
			"FROM " + 
			"TWSS_CLOTHES CL " + 
			"WHERE " + 
			"CL.USERNAME = :username " + 
			"GROUP BY CL.TYPE")
	public abstract List<StatisticsMapDTO> getTypePieData(@Bind("username") String username, @Bind("total") Integer total);

	

	public abstract void close();

}
package com.wossha.clothing.resources;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.wossha.clothing.dto.StatisticsDTO;
import com.wossha.clothing.infrastructure.repositories.StatisticsRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.wossha.msbase.controllers.ControllerWrapper;
import com.wossha.msbase.exceptions.BusinessException;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/statistics")
public class StatisticsController extends ControllerWrapper {

	/** Logger available to subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private StatisticsRepository statisticsRepo;

	
	@GetMapping(value = "/general-statistics")
	public @ResponseBody StatisticsDTO getGeneralStatistics() throws BusinessException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getPrincipal().toString();

		StatisticsDTO c = statisticsRepo.getTypePieData(username);
		return c;
	}

}

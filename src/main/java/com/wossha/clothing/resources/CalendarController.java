package com.wossha.clothing.resources;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wossha.clothing.dto.SearchCriteriaDTO;
import com.wossha.clothing.infrastructure.repositories.ClotheRepository;
import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.wossha.msbase.controllers.ControllerWrapper;
import com.wossha.msbase.exceptions.BusinessException;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/calendar")
public class CalendarController extends ControllerWrapper {

	/** Logger available to subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ClotheRepository repo;

	@PostMapping(value = "/search-clothing")
	public @ResponseBody Map<String, Object> searchClothing(@RequestBody SearchCriteriaDTO searchCriteria, @RequestParam("init") int init,
			@RequestParam("limit") int limit) throws BusinessException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getPrincipal().toString();

		Map<String, Object> c = repo.searchClothesByUser(username, searchCriteria, init, limit);
		return c;
	}

}

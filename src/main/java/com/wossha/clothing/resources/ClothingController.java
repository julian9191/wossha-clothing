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
import com.wossha.clothing.dto.BaseColorDTO;
import com.wossha.clothing.dto.BrandDTO;
import com.wossha.clothing.dto.ClotheDTO;
import com.wossha.clothing.dto.ClothingCategoryDTO;
import com.wossha.clothing.dto.ClothingTypeDTO;
import com.wossha.clothing.dto.SearchCriteriaDTO;
import com.wossha.clothing.dto.SearchCriteriaParamsDTO;
import com.wossha.clothing.infrastructure.repositories.CalendarRepository;
import com.wossha.clothing.infrastructure.repositories.ClotheRepository;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.wossha.msbase.controllers.ControllerWrapper;
import com.wossha.msbase.exceptions.BusinessException;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/clouthing")
public class ClothingController extends ControllerWrapper {

	/** Logger available to subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ClotheRepository repo;
	@Autowired
	private CalendarRepository calendarRepo;

	@GetMapping(value = "/clothes/{orderedBy}")
	public @ResponseBody Map<String, Object> getClothes(@PathVariable String orderedBy, @RequestParam("init") int init,
			@RequestParam("limit") int limit) throws BusinessException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getPrincipal().toString();

		if (!orderedBy.equals("NAME") && !orderedBy.equals("TYPE") && !orderedBy.equals("CATEGORY")
				&& !orderedBy.equals("BASE_COLOR")) {
			throw new BusinessException("Parámetro de ordenamiento no permitido");
		}

		Map<String, Object> c = repo.findClothesByUser(username, orderedBy, init, limit);
		return c;
	}

	@GetMapping(value = "/clothing-types")
	public @ResponseBody List<ClothingTypeDTO> getAllClothingType() {
		List<ClothingTypeDTO> c = repo.getAllClothingTypes();
		return c;
	}

	@GetMapping(value = "/clothing-categories")
	public @ResponseBody List<ClothingCategoryDTO> getAllClothingCategories() {
		List<ClothingCategoryDTO> c = repo.getAllClothingCategories();
		return c;
	}

	@GetMapping(value = "/base-colors")
	public @ResponseBody List<BaseColorDTO> getAllBaseColors() {
		List<BaseColorDTO> c = repo.getAllBaseColors();
		return c;
	}

	@GetMapping(value = "/colors-map")
	public @ResponseBody Map<String, Integer> getColorsMap() {
		Map<String, Integer> c = repo.getColorsMap();
		return c;
	}
	
	@GetMapping(value = "/clothe/{uuid}")
	public @ResponseBody ClotheDTO getClothe(@PathVariable String uuid) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getPrincipal().toString();

		ClotheDTO c = repo.findClotheByUuid(username, uuid);
		return c;
	}
	
	@PostMapping(value = "/outfit")
	public @ResponseBody List<ClotheDTO> getOutfit(@RequestBody SearchCriteriaDTO searchCriteria, @RequestParam("uuid") String uuid,
			@RequestParam("type") String type) throws BusinessException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getPrincipal().toString();

		List<ClotheDTO> c = repo.getOutfit(username, searchCriteria, uuid, type);
		return c;
	}
	

	// SEARCH----------------------------------------------------------------------------------------------------------

	@GetMapping(value = "/search-clouthing-type/{word}")
	public @ResponseBody List<ClothingTypeDTO> searchClothingTypes(@PathVariable String word) {
		List<ClothingTypeDTO> c = repo.searchClothingTypes(word);
		return c;
	}

	@GetMapping(value = "/search-clouthing-category/{word}")
	public @ResponseBody List<ClothingCategoryDTO> searchClothingCategories(@PathVariable String word) {
		List<ClothingCategoryDTO> c = repo.searchClothingCategories(word);
		return c;
	}

	@GetMapping(value = "/search-brand/{word}")
	public @ResponseBody List<BrandDTO> searchBrands(@PathVariable String word) {
		List<BrandDTO> c = repo.searchBrands(word);
		return c;
	}
	
	// SEARCH CRITERIA-------------------------------------------------------------------------------------------------------
	
	@GetMapping(value = "/search-criteria-params")
	public @ResponseBody SearchCriteriaParamsDTO getSearchCriteriaParamsByUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getPrincipal().toString();
		
		SearchCriteriaParamsDTO c = calendarRepo.getSearchCriteriaParamsByUser(username);
		return c;
	}

}

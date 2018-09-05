package com.wossha.clothing.resources;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.wossha.clothing.dto.ClothingCategoryDTO;
import com.wossha.clothing.dto.ClothingTypeDTO;
import com.wossha.clothing.infrastructure.repositories.ClotheRepository;
import java.util.List;
import com.wossha.msbase.controllers.ControllerWrapper;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/clouthing")
public class ClothingController extends ControllerWrapper{
	
	/** Logger available to subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private ClotheRepository repo;

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
	
	@GetMapping(value = "/search-clouthing-type/{word}")
	public @ResponseBody List<ClothingTypeDTO> searchClothingTypes(@PathVariable String word) {
		List<ClothingTypeDTO> c = repo.searchClothingTypes(word);
		return c;
	}
		
}

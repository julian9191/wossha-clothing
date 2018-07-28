package com.wossha.clothing.resources;

import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.wossha.clothing.dto.ClotheDTO;
import com.wossha.clothing.infrastructure.repositories.ClotheRepository;
import com.wossha.msbase.controllers.ControllerWrapper;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/clouthing")
public class ClothingController extends ControllerWrapper{
	
	/** Logger available to subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private ClotheRepository repo;

		@GetMapping(value = "/{username}")
		public @ResponseBody ClotheDTO getClotheByUuid(@PathVariable String uuid) {
			ClotheDTO c = repo.findClotheByUuid(uuid);
			return c;
		}
		
}

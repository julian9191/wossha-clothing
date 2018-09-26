package com.wossha.clothing.commands.createClothe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wossha.clothing.commands.createClothe.model.CreateClothe;
import com.wossha.clothing.infrastructure.repositories.ClotheRepository;
import com.wossha.msbase.controllers.commands.ICommand;
import com.wossha.msbase.exceptions.BusinessException;
import com.wossha.msbase.exceptions.TechnicalException;
import com.wossha.msbase.services.UUIDGenerator;

@Component
public class CreateClotheCommand implements ICommand<CreateClothe>{
	
	private CreateClothe data;
	private String user;
	
	@Autowired
	private ClotheRepository repo;
	
	@Override
	public String commandName() {
		return "CreateClothe";
	}
	
	@Override
	public CreateClothe data() {
		return this.data;
	}

	@Override
	public void setData(CreateClothe data) {
		this.data = data;
		
	}

	@Override
	public String execute() throws BusinessException, TechnicalException {
		try {
			data.getClothe().setType(data.getClothe().getType().toUpperCase());
			data.getClothe().setCategory(data.getClothe().getCategory().toUpperCase());
			data.getClothe().setBrand(data.getClothe().getBrand().toUpperCase());
			data.getClothe().setUuid(UUIDGenerator.generateUUID());
			//repo.add(data.getClothe());
			return "La prenda se ha creado correctamente";
		}catch (Exception e) {
			e.printStackTrace();
			throw new TechnicalException("Ha ocurrido un error al intentar clear la prenda");
		}
	}

	@Override
	public void setUser(String user) {
		this.user = user;
	}

}

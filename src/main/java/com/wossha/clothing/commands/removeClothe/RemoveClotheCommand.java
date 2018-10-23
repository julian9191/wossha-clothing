package com.wossha.clothing.commands.removeClothe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wossha.clothing.WosshaClothingApplication;
import com.wossha.clothing.commands.removeClothe.model.RemoveClothe;
import com.wossha.clothing.dto.ClotheDTO;
import com.wossha.clothing.infrastructure.mapper.MapperDozer;
import com.wossha.clothing.infrastructure.repositories.ClotheRepository;
import com.wossha.json.events.events.api.Event;
import com.wossha.json.events.events.pictures.SavePictureEvent.Message;
import com.wossha.json.events.events.pictures.SavePictureEvent.SavePictureEvent;
import com.wossha.json.events.services.UUIDGenerator;
import com.wossha.msbase.commands.CommandResult;
import com.wossha.msbase.commands.ICommand;
import com.wossha.msbase.enums.PictureTypesEnum;
import com.wossha.msbase.exceptions.BusinessException;
import com.wossha.msbase.exceptions.TechnicalException;

@Component
public class RemoveClotheCommand implements ICommand<RemoveClothe> {

	private RemoveClothe data;
	private String username;
	private MapperDozer map = new MapperDozer();

	@Autowired
	private ClotheRepository repo;

	@Override
	public String commandName() {
		return "CreateClothe";
	}

	@Override
	public RemoveClothe data() {
		return this.data;
	}

	@Override
	public void setData(RemoveClothe data) {
		this.data = data;
	}

	@Override
	public CommandResult execute() throws BusinessException, TechnicalException {
		CommandResult result = new CommandResult();
		
		repo.removeClothe(data.getUuid());
		result.setMessage("La prenda se ha eliminado correctamente");

		
		return result;
	}


	@Override
	public void setUsername(String username) {
		this.username = username;
	}

}

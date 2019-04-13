package com.wossha.clothing.commands.clothing.removeClothe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wossha.clothing.WosshaClothingApplication;
import com.wossha.clothing.commands.clothing.removeClothe.model.RemoveClothe;
import com.wossha.clothing.dto.ClotheDTO;
import com.wossha.clothing.infrastructure.mapper.MapperDozer;
import com.wossha.clothing.infrastructure.repositories.ClotheRepository;
import com.wossha.json.events.events.api.Event;
import com.wossha.json.events.events.pictures.RemovePictureEvent.RemovePictureEvent;
import com.wossha.json.events.events.pictures.RemovePictureEvent.Message;
import com.wossha.msbase.commands.CommandResult;
import com.wossha.msbase.commands.ICommand;
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
		ClotheDTO clothe = repo.findClotheByUuid(data.getUuid());
		
		if(clothe == null) {
			throw new BusinessException("la prenda a eliminar no existe");
		}
		
		Event savePictureEvent = generateRemovePictureEvent(clothe.getPicture());
		result.addEvent(savePictureEvent);
		repo.removeClothe(data.getUuid());
		
		result.setMessage("La prenda se ha eliminado correctamente");

		
		return result;
	}

	
	private RemovePictureEvent generateRemovePictureEvent(String uuidPicture) {
		List<String> uuidPictures = new ArrayList<>();
		uuidPictures.add(uuidPicture);
		Message message = new Message(uuidPictures);
		RemovePictureEvent event = new RemovePictureEvent(WosshaClothingApplication.APP_NAME, this.username, message);
		return event;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

}

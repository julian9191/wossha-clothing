package com.wossha.clothing.commands.calendar.addToCalendar;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wossha.clothing.commands.calendar.addToCalendar.model.AddToCalendar;
import com.wossha.clothing.dto.ClotheDTO;
import com.wossha.clothing.infrastructure.repositories.ClotheRepository;
import com.wossha.msbase.commands.CommandResult;
import com.wossha.msbase.commands.ICommand;
import com.wossha.msbase.exceptions.BusinessException;
import com.wossha.msbase.exceptions.TechnicalException;

@Component
public class AddToCalendarCommand implements ICommand<AddToCalendar> {

	private AddToCalendar data;
	private String username;

	@Autowired
	private ClotheRepository repo;

	@Override
	public String commandName() {
		return "AddToCalendar";
	}

	@Override
	public AddToCalendar data() {
		return this.data;
	}

	@Override
	public void setData(AddToCalendar data) {
		this.data = data;
	}

	@Override
	public CommandResult execute() throws BusinessException, TechnicalException {
		CommandResult result = new CommandResult();
		ClotheDTO clothe = repo.findClotheByDate(data.getUuidClothe(), data.getDay());
		
		if(clothe != null) {
			throw new BusinessException("la prenda ya fue agregada a la fecha seleccionada");
		}
		
		repo.addToCalendar(data.getUsername(), data.getDay(), data.getIdClothe(), data.getUuidClothe());
		result.setMessage("La prenda se añadido al calendario correctamente");

		return result;
	}

	
	@Override
	public void setUsername(String username) {
		this.username = username;
	}

}

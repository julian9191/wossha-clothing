package com.wossha.clothing.commands.calendar.AddDayDescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wossha.clothing.commands.calendar.AddDayDescription.model.AddDayDescription;
import com.wossha.clothing.infrastructure.repositories.ClotheRepository;
import com.wossha.msbase.commands.CommandResult;
import com.wossha.msbase.commands.ICommand;
import com.wossha.msbase.exceptions.BusinessException;
import com.wossha.msbase.exceptions.TechnicalException;

@Component
public class AddDayDescriptionCommand implements ICommand<AddDayDescription> {

	private AddDayDescription data;
	private String username;

	@Autowired
	private ClotheRepository repo;

	@Override
	public String commandName() {
		return "AddToCalendar";
	}

	@Override
	public AddDayDescription data() {
		return this.data;
	}

	@Override
	public void setData(AddDayDescription data) {
		this.data = data;
	}

	@Override
	public CommandResult execute() throws BusinessException, TechnicalException {
		CommandResult result = new CommandResult();
		String desc = repo.getDayDescription(data.getUsername(), data.getDay());
		
		if(desc == null) {
			repo.addDayDescription(data.getUsername(), data.getDay(), data.getDescription());
			result.setMessage("La descripción se añadido correctamente");
		}else {
			repo.editDayDescription(data.getUsername(), data.getDay(), data.getDescription());
			result.setMessage("La descripción se modificado correctamente");
		}
		
		
		return result;
	}

	
	@Override
	public void setUsername(String username) {
		this.username = username;
	}

}

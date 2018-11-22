package com.wossha.clothing.commands.calendar.addOutfitToCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wossha.clothing.commands.calendar.addOutfitToCalendar.model.AddOutfitToCalendar;
import com.wossha.clothing.commands.calendar.addOutfitToCalendar.model.Id;
import com.wossha.clothing.dto.ClotheDTO;
import com.wossha.clothing.infrastructure.repositories.CalendarRepository;
import com.wossha.msbase.commands.CommandResult;
import com.wossha.msbase.commands.ICommand;
import com.wossha.msbase.exceptions.BusinessException;
import com.wossha.msbase.exceptions.TechnicalException;

@Component
public class AddOutfitToCalendarCommand implements ICommand<AddOutfitToCalendar> {

	private AddOutfitToCalendar data;
	private String username;

	@Autowired
	private CalendarRepository repo;

	@Override
	public String commandName() {
		return "AddToCalendar";
	}

	@Override
	public AddOutfitToCalendar data() {
		return this.data;
	}

	@Override
	public void setData(AddOutfitToCalendar data) {
		this.data = data;
	}

	@Override
	public CommandResult execute() throws BusinessException, TechnicalException {
		CommandResult result = new CommandResult();
		
		int savedItems = 0;
		for (Id item : data.getUuids()) {
			
			ClotheDTO clothe = repo.findClotheByDate(item.getUuid(), data.getDay());
			if(clothe == null) {
				repo.addToCalendar(data.getUsername(), data.getDay(), item.getId(), item.getUuid());
				savedItems++;
			}

		}
		
		if(savedItems>0) {
			result.setMessage("Se ha añadido "+savedItems+" prenda"+(savedItems>1?"s":"")+" al calendario correctamente");
		}else {
			throw new BusinessException("las prendas ya fueron agregada a la fecha seleccionada");
		}
		

		return result;
	}

	
	@Override
	public void setUsername(String username) {
		this.username = username;
	}

}

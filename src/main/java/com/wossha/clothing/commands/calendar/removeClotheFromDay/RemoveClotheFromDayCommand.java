package com.wossha.clothing.commands.calendar.removeClotheFromDay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wossha.clothing.commands.calendar.removeClotheFromDay.model.RemoveClotheFromDay;
import com.wossha.clothing.dto.ClotheDTO;
import com.wossha.clothing.infrastructure.repositories.CalendarRepository;
import com.wossha.msbase.commands.CommandResult;
import com.wossha.msbase.commands.ICommand;
import com.wossha.msbase.exceptions.BusinessException;
import com.wossha.msbase.exceptions.TechnicalException;

@Component
public class RemoveClotheFromDayCommand implements ICommand<RemoveClotheFromDay> {

	private RemoveClotheFromDay data;
	private String username;

	@Autowired
	private CalendarRepository repo;

	@Override
	public String commandName() {
		return "AddToCalendar";
	}

	@Override
	public RemoveClotheFromDay data() {
		return this.data;
	}

	@Override
	public void setData(RemoveClotheFromDay data) {
		this.data = data;
	}

	@Override
	public CommandResult execute() throws BusinessException, TechnicalException {
		CommandResult result = new CommandResult();
		ClotheDTO clothe = repo.findClotheByDate(data.getUuidClothe(), data.getDay());
		
		if(clothe == null) {
			throw new BusinessException("la prenda a eliminar no existe");
		}
		
		repo.removeClotheFromDay(data.getUsername(), data.getDay(), data.getUuidClothe());
		
		result.setMessage("La prenda se ha removido de la fecha correctamente");
		
		return result;
	}

	
	@Override
	public void setUsername(String username) {
		this.username = username;
	}

}

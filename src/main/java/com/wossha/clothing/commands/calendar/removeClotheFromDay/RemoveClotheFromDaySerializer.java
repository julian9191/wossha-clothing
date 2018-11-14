package com.wossha.clothing.commands.calendar.removeClotheFromDay;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wossha.clothing.commands.calendar.addToCalendar.model.AddToCalendar;
import com.wossha.clothing.commands.calendar.removeClotheFromDay.model.RemoveClotheFromDay;
import com.wossha.msbase.commands.ICommand;
import com.wossha.msbase.commands.ICommandSerializer;

@Component
public class RemoveClotheFromDaySerializer implements ICommandSerializer {
	
	private ObjectMapper m = new ObjectMapper();
	
	@Autowired
	private RemoveClotheFromDayCommand command;
	
	@Override
	public ICommand<RemoveClotheFromDay> deserialize(String json) throws IOException {
		RemoveClotheFromDay dto = m.readValue(json, RemoveClotheFromDay.class);
        command.setData(dto);
        return command;
	}

}

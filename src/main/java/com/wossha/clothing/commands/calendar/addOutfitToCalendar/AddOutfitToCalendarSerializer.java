package com.wossha.clothing.commands.calendar.addOutfitToCalendar;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wossha.clothing.commands.calendar.addOutfitToCalendar.model.AddOutfitToCalendar;
import com.wossha.msbase.commands.ICommand;
import com.wossha.msbase.commands.ICommandSerializer;

@Component
public class AddOutfitToCalendarSerializer implements ICommandSerializer {
	
	private ObjectMapper m = new ObjectMapper();
	
	@Autowired
	private AddOutfitToCalendarCommand command;
	
	@Override
	public ICommand<AddOutfitToCalendar> deserialize(String json) throws IOException {
		AddOutfitToCalendar dto = m.readValue(json, AddOutfitToCalendar.class);
        command.setData(dto);
        return command;
	}

}

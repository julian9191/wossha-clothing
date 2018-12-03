package com.wossha.clothing.commands.calendar.addToCalendar;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wossha.clothing.commands.calendar.addToCalendar.model.AddToCalendar;
import com.wossha.msbase.commands.ICommand;
import com.wossha.msbase.commands.ICommandSerializer;

@Component
public class AddToCalendarSerializer implements ICommandSerializer {
	
	@Autowired
	private ObjectMapper m;
	
	@Autowired
	private AddToCalendarCommand command;
	
	@Override
	public ICommand<AddToCalendar> deserialize(String json) throws IOException {
		AddToCalendar dto = m.readValue(json, AddToCalendar.class);
        command.setData(dto);
        return command;
	}

}

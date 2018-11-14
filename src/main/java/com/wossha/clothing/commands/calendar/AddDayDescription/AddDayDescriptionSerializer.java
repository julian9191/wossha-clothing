package com.wossha.clothing.commands.calendar.AddDayDescription;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wossha.clothing.commands.calendar.AddDayDescription.model.AddDayDescription;
import com.wossha.msbase.commands.ICommand;
import com.wossha.msbase.commands.ICommandSerializer;

@Component
public class AddDayDescriptionSerializer implements ICommandSerializer {
	
	private ObjectMapper m = new ObjectMapper();
	
	@Autowired
	private AddDayDescriptionCommand command;
	
	@Override
	public ICommand<AddDayDescription> deserialize(String json) throws IOException {
		AddDayDescription dto = m.readValue(json, AddDayDescription.class);
        command.setData(dto);
        return command;
	}

}

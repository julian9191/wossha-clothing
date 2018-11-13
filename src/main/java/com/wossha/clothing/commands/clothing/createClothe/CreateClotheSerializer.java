package com.wossha.clothing.commands.clothing.createClothe;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wossha.clothing.commands.clothing.createClothe.model.CreateClothe;
import com.wossha.msbase.commands.ICommand;
import com.wossha.msbase.commands.ICommandSerializer;

@Component
public class CreateClotheSerializer implements ICommandSerializer {
	
	private ObjectMapper m = new ObjectMapper();
	
	@Autowired
	private CreateClotheCommand command;
	
	@Override
	public ICommand<CreateClothe> deserialize(String json) throws IOException {
		CreateClothe dto = m.readValue(json, CreateClothe.class);
        command.setData(dto);
        return command;
	}

}

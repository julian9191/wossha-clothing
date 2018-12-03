package com.wossha.clothing.commands.clothing.removeClothe;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wossha.clothing.commands.clothing.removeClothe.model.RemoveClothe;
import com.wossha.msbase.commands.ICommand;
import com.wossha.msbase.commands.ICommandSerializer;

@Component
public class RemoveClotheSerializer implements ICommandSerializer {
	
	@Autowired
	private ObjectMapper m;
	
	@Autowired
	private RemoveClotheCommand command;
	
	@Override
	public ICommand<RemoveClothe> deserialize(String json) throws IOException {
		RemoveClothe dto = m.readValue(json, RemoveClothe.class);
        command.setData(dto);
        return command;
	}

}

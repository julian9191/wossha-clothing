package com.wossha.clothing.commands.clothing.editClothe;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wossha.clothing.commands.clothing.editClothe.model.EditClothe;
import com.wossha.msbase.commands.ICommand;
import com.wossha.msbase.commands.ICommandSerializer;

@Component
public class EditClotheSerializer implements ICommandSerializer {
	
	private ObjectMapper m = new ObjectMapper();
	
	@Autowired
	private EditClotheCommand command;
	
	@Override
	public ICommand<EditClothe> deserialize(String json) throws IOException {
		EditClothe dto = m.readValue(json, EditClothe.class);
        command.setData(dto);
        return command;
	}

}

package com.wossha.clothing.commands;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wossha.clothing.commands.createClothe.CreateClotheSerializer;
import com.wossha.msbase.controllers.commands.ICommandSerializer;

@Service
public class CommandSerializers {

    private final Map<String, ICommandSerializer> processors = new HashMap<>();
    
    //serializers
    @Autowired
    private CreateClotheSerializer createClotheSerializer;

	public void initMapper() {
        processors.put("CreateClothe", createClotheSerializer);
    }

    public ICommandSerializer get(String commandName) {
        return processors.get(commandName);
    }
    
    public void setModifyUserSerializer(CreateClotheSerializer createClotheSerializer) {
		this.createClotheSerializer = createClotheSerializer;
	}
}

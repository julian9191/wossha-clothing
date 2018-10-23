package com.wossha.clothing.commands;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wossha.clothing.commands.createClothe.CreateClotheSerializer;
import com.wossha.clothing.commands.editClothe.EditClotheSerializer;
import com.wossha.clothing.commands.removeClothe.RemoveClotheSerializer;
import com.wossha.msbase.commands.ICommandSerializer;

@Service
public class CommandSerializers {

    private final Map<String, ICommandSerializer> processors = new HashMap<>();
    
    //serializers
    private CreateClotheSerializer createClotheSerializer;
    private EditClotheSerializer editClotheSerializer;
    private RemoveClotheSerializer removeClotheSerializer;

	public void initMapper() {
        processors.put("CreateClothe", createClotheSerializer);
        processors.put("EditClothe", editClotheSerializer);
        processors.put("RemoveClothe", removeClotheSerializer);
    }

    public ICommandSerializer get(String commandName) {
        return processors.get(commandName);
    }
    
    public void setCreateClotheSerializerr(CreateClotheSerializer createClotheSerializer) {
		this.createClotheSerializer = createClotheSerializer;
	}
    
    public void setEditClotheSerializer(EditClotheSerializer editClotheSerializer) {
		this.editClotheSerializer = editClotheSerializer;
	}

	public void setRemoveClotheSerializer(RemoveClotheSerializer removeClotheSerializer) {
		this.removeClotheSerializer = removeClotheSerializer;
		
	}
}

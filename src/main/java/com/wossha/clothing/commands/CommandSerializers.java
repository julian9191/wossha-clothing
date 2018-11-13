package com.wossha.clothing.commands;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.wossha.clothing.commands.calendar.addToCalendar.AddToCalendarSerializer;
import com.wossha.clothing.commands.clothing.createClothe.CreateClotheSerializer;
import com.wossha.clothing.commands.clothing.editClothe.EditClotheSerializer;
import com.wossha.clothing.commands.clothing.removeClothe.RemoveClotheSerializer;
import com.wossha.msbase.commands.ICommandSerializer;

@Service
public class CommandSerializers {

    private final Map<String, ICommandSerializer> processors = new HashMap<>();
    
    //serializers
    private CreateClotheSerializer createClotheSerializer;
    private EditClotheSerializer editClotheSerializer;
    private RemoveClotheSerializer removeClotheSerializer;
    private AddToCalendarSerializer addToCalendarSerializer;

	public void initMapper() {
        processors.put("CreateClothe", createClotheSerializer);
        processors.put("EditClothe", editClotheSerializer);
        processors.put("RemoveClothe", removeClotheSerializer);
        processors.put("AddToCalendar", addToCalendarSerializer);
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

	public void setAddToCalendarSerializer(AddToCalendarSerializer addToCalendarSerializer) {
		this.addToCalendarSerializer = addToCalendarSerializer;
	}
	
}

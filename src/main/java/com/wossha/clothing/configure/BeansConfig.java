package com.wossha.clothing.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wossha.clothing.commands.CommandSerializers;
import com.wossha.clothing.commands.calendar.AddDayDescription.AddDayDescriptionCommand;
import com.wossha.clothing.commands.calendar.AddDayDescription.AddDayDescriptionSerializer;
import com.wossha.clothing.commands.calendar.addToCalendar.AddToCalendarCommand;
import com.wossha.clothing.commands.calendar.addToCalendar.AddToCalendarSerializer;
import com.wossha.clothing.commands.clothing.createClothe.CreateClotheCommand;
import com.wossha.clothing.commands.clothing.createClothe.CreateClotheSerializer;
import com.wossha.clothing.commands.clothing.editClothe.EditClotheCommand;
import com.wossha.clothing.commands.clothing.editClothe.EditClotheSerializer;
import com.wossha.clothing.commands.clothing.removeClothe.RemoveClotheCommand;
import com.wossha.clothing.commands.clothing.removeClothe.RemoveClotheSerializer;
import com.wossha.clothing.infrastructure.repositories.ClotheRepository;
import com.wossha.clothing.infrastructure.jms.EventSerializers;

@Configuration
public class BeansConfig {
	
	@Bean
	public ClotheRepository clotheRpository() {
			return new ClotheRepository();
	}

	//commands--------------------------------------------------
	@Bean
	public CreateClotheCommand createClotheCommand() {
		return new CreateClotheCommand();
	}
	
	@Bean
	public EditClotheCommand editClotheCommand() {
		return new EditClotheCommand();
	}
	
	@Bean
	public RemoveClotheCommand removeClotheCommand() {
		return new RemoveClotheCommand();
	}
	
	@Bean
	public AddToCalendarCommand addToCalendarCommand() {
		return new AddToCalendarCommand();
	}
	
	@Bean
	public AddDayDescriptionCommand addDayDescriptionCommand() {
		return new AddDayDescriptionCommand();
	}
	
	//serializers--------------------------------------------------
	@Bean
	public CreateClotheSerializer createClotheSerializer() {
		return new CreateClotheSerializer();
	}
	
	@Bean
	public EditClotheSerializer editClotheSerializer() {
		return new EditClotheSerializer();
	}
	
	@Bean
	public RemoveClotheSerializer removeClotheSerializer() {
		return new RemoveClotheSerializer();
	}
	
	@Bean
	public AddToCalendarSerializer addToCalendarSerializer() {
		return new AddToCalendarSerializer();
	}
	
	@Bean
	public AddDayDescriptionSerializer addDayDescriptionSerializer() {
		return new AddDayDescriptionSerializer();
	}
	
	
	//--------------------------------------------------------------
	
	@Bean
	public CommandSerializers commandSerializers() {
		CommandSerializers cs = new CommandSerializers();
		cs.setCreateClotheSerializerr(createClotheSerializer());
		cs.setEditClotheSerializer(editClotheSerializer());
		cs.setRemoveClotheSerializer(removeClotheSerializer());
		cs.setAddToCalendarSerializer(addToCalendarSerializer());
		cs.setAddDayDescription(addDayDescriptionSerializer());
		cs.initMapper();
		return cs;
	}
	
	@Bean
	public EventSerializers eventSerializers() {
		EventSerializers es = new EventSerializers();
		//es.setSavePictureEventSerializer(savePictureEventSerializer());
		es.initMapper();
		return es;
	}
	
}

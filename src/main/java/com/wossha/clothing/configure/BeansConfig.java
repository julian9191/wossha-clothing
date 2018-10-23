package com.wossha.clothing.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wossha.clothing.commands.CommandSerializers;
import com.wossha.clothing.commands.createClothe.CreateClotheCommand;
import com.wossha.clothing.commands.createClothe.CreateClotheSerializer;
import com.wossha.clothing.commands.editClothe.EditClotheCommand;
import com.wossha.clothing.commands.editClothe.EditClotheSerializer;
import com.wossha.clothing.commands.removeClothe.RemoveClotheCommand;
import com.wossha.clothing.commands.removeClothe.RemoveClotheSerializer;
import com.wossha.clothing.infrastructure.repositories.ClotheRepository;
import com.wossha.clothing.infrastructure.jms.EventSerializers;

@Configuration
public class BeansConfig {
	
	@Bean
	public ClotheRepository userRpository() {
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
	
	
	
	//--------------------------------------------------------------
	
	@Bean
	public CommandSerializers commandSerializers() {
		CommandSerializers cs = new CommandSerializers();
		cs.setCreateClotheSerializerr(createClotheSerializer());
		cs.setEditClotheSerializer(editClotheSerializer());
		cs.setRemoveClotheSerializer(removeClotheSerializer());
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

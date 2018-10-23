package com.wossha.clothing.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wossha.clothing.commands.CommandSerializers;
import com.wossha.clothing.commands.createClothe.CreateClotheCommand;
import com.wossha.clothing.commands.createClothe.CreateClotheSerializer;
import com.wossha.clothing.commands.editClothe.EditClotheCommand;
import com.wossha.clothing.commands.editClothe.EditClotheSerializer;
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
	public CommandSerializers commandSerializers() {
		CommandSerializers cs = new CommandSerializers();
		cs.setCreateClotheSerializerr(createClotheSerializer());
		cs.setEditClotheSerializer(editClotheSerializer());
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

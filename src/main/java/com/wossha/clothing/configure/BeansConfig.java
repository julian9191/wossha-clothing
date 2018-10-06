package com.wossha.clothing.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wossha.clothing.commands.CommandSerializers;
import com.wossha.clothing.commands.createClothe.CreateClotheCommand;
import com.wossha.clothing.commands.createClothe.CreateClotheSerializer;
import com.wossha.clothing.infrastructure.repositories.ClotheRepository;
import com.wossha.clothing.infrastructure.jms.EventSerializers;

@Configuration
public class BeansConfig {
	
	@Bean
	public ClotheRepository userRpository() {
			return new ClotheRepository();
	}


	@Bean
	public CreateClotheCommand createClotheCommand() {
		return new CreateClotheCommand();
	}
	
	@Bean
	public CreateClotheSerializer createClotheSerializer() {
		return new CreateClotheSerializer();
	}
	
	@Bean
	public CommandSerializers commandSerializers() {
		CommandSerializers cs = new CommandSerializers();
		cs.setModifyUserSerializer(createClotheSerializer());
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

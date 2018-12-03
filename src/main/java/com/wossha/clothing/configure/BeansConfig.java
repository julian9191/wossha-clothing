package com.wossha.clothing.configure;

import java.util.TimeZone;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wossha.clothing.commands.CommandSerializers;
import com.wossha.clothing.commands.calendar.AddDayDescription.AddDayDescriptionCommand;
import com.wossha.clothing.commands.calendar.AddDayDescription.AddDayDescriptionSerializer;
import com.wossha.clothing.commands.calendar.addOutfitToCalendar.AddOutfitToCalendarCommand;
import com.wossha.clothing.commands.calendar.addOutfitToCalendar.AddOutfitToCalendarSerializer;
import com.wossha.clothing.commands.calendar.addToCalendar.AddToCalendarCommand;
import com.wossha.clothing.commands.calendar.addToCalendar.AddToCalendarSerializer;
import com.wossha.clothing.commands.calendar.removeClotheFromDay.RemoveClotheFromDayCommand;
import com.wossha.clothing.commands.calendar.removeClotheFromDay.RemoveClotheFromDaySerializer;
import com.wossha.clothing.commands.clothing.createClothe.CreateClotheCommand;
import com.wossha.clothing.commands.clothing.createClothe.CreateClotheSerializer;
import com.wossha.clothing.commands.clothing.editClothe.EditClotheCommand;
import com.wossha.clothing.commands.clothing.editClothe.EditClotheSerializer;
import com.wossha.clothing.commands.clothing.removeClothe.RemoveClotheCommand;
import com.wossha.clothing.commands.clothing.removeClothe.RemoveClotheSerializer;
import com.wossha.clothing.infrastructure.repositories.CalendarRepository;
import com.wossha.clothing.infrastructure.repositories.ClotheRepository;
import com.wossha.clothing.infrastructure.repositories.StatisticsRepository;
import com.wossha.clothing.infrastructure.jms.EventSerializers;

@Configuration
public class BeansConfig {
	
	@Bean
	public ClotheRepository clotheRpository() {
			return new ClotheRepository();
	}
	
	@Bean
	public CalendarRepository calendarRepository() {
			return new CalendarRepository();
	}
	
	@Bean
	public StatisticsRepository statisticsRepository() {
			return new StatisticsRepository();
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
	
	@Bean
	public RemoveClotheFromDayCommand removeClotheFromDayCommand() {
		return new RemoveClotheFromDayCommand();
	}
	
	@Bean
	public AddOutfitToCalendarCommand addOutfitToCalendarCommand() {
		return new AddOutfitToCalendarCommand();
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
	
	@Bean
	public RemoveClotheFromDaySerializer removeClotheFromDaySerializer() {
		return new RemoveClotheFromDaySerializer();
	}
	
	@Bean
	public AddOutfitToCalendarSerializer addOutfitToCalendarSerializer() {
		return new AddOutfitToCalendarSerializer();
	}
	
	
	//--------------------------------------------------------------
	
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		TimeZone tz = TimeZone.getDefault();
		objectMapper.setTimeZone(tz);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper;
	}
	
	@Bean
	public CommandSerializers commandSerializers() {
		CommandSerializers cs = new CommandSerializers();
		cs.setCreateClotheSerializerr(createClotheSerializer());
		cs.setEditClotheSerializer(editClotheSerializer());
		cs.setRemoveClotheSerializer(removeClotheSerializer());
		cs.setAddToCalendarSerializer(addToCalendarSerializer());
		cs.setAddDayDescription(addDayDescriptionSerializer());
		cs.setRemoveClotheFromDaySerializer(removeClotheFromDaySerializer());
		cs.setAddOutfitToCalendarSerializer(addOutfitToCalendarSerializer());
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
	
	@Bean
	public Jackson2ObjectMapperBuilderCustomizer init() {
	    return new Jackson2ObjectMapperBuilderCustomizer() {

	    	@Override
	        public void customize(Jackson2ObjectMapperBuilder builder) {
	            builder.timeZone(TimeZone.getDefault());
	        }
	    };
	}
	
}

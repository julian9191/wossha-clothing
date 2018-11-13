package com.wossha.clothing.commands.calendar.addToCalendar.model;

import java.sql.Timestamp;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AddToCalendar {

	private String commandName;
	private String username;
	
	// Formats output date when this DTO is passed through JSON
    @JsonFormat(pattern = "yyyy-MM-dd")
    // Allows yyyy-MM-dd date to be passed into GET request in JSON
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Timestamp day;
    
	private Integer idClothe;
	private String uuidClothe;
	
	public AddToCalendar(String commandName, String username, Timestamp day, Integer idClothe, String uuidClothe) {
		this.commandName = commandName;
		this.username = username;
		this.day = day;
		this.idClothe = idClothe;
		this.uuidClothe = uuidClothe;
	}

	public AddToCalendar() {}

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getDay() {
		return day;
	}

	public void setDay(Timestamp day) {
		this.day = day;
	}

	public Integer getIdClothe() {
		return idClothe;
	}

	public void setIdClothe(Integer idClothe) {
		this.idClothe = idClothe;
	}

	public String getUuidClothe() {
		return uuidClothe;
	}

	public void setUuidClothe(String uuidClothe) {
		this.uuidClothe = uuidClothe;
	}

	
}

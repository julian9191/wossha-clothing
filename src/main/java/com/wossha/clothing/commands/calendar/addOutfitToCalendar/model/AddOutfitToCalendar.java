package com.wossha.clothing.commands.calendar.addOutfitToCalendar.model;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AddOutfitToCalendar {

	private String commandName;
	private String username;
	
	// Formats output date when this DTO is passed through JSON
    @JsonFormat(pattern = "yyyy-MM-dd")
    // Allows yyyy-MM-dd date to be passed into GET request in JSON
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Timestamp day;
    
	private List<Id> uuids;
	
	public AddOutfitToCalendar(String commandName, String username, Timestamp day, List<Id> uuids) {
		this.commandName = commandName;
		this.username = username;
		this.day = day;
		this.uuids = uuids;
	}

	public AddOutfitToCalendar() {}

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

	public List<Id> getUuids() {
		return uuids;
	}

	public void setUuids(List<Id> uuids) {
		this.uuids = uuids;
	}
	
}

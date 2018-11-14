package com.wossha.clothing.commands.calendar.AddDayDescription.model;

import java.sql.Timestamp;

public class AddDayDescription {
	
	private String commandName;
	private String username;
	private Timestamp day;
	private String description;
	
	public AddDayDescription(String commandName, String username, Timestamp day, String description) {
		this.commandName = commandName;
		this.username = username;
		this.day = day;
		this.description = description;
	}

	public AddDayDescription() {}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

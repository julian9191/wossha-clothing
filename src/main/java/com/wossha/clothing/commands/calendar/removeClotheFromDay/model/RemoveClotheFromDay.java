package com.wossha.clothing.commands.calendar.removeClotheFromDay.model;

import java.sql.Timestamp;

public class RemoveClotheFromDay {
	private String commandName;
	private String username;
	private Timestamp day;
	private String uuidClothe;

	public RemoveClotheFromDay(String commandName, String username, Timestamp day, String uuidClothe) {
		this.commandName = commandName;
		this.username = username;
		this.day = day;
		this.uuidClothe = uuidClothe;
	}
	
	public RemoveClotheFromDay() {}

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

	public String getUuidClothe() {
		return uuidClothe;
	}

	public void setUuidClothe(String uuidClothe) {
		this.uuidClothe = uuidClothe;
	}

}

package com.wossha.clothing.commands.clothing.removeClothe.model;

public class RemoveClothe {

	private String commandName;
	private String username;
	private String uuid;

	public RemoveClothe(String commandName, String username, String uuid) {
		this.commandName = commandName;
		this.username = username;
		this.uuid = uuid;
	}

	public RemoveClothe() {}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

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
	
}

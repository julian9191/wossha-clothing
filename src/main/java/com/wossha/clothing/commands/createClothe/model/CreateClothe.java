package com.wossha.clothing.commands.createClothe.model;

import com.wossha.clothing.dto.ClotheDTO;
import com.wossha.msbase.controllers.commands.CommandModel;

public class CreateClothe extends CommandModel{
	private String commandName;
    private String username;
    private ClotheDTO clothe;
    
	
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
	public ClotheDTO getClothe() {
		return clothe;
	}
	public void setClothe(ClotheDTO clothe) {
		this.clothe = clothe;
	}

}

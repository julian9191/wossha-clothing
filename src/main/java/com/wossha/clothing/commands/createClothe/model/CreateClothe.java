package com.wossha.clothing.commands.createClothe.model;

import com.wossha.msbase.commands.CommandModel;

public class CreateClothe extends CommandModel{
    private Clothe clothe;
    
	public Clothe getClothe() {
		return clothe;
	}
	public void setClothe(Clothe clothe) {
		this.clothe = clothe;
	}

}

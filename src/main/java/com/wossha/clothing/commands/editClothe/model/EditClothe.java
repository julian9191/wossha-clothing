package com.wossha.clothing.commands.editClothe.model;

import com.wossha.clothing.commands.createClothe.model.Clothe;
import com.wossha.msbase.commands.CommandModel;

public class EditClothe extends CommandModel{
    private Clothe clothe;
    
	public Clothe getClothe() {
		return clothe;
	}
	public void setClothe(Clothe clothe) {
		this.clothe = clothe;
	}

}

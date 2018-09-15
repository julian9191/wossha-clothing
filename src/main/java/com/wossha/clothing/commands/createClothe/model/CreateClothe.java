package com.wossha.clothing.commands.createClothe.model;

import com.wossha.clothing.dto.ClotheDTO;
import com.wossha.msbase.controllers.commands.CommandModel;

public class CreateClothe extends CommandModel{
    private ClotheDTO clothe;
    
	public ClotheDTO getClothe() {
		return clothe;
	}
	public void setClothe(ClotheDTO clothe) {
		this.clothe = clothe;
	}

}

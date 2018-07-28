package com.wossha.clothing.infrastructure.enums;

public enum StatesEnum {
	USER("USER"), 
	ADMIN("ADMIN");

	private String description;

	StatesEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
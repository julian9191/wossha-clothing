package com.wossha.clothing.commands.calendar.addOutfitToCalendar.model;

public class Id {
	String uuid;
	Integer id;
	
	public Id(String uuid, Integer id) {
		this.uuid = uuid;
		this.id = id;
	}
	
	public Id() {}
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}

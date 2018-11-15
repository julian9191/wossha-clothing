package com.wossha.clothing.dto;

import java.sql.Timestamp;

public class CalendarClotheDTO {
	private String title;
	private Timestamp start;
	private String backgroundColor;
	private boolean allDay;
	private String imageurl;
	private String description;
	
	public CalendarClotheDTO(String title, Timestamp start, String backgroundColor, boolean allDay, String imageurl,
			String description) {
		this.title = title;
		this.start = start;
		this.backgroundColor = backgroundColor;
		this.allDay = allDay;
		this.imageurl = imageurl;
		this.description = description;
	}

	public CalendarClotheDTO() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getStart() {
		return start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

package com.wossha.clothing.dto;

import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CalendarClotheDTO {
	private String title;
	
	// Formats output date when this DTO is passed through JSON
    @JsonFormat(pattern = "yyyy-MM-dd")
    // Allows yyyy-MM-dd date to be passed into GET request in JSON
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

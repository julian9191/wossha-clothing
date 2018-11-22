package com.wossha.clothing.dto;

public class StatisticsMapDTO {
	
	private String key;
	private String value;
	
	public StatisticsMapDTO(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public StatisticsMapDTO() {}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

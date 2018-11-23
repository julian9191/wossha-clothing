package com.wossha.clothing.dto;

public class StatisticsMapDTO {
	
	private String key;
	private String value;
	private String total;
	
	public StatisticsMapDTO(String key, String value, String total) {
		this.key = key;
		this.value = value;
		this.total = total;
	}
	
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

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
	
}

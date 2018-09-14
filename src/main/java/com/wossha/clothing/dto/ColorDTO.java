package com.wossha.clothing.dto;

public class ColorDTO {
	private Integer id;
	private String hexa;
	private Integer baseColor;
	
	public ColorDTO(Integer id, String hexa, Integer baseColor) {
		this.id = id;
		this.hexa = hexa;
		this.baseColor = baseColor;
	}
	
	public ColorDTO() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHexa() {
		return hexa;
	}

	public void setHexa(String hexa) {
		this.hexa = hexa;
	}

	public Integer getBaseColor() {
		return baseColor;
	}

	public void setBaseColor(Integer baseColor) {
		this.baseColor = baseColor;
	}

}

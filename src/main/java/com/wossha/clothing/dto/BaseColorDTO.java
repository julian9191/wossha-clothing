package com.wossha.clothing.dto;

public class BaseColorDTO {
	private Integer id;
	private String name;
	private String hexa;
	
	public BaseColorDTO(Integer id, String name, String hexa) {
		this.id = id;
		this.name = name;
		this.hexa = hexa;
	}
	
	public BaseColorDTO(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public BaseColorDTO() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHexa() {
		return hexa;
	}

	public void setHexa(String hexa) {
		this.hexa = hexa;
	}

}

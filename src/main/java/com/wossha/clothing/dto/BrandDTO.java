package com.wossha.clothing.dto;

public class BrandDTO {
	
	private Integer id;
	private String name;
	
	public BrandDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public BrandDTO() {}

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
	
}

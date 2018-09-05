package com.wossha.clothing.dto;

public class ClothingTypeDTO {
	private Integer id;
	private String name;
	
	public ClothingTypeDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public ClothingTypeDTO() {}

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

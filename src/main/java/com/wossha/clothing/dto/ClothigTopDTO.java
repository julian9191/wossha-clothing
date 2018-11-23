package com.wossha.clothing.dto;

public class ClothigTopDTO {

	private Integer id;
	private String uuid;
	private String name;
	private String type;
	private String picture;
	private Integer total;

	public ClothigTopDTO(Integer id, String uuid, String name, String type, String picture, Integer total) {
		this.id = id;
		this.uuid = uuid;
		this.name = name;
		this.type = type;
		this.picture = picture;
		this.total = total;
	}

	public ClothigTopDTO() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}


}

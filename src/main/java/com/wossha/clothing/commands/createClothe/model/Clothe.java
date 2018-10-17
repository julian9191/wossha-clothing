package com.wossha.clothing.commands.createClothe.model;

import java.sql.Timestamp;

import com.wossha.msbase.models.PictureFileDTO;

public class Clothe {
	
	private Integer id;
	private String uuid;
	private String username;
	private String name;
	private String description;
	private String type;
	private String category;
	private Timestamp purchaseDate;
	private Integer howLike;
	private String brand;
	private Integer state;
	private String colorCode;
	private Integer baseColor;
	private PictureFileDTO picture;
	
	
	public Clothe(Integer id, String uuid, String username, String name, String description, String type,
			String category, Timestamp purchaseDate, Integer howLike, String brand, Integer state, String colorCode,
			Integer baseColor) {
		
		this.id = id;
		this.uuid = uuid;
		this.username = username;
		this.name = name;
		this.description = description;
		this.type = type;
		this.category = category;
		this.purchaseDate = purchaseDate;
		this.howLike = howLike;
		this.brand = brand;
		this.state = state;
		this.colorCode = colorCode;
		this.baseColor = baseColor;
	}
	
	public Clothe(Integer id, String uuid, String username, String name, String description, String type,
			String category, Timestamp purchaseDate, Integer howLike, String brand, Integer state, String colorCode,
			Integer baseColor, PictureFileDTO picture) {
		
		this.id = id;
		this.uuid = uuid;
		this.username = username;
		this.name = name;
		this.description = description;
		this.type = type;
		this.category = category;
		this.purchaseDate = purchaseDate;
		this.howLike = howLike;
		this.brand = brand;
		this.state = state;
		this.colorCode = colorCode;
		this.baseColor = baseColor;
		this.picture = picture;
	}

	public Clothe() {}

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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Timestamp getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public Integer getHowLike() {
		return howLike;
	}


	public void setHowLike(Integer howLike) {
		this.howLike = howLike;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public Integer getState() {
		return state;
	}


	public void setState(Integer state) {
		this.state = state;
	}


	public String getColorCode() {
		return colorCode;
	}


	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}


	public Integer getBaseColor() {
		return baseColor;
	}


	public void setBaseColor(Integer baseColor) {
		this.baseColor = baseColor;
	}

	public PictureFileDTO getPicture() {
		return picture;
	}

	public void setPicture(PictureFileDTO picture) {
		this.picture = picture;
	}
	
	

}

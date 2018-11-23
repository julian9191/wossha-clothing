package com.wossha.clothing.dto;

import java.util.List;

public class StatisticsDTO {

	private Integer total;
	private List<StatisticsMapDTO> types;
	private List<StatisticsMapDTO> categories;
	private List<StatisticsMapDTO> howLike;
	private List<StatisticsMapDTO> brands;
	private List<StatisticsMapDTO> colors;
	private List<ClothigTopDTO> mostUsedClothing;

	public StatisticsDTO(Integer total, List<StatisticsMapDTO> types, List<StatisticsMapDTO> categories,
			List<StatisticsMapDTO> howLike, List<StatisticsMapDTO> brands, List<StatisticsMapDTO> colors,
			List<ClothigTopDTO> mostUsedClothing) {
		this.total = total;
		this.types = types;
		this.categories = categories;
		this.howLike = howLike;
		this.brands = brands;
		this.colors = colors;
		this.mostUsedClothing = mostUsedClothing;
	}

	public StatisticsDTO() {
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<StatisticsMapDTO> getTypes() {
		return types;
	}

	public void setTypes(List<StatisticsMapDTO> types) {
		this.types = types;
	}

	public List<StatisticsMapDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<StatisticsMapDTO> categories) {
		this.categories = categories;
	}

	public List<StatisticsMapDTO> getHowLike() {
		return howLike;
	}

	public void setHowLike(List<StatisticsMapDTO> howLike) {
		this.howLike = howLike;
	}

	public List<StatisticsMapDTO> getBrands() {
		return brands;
	}

	public void setBrands(List<StatisticsMapDTO> brands) {
		this.brands = brands;
	}

	public List<StatisticsMapDTO> getColors() {
		return colors;
	}

	public void setColors(List<StatisticsMapDTO> colors) {
		this.colors = colors;
	}

	public List<ClothigTopDTO> getMostUsedClothing() {
		return mostUsedClothing;
	}

	public void setMostUsedClothing(List<ClothigTopDTO> mostUsedClothing) {
		this.mostUsedClothing = mostUsedClothing;
	}

}

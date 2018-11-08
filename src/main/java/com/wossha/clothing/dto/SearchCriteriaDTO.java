package com.wossha.clothing.dto;

import java.util.List;

public class SearchCriteriaDTO {
	private List<MultiselectItem> types;
	private List<MultiselectItem> categories;
	private List<MultiselectItem> brands;
	private List<MultiselectItem> colors;
	private Integer howLike;
	private String noWearingDaysSimbol;
	private Integer noWearingDays;
	
	public SearchCriteriaDTO(List<MultiselectItem> types, List<MultiselectItem> categories,
			List<MultiselectItem> brands, List<MultiselectItem> colors, Integer howLike, String noWearingDaysSimbol,
			Integer noWearingDays) {
		this.types = types;
		this.categories = categories;
		this.brands = brands;
		this.colors = colors;
		this.howLike = howLike;
		this.noWearingDaysSimbol = noWearingDaysSimbol;
		this.noWearingDays = noWearingDays;
	}

	public SearchCriteriaDTO() {}

	public List<MultiselectItem> getTypes() {
		return types;
	}

	public void setTypes(List<MultiselectItem> types) {
		this.types = types;
	}

	public List<MultiselectItem> getCategories() {
		return categories;
	}

	public void setCategories(List<MultiselectItem> categories) {
		this.categories = categories;
	}

	public List<MultiselectItem> getBrands() {
		return brands;
	}

	public void setBrands(List<MultiselectItem> brands) {
		this.brands = brands;
	}

	public List<MultiselectItem> getColors() {
		return colors;
	}

	public void setColors(List<MultiselectItem> colors) {
		this.colors = colors;
	}

	public Integer getHowLike() {
		return howLike;
	}

	public void setHowLike(Integer howLike) {
		this.howLike = howLike;
	}

	public String getNoWearingDaysSimbol() {
		return noWearingDaysSimbol;
	}

	public void setNoWearingDaysSimbol(String noWearingDaysSimbol) {
		this.noWearingDaysSimbol = noWearingDaysSimbol;
	}

	public Integer getNoWearingDays() {
		return noWearingDays;
	}

	public void setNoWearingDays(Integer noWearingDays) {
		this.noWearingDays = noWearingDays;
	}

}

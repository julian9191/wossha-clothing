package com.wossha.clothing.dto;

import java.util.List;

public class SearchCriteriaParamsDTO {
	
	private List<MultiselectItem> types;
	private List<MultiselectItem> categories;
	private List<MultiselectItem> brands;
	private List<MultiselectItem> colors;
	
	public SearchCriteriaParamsDTO(List<MultiselectItem> types, List<MultiselectItem> categories, List<MultiselectItem> brands,
			List<MultiselectItem> colors) {
		this.types = types;
		this.categories = categories;
		this.brands = brands;
		this.colors = colors;
	}

	public SearchCriteriaParamsDTO() {}

	
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
	
	
}

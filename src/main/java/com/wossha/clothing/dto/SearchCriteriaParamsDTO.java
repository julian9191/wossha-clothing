package com.wossha.clothing.dto;

import java.util.List;

public class SearchCriteriaParamsDTO {
	
	private List<String> types;
	private List<String> categories;
	private List<String> brands;
	private List<BaseColorDTO> colors;
	
	public SearchCriteriaParamsDTO(List<String> types, List<String> categories, List<String> brands,
			List<BaseColorDTO> colors) {
		this.types = types;
		this.categories = categories;
		this.brands = brands;
		this.colors = colors;
	}

	public SearchCriteriaParamsDTO() {}

	
	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<String> getBrands() {
		return brands;
	}

	public void setBrands(List<String> brands) {
		this.brands = brands;
	}

	public List<BaseColorDTO> getColors() {
		return colors;
	}

	public void setColors(List<BaseColorDTO> colors) {
		this.colors = colors;
	}
	
	
}

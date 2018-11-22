package com.wossha.clothing.dto;

import java.util.List;

public class StatisticsDTO {

	private List<StatisticsMapDTO> types;

	public StatisticsDTO(List<StatisticsMapDTO> types) {
		this.types = types;
	}

	public StatisticsDTO() {}

	public List<StatisticsMapDTO> getTypes() {
		return types;
	}

	public void setTypes(List<StatisticsMapDTO> types) {
		this.types = types;
	}

}

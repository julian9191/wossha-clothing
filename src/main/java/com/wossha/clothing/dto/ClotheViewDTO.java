package com.wossha.clothing.dto;

import java.util.List;

public class ClotheViewDTO {
	private ClotheDTO clothe;
	private Integer useTimes;
	private List<StatisticsMapDTO> useDates;
	private List<StatisticsMapDTO> useTimesByMonth;
	
	public ClotheViewDTO(ClotheDTO clothe, Integer useTimes, List<StatisticsMapDTO> useDates,
			List<StatisticsMapDTO> useTimesByMonth) {
		this.clothe = clothe;
		this.useTimes = useTimes;
		this.useDates = useDates;
		this.useTimesByMonth = useTimesByMonth;
	}

	public ClotheViewDTO() {}

	public ClotheDTO getClothe() {
		return clothe;
	}

	public void setClothe(ClotheDTO clothe) {
		this.clothe = clothe;
	}

	public Integer getUseTimes() {
		return useTimes;
	}

	public void setUseTimes(Integer useTimes) {
		this.useTimes = useTimes;
	}

	public List<StatisticsMapDTO> getUseDates() {
		return useDates;
	}

	public void setUseDates(List<StatisticsMapDTO> useDates) {
		this.useDates = useDates;
	}

	public List<StatisticsMapDTO> getUseTimesByMonth() {
		return useTimesByMonth;
	}

	public void setUseTimesByMonth(List<StatisticsMapDTO> useTimesByMonth) {
		this.useTimesByMonth = useTimesByMonth;
	}
	
	
}

package com.wossha.clothing.dto;

public class PictureFileDTO {
	private String filename;
	private String filetype;
	private Integer size;
	private String value;
	
	public PictureFileDTO(String filename, String filetype, Integer size, String value) {
		this.filename = filename;
		this.filetype = filetype;
		this.size = size;
		this.value = value;
	}

	public PictureFileDTO() {}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

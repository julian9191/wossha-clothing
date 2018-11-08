package com.wossha.clothing.dto;

public class MultiselectItem {
	
	private String id;
	private String itemName;
	
	public MultiselectItem(String id, String itemName) {
		this.id = id;
		this.itemName = itemName;
	}

	public MultiselectItem() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	

}

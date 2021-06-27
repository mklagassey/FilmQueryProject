package com.skilldistillery.filmquery.entities;

public class InventoryItem {
	private int inventoryNumber;
	private int filmId;
	private int storeId;
	private String condition;
	private String lastUpdate;
	
	
	public InventoryItem() {
		super();
	}
	
	public InventoryItem(int inventoryNumber, int filmId, int storeId, String condition, String lastUpdate) {
		super();
		this.inventoryNumber = inventoryNumber;
		this.filmId = filmId;
		this.storeId = storeId;
		this.condition = condition;
		this.lastUpdate = lastUpdate;
	}
	
	public int getInventoryNumber() {
		return inventoryNumber;
	}
	public void setInventoryNumber(int inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}
	public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InventoryItem [ inventory number = ");
		builder.append(inventoryNumber);
		builder.append(", film id = ");
		builder.append(filmId);
		builder.append(", store id = ");
		builder.append(storeId);
		builder.append(", condition = ");
		builder.append(condition);
		builder.append(", last update = ");
		builder.append(lastUpdate);
		builder.append(" ]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + inventoryNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryItem other = (InventoryItem) obj;
		if (inventoryNumber != other.inventoryNumber)
			return false;
		return true;
	}
	
	
}

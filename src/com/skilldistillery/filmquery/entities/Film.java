package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {
	private int iD;
	private String title;
	private String description;
	private Integer releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private Integer length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private String languageName;
	private String category;
	private List<Actor> actorList;
	private List<InventoryItem> inventoryList;
	
	
	
	public Film() {
	}

	

	public Film(int iD, String title, String description, Integer releaseYear, int languageId, int rentalDuration,
			double rentalRate, Integer length, double replacementCost, String rating, String specialFeatures,
			String languageName, String category, List<Actor> actorList, List<InventoryItem> inventoryList) {
		super();
		this.iD = iD;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.languageName = languageName;
		this.category = category;
		this.actorList = actorList;
		this.inventoryList = inventoryList;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ Film: id = ");
		builder.append(iD);
		builder.append(", title = ");
		builder.append(title);
		builder.append(", category = ");
		builder.append(category);
		builder.append(", description = ");
		builder.append(description);
		builder.append(", release year = ");
		builder.append(releaseYear);
		builder.append(", language id = ");
		builder.append(languageId);
		builder.append(", rental duration = ");
		builder.append(rentalDuration);
		builder.append(", rental rate = ");
		builder.append(rentalRate);
		builder.append(", length = ");
		builder.append(length);
		builder.append(", replacement cost = ");
		builder.append(replacementCost);
		builder.append(", rating = ");
		builder.append(rating);
		builder.append(", special features = ");
		builder.append(specialFeatures);
		builder.append(", language = ");
		builder.append(languageName);
		builder.append(", actor list = ");
		builder.append(actorList);
		builder.append(", inventory list = ");
		builder.append(inventoryList);
		builder.append(" ]");
		return builder.toString();
	}

	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getTitle() {
//		String fixedTitle = null;
		
//		fixedTitle = 
		
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}
	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	public int getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	public double getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public double getReplacementCost() {
		return replacementCost;
	}
	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSpecialFeatures() {
		return specialFeatures;
	}
	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	public List<Actor> getActorList() {
		return actorList;
	}
	public void setActorList(List<Actor> actorList) {
		this.actorList = actorList;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<InventoryItem> getInventoryList() {
		return inventoryList;
	}
	public void setInventoryList(List<InventoryItem> inventoryList) {
		this.inventoryList = inventoryList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iD;
		result = prime * result + ((languageName == null) ? 0 : languageName.hashCode());
		result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Film other = (Film) obj;
		if (iD != other.iD)
			return false;
		if (languageName == null) {
			if (other.languageName != null)
				return false;
		} else if (!languageName.equals(other.languageName))
			return false;
		if (releaseYear == null) {
			if (other.releaseYear != null)
				return false;
		} else if (!releaseYear.equals(other.releaseYear))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}




	
//	private String fixString(String sIn) {
//		
//		
//		
//	}
	
	
}

package com.food.dto;

//enum Cuisine{AndhraChicken,Biryani,Pizza,Rolls,FastFood,Starters,Roties}
public class Restaurant {
	private int restaurantId;
	private String restaurantName;
	private String cuisineType;
	private int deliveryTime;
	private String address;
	private int adminUserId;
	private double rating;
	private int isActive;
	private String imagePath;

	public Restaurant(int restaurantId, String restaurantName, String cuisineType, int deliveryTime, String address,
			int adminUserId, double rating, int isActive, String imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.address = address;
		this.adminUserId = adminUserId;
		this.rating = rating;
		this.isActive = isActive;
		this.imagePath = imagePath;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adrress) {
		this.address = adrress;
	}

	public int getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", cuisineType="
				+ cuisineType + ", deliveryTime=" + deliveryTime + ", address=" + address + ", adminUserId="
				+ adminUserId + ", rating=" + rating + ", isActive=" + isActive + ", imagePath=" + imagePath + "]";
	}

}

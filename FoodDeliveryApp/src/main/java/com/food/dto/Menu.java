package com.food.dto;

public class Menu {
	private int menuId;
	private int restaurantId;
	private String itemName;
	private String discription;
	private double price;
	private int isAvailable;
	public Menu(int menuId, int restaurantId, String itemName, String discription, double price, int isAvailable) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.discription = discription;
		this.price = price;
		this.isAvailable = isAvailable;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getIsAvailable() {
		return isAvailable;
	}
	public void setAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restaurantId=" + restaurantId + ", itemName=" + itemName + ", discription="
				+ discription + ", price=" + price + ", isAvailable=" + isAvailable + "]";
	}
	
}

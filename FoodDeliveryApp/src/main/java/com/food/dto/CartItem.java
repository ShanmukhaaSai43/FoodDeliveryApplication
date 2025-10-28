package com.food.dto;

public class CartItem {
	private int itemId;
	private int resId;
	private String name;
	private double price;
	private int quantity;
	
	public CartItem(int itemId, int resId, String name, double price, int quantity) {
		this.itemId = itemId;
		this.resId = resId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", resId=" + resId + ", name=" + name + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	
}

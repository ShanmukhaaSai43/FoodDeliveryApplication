package com.food.dto;
//enum Status{Ordered,Pending,Cancelled,InProgress}
//enum PaymentMode{UPI,Cash,CreditCard,DebitCard}
public class Order {
	private int orderId;
	private int userId;
	private int restaurantId;
	private double totalAmount;
	private String orderStatus;
	private String paymentMode;
	
	
	public Order() {
		
	}
	public Order(int orderId, int userId, int restaurantId, double totalAmount, String orderStatus,
			String paymentMode) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.paymentMode = paymentMode;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getorderStatus() {
		return orderStatus;
	}
	public void setorderStatus(String status) {
		this.orderStatus = status;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", restaurantId=" + restaurantId + ", totalAmount="
				+ totalAmount + ", status=" + orderStatus + ", paymentMode=" + paymentMode + "]";
	}
	
}

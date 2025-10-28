package com.food.dto;

//enum OrderStatus{Delivered,Cancelled,Returned}
public class OrderHistory {
	private int orderHistoryId;
	private int userId;
	private int orderId;
	private double totalAmount;
	private String orderStatus;
	public OrderHistory(int orderHistoryId, int userId, int orderId, double totalAmount, String orderStatus) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.userId = userId;
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
	}
	public int getOrderHistoryId() {
		return orderHistoryId;
	}
	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "OrderHistory [orderHistoryId=" + orderHistoryId + ", userId=" + userId + ", orderId=" + orderId
				+ ", totalAmount=" + totalAmount + ", orderStatus=" + orderStatus + "]";
	}
	
}

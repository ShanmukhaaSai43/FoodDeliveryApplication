package com.food.dao;

import java.util.List;

import com.food.dto.OrderItem;

public interface OrderItemDAO {
	List getAllOrderItems(int orderId);
	OrderItem getOrderItem(int orderItemId);
	boolean updateOrderItem(OrderItem orderItem);
	boolean insertOrderItem(OrderItem orderItem);
	boolean deleteOrderItem(int orderItemId);
}

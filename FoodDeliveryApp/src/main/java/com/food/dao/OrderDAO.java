package com.food.dao;

import java.util.List;

import com.food.dto.Order;

public interface OrderDAO {
	List getAllOrdersByUser(int userId);
	Order getOrder(int orderId);
	boolean updateOrder(Order order);
	boolean insertOrder(Order order);
	boolean deleteOrder(int orderId);
}

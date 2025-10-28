package com.food.dao;

import java.util.List;

import com.food.dto.OrderHistory;

public interface OrderHistoryDAO {
	List getAllOrderHistory(int userId);
	OrderHistory getOrderHistory(int orderHistoryId);
	boolean updateOrderHistory(OrderHistory orderHistory);
	boolean insertOrderHistory(OrderHistory orderHistory);
	boolean deleteOrderHistory(int orderHistoryId);
}

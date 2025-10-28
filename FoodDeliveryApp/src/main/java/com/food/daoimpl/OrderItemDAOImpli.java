package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.connector.ConnectionFactory;
import com.food.dao.OrderDAO;
import com.food.dao.OrderItemDAO;
import com.food.dto.Menu;
import com.food.dto.Order;
import com.food.dto.OrderItem;

public class OrderItemDAOImpli implements OrderItemDAO{
	ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
	@Override
	public List getAllOrderItems(int orderId) {
		Connection con = null;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "SELECT * FROM ORDERITEM WHERE ORDERID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orderId);
			ResultSet res = pstmt.executeQuery(query);
			while (res.next()) {
				int orderItemId= res.getInt(1);
				int menuId = res.getInt(3);
				int quantity = res.getInt(4);
				double totalAmount = res.getDouble(5);
				

				OrderItem newOrderItem = new OrderItem(orderItemId,orderId,menuId,quantity, totalAmount);
				orderItems.add(newOrderItem);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderItems;
	}

	@Override
	public OrderItem getOrderItem(int orderItemId) {
		Connection con;
		OrderItem orderItem = null;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "SELECT * FROM ORDERITEM WHERE ORDERITEMID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orderItemId);
			ResultSet res = pstmt.executeQuery();
			res.next();
			orderItem = new OrderItem(res.getInt(1), res.getInt(2),res.getInt(3), res.getInt(4),res.getDouble(5));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return orderItem;
	}

	@Override
	public boolean updateOrderItem(OrderItem orderItem) {
		Connection con = null;
		boolean bool = false;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "UPDATE ORDERITEM SET ORDERID = ? AND MENUID = ? AND QUANTITY = ? AND TOTALPRICE = ? WHERE ORDERITEMID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orderItem.getOrderId());
			pstmt.setInt(2, orderItem.getMenuId());
			pstmt.setInt(3, orderItem.getQuantity());
			pstmt.setDouble(4, orderItem.getTotalPrice());
			pstmt.setInt(5, orderItem.getOrderItemId());
			bool = pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public boolean insertOrderItem(OrderItem orderItem) {
		Connection con = null;
		boolean bool = false;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "INSERT INTO ORDERITEM (`ORDERID`,`MENUID`,`QUANTITY`,`TOTALPRICE`) VALUES(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orderItem.getOrderId());
			pstmt.setInt(2, orderItem.getMenuId());
			pstmt.setInt(3, orderItem.getQuantity());
			pstmt.setDouble(4, orderItem.getTotalPrice());
			bool = pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return bool;
	}

	@Override
	public boolean deleteOrderItem(int orderItemId) {
		Connection con = null;
		boolean bool = false;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "DELETE FROM ORDERITEM WHERE ORDERITEMID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orderItemId);
			bool = pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}
	

}

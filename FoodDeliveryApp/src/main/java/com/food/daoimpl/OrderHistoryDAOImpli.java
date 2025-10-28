package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.connector.ConnectionFactory;
import com.food.dao.OrderHistoryDAO;
import com.food.dto.OrderHistory;
import com.food.dto.OrderItem;

public class OrderHistoryDAOImpli implements OrderHistoryDAO{
	ArrayList<OrderHistory> orderHistories = new ArrayList<OrderHistory>();
	@Override
	public List getAllOrderHistory(int userId) {
		Connection con = null;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "SELECT * FROM ORDERHISTORY WHERE USERID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			ResultSet res = pstmt.executeQuery(query);
			while (res.next()) {
				int orderHistoryId= res.getInt(1);
				int orderId = res.getInt(3);
				double totalAmount = res.getDouble(5);
				String orderStatus = res.getString(6);
				

				OrderHistory newOrderHistory = new OrderHistory(orderHistoryId,userId,orderId,totalAmount,orderStatus);
				orderHistories.add(newOrderHistory);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderHistories;
	}

	@Override
	public OrderHistory getOrderHistory(int userId) {
		Connection con;
		OrderHistory orderHistory = null;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "SELECT * FROM ORDERHISTORY WHERE USERID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			ResultSet res = pstmt.executeQuery();
			res.next();
			orderHistory = new OrderHistory(res.getInt(1), res.getInt(2),res.getInt(3), res.getDouble(5),res.getString(6));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return orderHistory;
	}

	@Override
	public boolean updateOrderHistory(OrderHistory orderHistory) {
		Connection con = null;
		boolean bool = false;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "UPDATE ORDERHISTORY SET USERID = ? AND ORDERID = ? AND TOTALAMOUNT = ? AND ORDERSTATUS WHERE ORDERHISTORYID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orderHistory.getUserId());
			pstmt.setInt(2, orderHistory.getOrderId());
			pstmt.setDouble(3, orderHistory.getTotalAmount());
			pstmt.setString(4, orderHistory.getOrderStatus());
			pstmt.setInt(5, orderHistory.getOrderHistoryId());
			bool = pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public boolean insertOrderHistory(OrderHistory orderHistory) {
		Connection con = null;
		boolean bool = false;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "INSERT INTO ORDERITEM (`USERID`,`ORDERID`,`TOTALAMOUNT`,`ORDERSTATUS`) VALUES(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orderHistory.getUserId());
			pstmt.setInt(2, orderHistory.getOrderId());
			pstmt.setDouble(4, orderHistory.getTotalAmount());
			pstmt.setString(4, orderHistory.getOrderStatus());
			bool = pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return bool;
	}

	@Override
	public boolean deleteOrderHistory(int orderHistoryId) {
		Connection con = null;
		boolean bool = false;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "DELETE FROM ORDERHISTORY WHERE ORDERHISTORYID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orderHistoryId);
			bool = pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

}

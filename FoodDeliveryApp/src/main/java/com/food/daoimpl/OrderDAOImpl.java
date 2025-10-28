package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.connector.ConnectionFactory;
import com.food.dao.OrderDAO;
import com.food.dto.Menu;
import com.food.dto.Order;

public class OrderDAOImpl implements OrderDAO{
	ArrayList<Order> orders = new ArrayList<Order>();
	@Override
	public List getAllOrdersByUser(int userId) {
		Connection con = null;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "SELECT * FROM ORDER WHERE USERID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			ResultSet res = pstmt.executeQuery(query);
			while (res.next()) {
				int orderId= res.getInt(1);
				int restaurantId = res.getInt(3);
				double totalAmount = res.getDouble(5);
				String orderStatus = res.getString(6);
				String paymentMode = res.getString(7);

				Order newOrder = new Order(orderId,userId,restaurantId, totalAmount, orderStatus, paymentMode);
				orders.add(newOrder);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public Order getOrder(int orderId) {
		Connection con;
		Order order = null;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "SELECT * FROM ORDER WHERE ORDERID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orderId);
			ResultSet res = pstmt.executeQuery();
			res.next();
			order = new Order(res.getInt(1), res.getInt(2), res.getInt(3), res.getDouble(4),res.getString(5), res.getString(6));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public boolean updateOrder(Order order) {
		Connection con = null;
		boolean bool = false;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "UPDATE Order SET USERID = ? AND RESTAURANTID = ? AND TOTALAMOUNT = ? AND ORDERSTATUS = ? AND PAYMENTMODE = ? WHERE ORDERID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, order.getRestaurantId());
			pstmt.setInt(2, order.getRestaurantId());
			pstmt.setDouble(3, order.getTotalAmount());
			pstmt.setString(4, order.getorderStatus());
			pstmt.setString(5, order.getPaymentMode());
			pstmt.setInt(6, order.getOrderId());
			bool = pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public boolean insertOrder(Order order) {
		Connection con = null;
		boolean bool = false;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "INSERT INTO ORDER (`USERID`,`RESTAURANTID`,`TOTALAMOUNT`,`ORDERSTATUS`,`PAYMENTMODE`) VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, order.getUserId());
			pstmt.setInt(2, order.getRestaurantId());
			pstmt.setDouble(3, order.getTotalAmount());
			pstmt.setString(4, order.getorderStatus());
			pstmt.setString(5, order.getPaymentMode());
			bool = pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return bool;
	}

	@Override
	public boolean deleteOrder(int orderId) {
		Connection con = null;
		boolean bool = false;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "DELETE FROM ORDER WHERE ORDERID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orderId);
			bool = pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

}

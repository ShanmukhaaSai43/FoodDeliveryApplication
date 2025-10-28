package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.connector.ConnectionFactory;
import com.food.dao.RestaurantDAO;
import com.food.dto.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO {

	@Override
	public List<Restaurant> getRestaurants() {
		List<Restaurant> restaurants = new ArrayList<>();
		Connection con = null;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "SELECT * FROM RESTAURANT";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				int restaurantId = res.getInt(1);
				String restaurantName = res.getString(2);
				String cuisineType = res.getString(3);
				int deliveryTime = res.getInt(4);
				String address = res.getString(5);
				int adminUserId = res.getInt(6);
				double rating = res.getDouble(7);
				int isActive = res.getInt(8);
				String imagePath = res.getString(9);
				Restaurant newRestaurant = new Restaurant(restaurantId, restaurantName, cuisineType, deliveryTime,
						address, adminUserId, rating, isActive, imagePath);
				restaurants.add(newRestaurant);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return restaurants;
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		Connection con = null;
		Restaurant restaurant = null;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "SELECT * FROM RESTAURANT WHERE RESTAURANTID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, restaurantId);
			ResultSet res = pstmt.executeQuery();
			res.next();
			restaurant = new Restaurant(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4),
					res.getString(5), res.getInt(6), res.getDouble(7), res.getInt(8), res.getString(9));

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return restaurant;
	}

	@Override
	public boolean updateRestaurant(Restaurant restaurant) {
		Connection con = null;
		boolean bool = false;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "UPDATE RESTAURANT SET RESTAURANTNAME = ? AND CUISINETYPE = ? AND DELIVERYTIME = ? AND ADDRESS = ? AND ADMINUSERID = ? AND RATING = ? AND ISACTIVE = ? AND IMAGEPATH = ? WHERE RESTAURANTID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, restaurant.getRestaurantName());
			pstmt.setString(2, restaurant.getCuisineType());
			pstmt.setInt(3, restaurant.getDeliveryTime());
			pstmt.setString(4, restaurant.getAddress());
			pstmt.setInt(5, restaurant.getAdminUserId());
			pstmt.setDouble(6, restaurant.getRating());
			pstmt.setInt(7, restaurant.getIsActive());
			pstmt.setString(8, restaurant.getImagePath());
			pstmt.setInt(9, restaurant.getRestaurantId());
			bool = pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return bool;

	}

	@Override
	public boolean insertRestaurant(Restaurant restaurant) {
		Connection con = null;
		boolean bool = false;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "INSERT INTO RESTAURANT (`RESTAURANTNAME`,`CUISINETYPE`,`DELIVERYTIME`,`ADDRESS`,`ADMINUSERID`,`RATING`,`ISACTIVE`,`IMAGEPATH`) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, restaurant.getRestaurantName());
			pstmt.setString(2, restaurant.getCuisineType());
			pstmt.setInt(3, restaurant.getDeliveryTime());
			pstmt.setString(4, restaurant.getAddress());
			pstmt.setInt(5, restaurant.getAdminUserId());
			pstmt.setDouble(6, restaurant.getRating());
			pstmt.setInt(7, restaurant.getIsActive());
			pstmt.setString(8, restaurant.getImagePath());
			bool = pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return bool;

	}

	@Override
	public boolean deleteRestaurant(int restaurantId) {
		Connection con = null;
		boolean bool = false;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "DELETE FROM RESTAURANT WHERE RESTAURANTID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, restaurantId);
			bool = pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return bool;

	}

}

package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.food.connector.ConnectionFactory;
import com.food.dao.MenuDAO;
import com.food.dto.Menu;

public class MenuDAOImpl implements MenuDAO {
	ArrayList<Menu> allMenu = new ArrayList<Menu>();

	@Override
	public List getAllMenuByRestaurant(int restaurantId) {
		Connection con = null;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "SELECT * FROM MENU WHERE RESTAURANTID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, restaurantId);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				int menuId= res.getInt(1);
				String itemName = res.getString(3);
				String discription = res.getString(4);
				double price = res.getDouble(5);
				int isAvailable = res.getInt(6);

				Menu newMenu = new Menu(menuId,restaurantId, itemName, discription, price,
						isAvailable);
				allMenu.add(newMenu);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allMenu;
	}

	@Override
	public Menu getMenu(int menuId) {
		Connection con;
		Menu menu = null;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "SELECT * FROM MENU WHERE MENUID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, menuId);
			ResultSet res = pstmt.executeQuery();
			res.next();
			menu = new Menu(res.getInt(1), res.getInt(2),res.getString(3), res.getString(4), res.getDouble(5), res.getInt(6));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public boolean updateMenu(Menu menu) {
		Connection con = null;
		boolean bool = false;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "UPDATE Menu SET RESTAURANTID = ? AND ITEMNAME = ? AND DISCRIPTION = ? AND PRICE = ? AND ISAVAILABLE = ?  WHERE MENUID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, menu.getRestaurantId());
			pstmt.setString(2, menu.getItemName());
			pstmt.setString(3, menu.getDiscription());
			pstmt.setDouble(4, menu.getPrice());
			pstmt.setInt(5, menu.getIsAvailable());
			pstmt.setInt(6, menu.getMenuId());
			bool = pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public boolean insertMenu(Menu menu) {
		Connection con = null;
		boolean bool = false;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "INSERT INTO MENU (`RESTAURANTID`,`ITEMNAME`,`DISCRIPTION`,`PRICE`,`ISAVAILABLE`) VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, menu.getRestaurantId());
			pstmt.setString(2, menu.getItemName());
			pstmt.setString(3, menu.getDiscription());
			pstmt.setDouble(4, menu.getPrice());
			pstmt.setInt(5, menu.getIsAvailable());
			bool = pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return bool;
	}

	@Override
	public boolean deleteMenu(int menuId) {
		Connection con = null;
		boolean bool = false;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "DELETE FROM MENU WHERE MENUID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, menuId);
			bool = pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

}

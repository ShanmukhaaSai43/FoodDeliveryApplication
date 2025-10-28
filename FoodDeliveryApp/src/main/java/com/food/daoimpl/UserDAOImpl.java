package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.connector.ConnectionFactory;
import com.food.dao.UserDAO;
import com.food.dto.User;

public class UserDAOImpl implements UserDAO {

	ArrayList<User> users = new ArrayList<User>();

	@Override
	public List getUsers() {
		Connection con;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "SELECT * FROM USER";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				int userId = res.getInt(1);
				String userName = res.getString(2);
				String password = res.getString(3);
				String email = res.getString(4);
				String address = res.getString(5);
				String role = res.getString(6);
				User newUser = new User(userId, userName, password, email, address, role);
				users.add(newUser);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getUser(int userId) {
		Connection con;
		User user = null;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "SELECT * FROM USER WHERE USERID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			ResultSet res = pstmt.executeQuery();
			res.next();
			user = new User(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5),
					res.getString(6));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		Connection con = null;
		boolean bool = false;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "UPDATE USER SET USERNAME = ? AND PASSWORD = ? AND EMAIL = ? AND ADDRESS = ? AND ROLE = ? WHERE USERID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.geteMail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getRole());
			pstmt.setInt(6, user.getUserId());
			bool = pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public boolean insertUser(User user) {
		Connection con = null;
		boolean bool = false;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "INSERT INTO USER (`USERNAME`,`PASSWORD`,`EMAIL`,`ADDRESS`,`ROLE`) VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.geteMail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getRole());
			bool = pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bool;
	}

	@Override
	public boolean deleteUser(int userId) {
		Connection con = null;
		boolean bool = false;
		try {
			con = ConnectionFactory.requestConnection();
			String query = "DELETE FROM USER WHERE USERID = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			bool = pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

}

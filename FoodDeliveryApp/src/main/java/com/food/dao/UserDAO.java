package com.food.dao;

import java.util.List;

import javax.management.relation.Role;

import com.food.dto.User;

public interface UserDAO {
	List getUsers();
	User getUser(int userId);
	boolean updateUser(User user);
	boolean insertUser(User user);
	boolean deleteUser(int userId);
}

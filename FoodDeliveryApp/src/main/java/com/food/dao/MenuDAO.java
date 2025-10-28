package com.food.dao;

import java.util.List;

import com.food.dto.Menu;

public interface MenuDAO {
	List getAllMenuByRestaurant(int restaurantId);
	Menu getMenu(int menuId);
	boolean updateMenu(Menu menu);
	boolean insertMenu(Menu menu);
	boolean deleteMenu(int menuId);
}

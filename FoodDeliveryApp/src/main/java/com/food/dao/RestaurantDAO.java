package com.food.dao;

import java.util.List;


import com.food.dto.Restaurant;

public interface RestaurantDAO {
	List getRestaurants();
	Restaurant getRestaurant(int restaurantId);
	boolean updateRestaurant(Restaurant restaurant);
	boolean insertRestaurant(Restaurant restaurant);
	boolean deleteRestaurant(int restaurantId);
	}

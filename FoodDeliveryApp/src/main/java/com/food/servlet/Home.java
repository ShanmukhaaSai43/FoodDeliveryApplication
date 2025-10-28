package com.food.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.daoimpl.RestaurantDAOImpl;
import com.food.dto.Restaurant;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		System.out.println("Home servlet doGet method called!");
		RestaurantDAOImpl restaurantDAOImpl = new RestaurantDAOImpl();
		List<Restaurant> restaurants = restaurantDAOImpl.getRestaurants();
		
		System.out.println("Number of restaurants fetched: " + (restaurants != null ? restaurants.size() : "null"));
		
//		for(Restaurant restaurant : restaurants) {
//			System.out.println(restaurant.getRestaurantName());
//			System.out.println(restaurant.getRating());
//			System.out.println(restaurant.getDeliveryTime());
//			System.out.println(restaurant.getCuisineType());
//		} 
		
		if (restaurants != null) {
            req.setAttribute("restaurantList", restaurants);
        } else {
            req.setAttribute("restaurantList", new ArrayList<Restaurant>());
        }
		
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		rd.include(req, res);
	}
}

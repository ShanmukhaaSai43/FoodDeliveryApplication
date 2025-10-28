package com.food.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.daoimpl.MenuDAOImpl;
import com.food.dto.Menu;


@WebServlet("/menu")
public class MenuX extends HttpServlet {
	private MenuDAOImpl menuDAOImpl = null;
	public void init() {
		menuDAOImpl = new MenuDAOImpl();
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String restaurantId = req.getParameter("restaurantId");
		if(restaurantId != null) {
			try {
				List<Menu> menuList = menuDAOImpl.getAllMenuByRestaurant(Integer.parseInt(restaurantId));
				req.setAttribute("menuList", menuList);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.include(req, res);
	}

}

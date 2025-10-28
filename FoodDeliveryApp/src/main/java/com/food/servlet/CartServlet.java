package com.food.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.dto.Cart;
import com.food.dto.CartItem;
import com.food.dto.Menu;
import com.food.dao.MenuDAO;
import com.food.daoimpl.MenuDAOImpl;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Cart cart =(Cart) session.getAttribute("cart");
		
		if(cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		
		String action = request.getParameter("action");
		
		if(action.equals("add")) {
			addItemToCart(request, cart);
		}
		else if(action.equals("update")){
			updateCartItem(request, cart);
		}
		else if(action.equals("remove")) {
			removeItemFromCart(request, cart);
		}
		
		session.setAttribute("cart", cart);
		response.sendRedirect("cart.jsp");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("cart.jsp").forward(req, resp);

	}
	
	private void addItemToCart(HttpServletRequest request, Cart cart) {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		MenuDAO menuDAO = new MenuDAOImpl();
		Menu menuItem = menuDAO.getMenu(itemId);
		
		HttpSession session = request.getSession();
		session.setAttribute("restaurantId", menuItem.getRestaurantId());
		
		if(menuItem != null) {
			CartItem item = new CartItem(menuItem.getMenuId(),menuItem.getRestaurantId(),menuItem.getItemName(),menuItem.getPrice(),quantity);
			cart.addItem(item);
		}
	}
	
	private void updateCartItem(HttpServletRequest request, Cart cart) {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		cart.updateItem(itemId, quantity);
	}
	
	private void removeItemFromCart(HttpServletRequest request, Cart cart) {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		cart.romoveItem(itemId);
	}

}

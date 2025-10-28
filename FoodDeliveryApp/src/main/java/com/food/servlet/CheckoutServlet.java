package com.food.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.dao.OrderDAO;
import com.food.daoimpl.OrderDAOImpl;
import com.food.dto.Cart;
import com.food.dto.CartItem;
import com.food.dto.Order;
import com.food.dto.User;


@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	private OrderDAO orderDAO;
	@Override
	public void init() throws ServletException {
		orderDAO = new OrderDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		User user = (User) session.getAttribute("loggedInUser");
		
		if(cart != null & user !=null & !cart.getItems().isEmpty()) {
			
			String paymentMethod = request.getParameter("paymentMethod");
			
			Order order = new Order();
			order.setUserId(user.getUserId());
			order.setRestaurantId((int) session.getAttribute("restaurantId"));
			order.setorderStatus("Pending");
			order.setPaymentMode(paymentMethod);
			
			double totalAmount = 0;
			
			for(CartItem item : cart.getItems().values()) {
				totalAmount += item.getPrice() * item.getQuantity();
			}
			order.setTotalAmount(totalAmount);
			
			session.removeAttribute("cart");
			session.setAttribute("order", order);
			response.sendRedirect("order_confirmation.jsp");
			
		}
		else {
			response.sendRedirect("cart.jsp");
		}  
	}

}

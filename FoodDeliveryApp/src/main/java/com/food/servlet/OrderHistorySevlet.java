package com.food.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.daoimpl.OrderHistoryDAOImpli;
import com.food.dto.User;

@WebServlet("/orderhistory")
public class OrderHistorySevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user=(User)session.getAttribute("loggedInUser");
		OrderHistoryDAOImpli orderHistoryDAOImpl = new OrderHistoryDAOImpli();
		orderHistoryDAOImpl.getOrderHistory(user.getUserId());
		if(orderHistoryDAOImpl != null) {
			request.setAttribute("orderHistoryDAOImpl", orderHistoryDAOImpl);
		}
		RequestDispatcher rd =request.getRequestDispatcher("orderHistory.jsp");
		rd.include(request, response);
	}

}

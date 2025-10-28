package com.food.utilities;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.dto.User;

/**
 * Servlet implementation class UserOrderHistory
 */
@WebServlet("/orderhistory1")
public class UserOrderHistory extends HttpServlet {

	public void init() {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user =(User) session.getAttribute("loggedInUser");
		
	}

}

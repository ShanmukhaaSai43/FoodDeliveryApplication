package com.food.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.dao.UserDAO;
import com.food.daoimpl.UserDAOImpl;
import com.food.dto.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDAO userDAO;
	
	public void init() {
		userDAO = new UserDAOImpl();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");
		
		User user = userDAO.getUser(Integer.parseInt(userId));
		
		if(user != null && user.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedInUser", user);
			response.sendRedirect("home");
		}
		else {
			request.setAttribute("errorMessage", "Invalid username or password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}

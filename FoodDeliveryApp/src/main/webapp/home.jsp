<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import ="java.util.List, com.food.dto.Restaurant, com.food.dto.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<% User user= (User) session.getAttribute("loggedInUser");  %>
	<h1>Hi <%= user.getName() %>, Welcome to neway</h1>
	<form action="home">
		<input type="submit" value="home">
	</form>
	<form action="cart">
		<input type="submit" value="cart">
	</form>
	<form action="orderhistory" method="post">
		<input type="submit" value="View Order History">
	</form>
	<form action="login.jsp">
		<input type="submit" value="logout">
	</form>
	
	<%
	List<Restaurant> restaurants = (List<Restaurant>)request.getAttribute("restaurantList");
	System.out.println("Received restaurant list with size: " + (restaurants != null ? restaurants.size() : "null"));
	if (restaurants != null && !restaurants.isEmpty()) {
		for(Restaurant restaurant : restaurants ){
	%>
		<div>
			<h4><%= restaurant.getRestaurantName() %></h4>
			<p><%= restaurant.getRating() %></p>
			<h4><%= restaurant.getDeliveryTime() %></h4>
			<h4><%= restaurant.getCuisineType() %></h4>
			<a href="menu?restaurantId=<%=restaurant.getRestaurantId()%>">View Menu</a>
		</div>
		<hr>
	 <%
        }
    } else {
    %>
        <p>No restaurants available.</p>
    <%
    }
    %>
	
</body>
</html>
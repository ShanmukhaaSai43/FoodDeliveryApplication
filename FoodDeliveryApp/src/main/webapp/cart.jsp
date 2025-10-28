<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.Map, com.food.dto.Cart, com.food.dto.CartItem" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>
	<h1> Your Shopping Cart</h1>
	<div>
		<%
		Cart cart = (Cart) session.getAttribute("cart");
		if ( cart != null & !cart.getItems().isEmpty()){
			for(CartItem item : cart.getItems().values()){
		%>
		<div>
			<h3><%= item.getName() %></h3>
			<p> &#x20B9; <%= item.getPrice()%></p>
			<form action="cart" method="post">
				<input type="hidden" name="itemId" value="<%=item.getItemId()%>">
				
				<label> Quantity :
				<input type ="number" name="quantity" value="<%=item.getQuantity()%>" min="1">
				</label>
				
				<input type="submit" name="action" value="update">
				
				<input type="submit" name="action" value="remove">
			</form>
		</div>
		<%
		}
			} else{
		%>
		<p>	Your cart is empty.</p>
		<%} %>
		
		
		<%-- Add More Items Button --%>
		<a href="menu?restaurantId=<%= session.getAttribute("restaurantId") %>"> Add More Items </a>
		
		<%-- Proceed to Checkout Button --%>
		<%
		if(session.getAttribute("cart")!=null) { 
		%>
		<form action="checkout.jsp" method="post">
			<input type="submit" value="Proceed to Checkout">
		</form>
		<%
		}
		%>
	</div>
</body>
</html>
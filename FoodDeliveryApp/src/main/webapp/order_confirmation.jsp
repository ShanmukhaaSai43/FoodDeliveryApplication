<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.food.dto.Order" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation</title>
</head>
<body>
	<h1>Order Confirmation</h1>
	<%
	Order order = (Order) session.getAttribute("order");
	if(order != null){
	%>
	<div>
		<p>Thank You for your Order!</p>
		<p>Order ID:
			<%=order.getOrderId() %></p>
		<p>Total Amount:
			<%=order.getTotalAmount() %></p>
		<p>Status:
			<%=order.getorderStatus() %></p>
		<p>Payment Method:
			<%=order.getPaymentMode() %></p>	
	</div>
	<%
	}
	%>
	
</body>
</html>
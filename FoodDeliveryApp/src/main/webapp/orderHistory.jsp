<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*, com.food.dto.OrderHistory"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order History</title>
</head>
<body>
	<% OrderHistory orderHistory =(OrderHistory) session.getAttribute("orderHistoryDAOImpl"); %>
	<%if(orderHistory !=  null){ %>
	<h6><%=orderHistory.getOrderHistoryId() %></h6>
	<h6><%=orderHistory.getOrderId() %></h6>
	<h6><%=orderHistory.getTotalAmount() %></h6>
	<h6><%=orderHistory.getOrderStatus() %></h6>
	<%}else{ %>
	<h1>No Order History</h1>
	<%} %>
</body>
</html>
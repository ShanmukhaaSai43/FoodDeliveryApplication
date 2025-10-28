<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.food.dto.Menu"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
	<%
		List<Menu> menuList = (List<Menu>)request.getAttribute("menuList");
		for(Menu menu : menuList){
	%>
	<div>
		<h6><%=menu.getItemName() %></h6>
		<h6><%=menu.getDiscription() %></h6>
		<h6><%=menu.getPrice() %></h6>
		<form action="cart" method="post">
			<input type="hidden" name="itemId" value="<%=menu.getMenuId()%>">
			Quantity: <input type="number" name="quantity" value="1" min="1" >
			<input type="submit" value="Add to Cart"> 
			<input type="hidden" name="action" value="add">
		</form>
		
	</div>
	<%
		}
	%>

</body>
</html>
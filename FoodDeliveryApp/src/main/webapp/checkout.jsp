<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Checkout</h2>
	<form action="checkout" method="post">
		<label for="address">Delivery Address</label>
		<textarea id="address" name="address" required></textarea><br>
	
		<label>PaymentMode:</label>
		<select neme="paymentMethod">
			<option value="Online"> Credit Card</option>
			<option value="Online"> Debit Card</option>
			<option value="cash"> Cash on Delivery</option>
		</select><br>
		<input type="submit" value="action">
	</form>
</body>
</html>
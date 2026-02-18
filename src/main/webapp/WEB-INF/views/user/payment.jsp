<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Gateway</title>
<link rel="stylesheet" type="text/css" href="/assets/css/paymentform.css"> 

</head>
<body>
 <form class="payment-form" action="payment" method="post">
        <h2>Choose Payment Method</h2>
        
        <div class="payment-option">
            <input type="radio" id="upi" name="paymentMethod" value="UPI">
            <label for="upi">Net UPI Payment(Google Pay)</label>
        </div>
        
        <div class="payment-option">
            <input type="radio" id="cod" name="paymentMethod" value="COD">
            <label for="cod">Cash on Delivery (COD)</label>
        </div>
        
        <input type="submit" class="submit-btn" value="Proceed" name="proceed"/>
    </form>
</body>
</html>
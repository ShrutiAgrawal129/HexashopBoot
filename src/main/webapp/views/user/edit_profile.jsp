<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="user_header.jsp"%> 
<title>Insert title here</title>
 
	
 <!--<link rel="stylesheet" type="text/css" href="/assets/css/userupdateform.css">-->
 	 <style>body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f9;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
}

form {
    width: 350px;
    margin: 20px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 10px;
    background-color: #ffffff;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

form label {
    display: block;
    margin-bottom: 8px;
    font-weight: bold;
    color: #333;
}

form input[type="text"],
form input[type="number"],
form input[type="email"],
form input[type="password"] {
    width: calc(100% - 20px);
    padding: 8px 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

form input[type="submit"] {
    width: 100%;
    padding: 10px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s ease;
}

form input[type="submit"]:hover {
    background-color: #45a049;
}

br {
    display: none;
}
	</style>
 </head>
<body>
<br><br><br><br><br><br>
<form action="edit_profile" method="post">
        <label>Mobile Number:</label>
        <input type="number" name="phone" value="${user.phone}" required /><br><br>
        <label>Email:</label>
        <input type="email" name="email" value="${user.email}" required /><br><br>
        <label>Address:</label>
        <input type="text" name="address" value="${user.address}" required /><br><br>
        <label>City:</label>
        <input type="text" name="city" value="${user.city}" required /><br><br>
        <input type="submit" value="SAVE" />
    </form>
</body>
</html>
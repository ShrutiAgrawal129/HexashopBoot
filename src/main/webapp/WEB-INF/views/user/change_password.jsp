<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ include file="user_header.jsp"%> 
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <%-- <link rel="stylesheet" type="text/css"
	href="<c:url value='/assets/css/userupdateform.css' />"> --%>
	<%-- <link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/userupdateform.css' />">
 --%>
 <!-- <link rel="stylesheet" type="text/css" href="/assets/css/userupdateform.css"> -->
 	
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
<form action="change_password" method="post">
        <label>Enter Current Password</label>
        <input type="password" name="old" required /><br><br>
        <label>Enter New Password</label>
        <input type="password" name="new1" required /><br><br>
        <label>Re-enter New Password</label>
        <input type="password" name="new2" required /><br><br>
        <input type="submit" value="SAVE" />
    </form>

</body>
</html>
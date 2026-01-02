<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
 <%@ include file="user_header.jsp"%> 
<head>
    <meta charset="ISO-8859-1">
    <title>User Profile</title>
   <link rel="stylesheet" type="text/css" href="/assets/css/userprofile.css">
   
	<!--  <style>
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f3f4f6;
            color: #333;
        }
        .profile-container {
            max-width: 800px;
            margin: 40px auto;
            padding: 30px;
            background: #ffffff;
            border-radius: 10px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
        }
        .profile-header {
            text-align: center;
            margin-bottom: 30px;
        }
        .profile-header img {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            border: 5px solid #007bff;
            object-fit: cover;
        }
        .profile-header h2 {
            margin-top: 20px;
            font-size: 26px;
            color: #007bff;
        }
        .profile-info {
            line-height: 2;
            font-size: 16px;
        }
        .profile-info label {
            font-weight: bold;
            color: #555;
        }
        .profile-actions {
            margin-top: 30px;
            text-align: center;
        }
        .profile-actions input[type="submit"] {
            background-color: #007bff;
            color: #ffffff;
            border: none;
            padding: 12px 25px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin: 10px;
            transition: background-color 0.3s ease;
        }
        .profile-actions input[type="submit"]:hover {
            background-color: #0056b3;
        }
   </style> -->
</head>
<body>
<br><br><br><br><br>
    <div class="profile-container">
        <div class="profile-header">
            <img src="${pageContext.request.contextPath}/assets/images/userImage.png" alt="Profile Image">
            <h2><b>${user.name}</b></h2>
        </div>

        <div class="profile-info">
            <p><label>Name:</label> ${user.name}</p>
            <p><label>Mobile Number:</label> ${user.phone}</p>
            <p><label>Email:</label> ${user.email}</p>
            <p><label>Address:</label> ${user.address}</p>
            <p><label>City:</label> ${user.city}</p>
        </div>

        <div class="profile-actions">
            <form action="user_profile" method="post">
                <input type="submit" name="profile" value="Edit Profile">
                <input type="submit" name="password" value="Change Password">
            </form>
        </div>
    </div>
</body>
</html>

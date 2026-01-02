<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Hexashop Ecommerce HTML CSS Template</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/adminheader.css' />">
 <!-- <style>/* General Reset */
body, html {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    background-color: #f8f9fa;
}

/* Preloader Styling */
#preloader {
    display: flex;
    align-items: center;
    justify-content: center;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: #ffffff;
    z-index: 1000;
}

#preloader .jumper div {
    width: 15px;
    height: 15px;
    margin: 5px;
    background: #ff5722;
    border-radius: 50%;
    animation: bounce 1s infinite ease-in-out;
}

@keyframes bounce {
    0%, 100% {
        transform: scale(1);
    }
    50% {
        transform: scale(1.5);
    }
}

/* Header Styling */
.header-area {
    background-color: #fff;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    position: sticky;
    top: 0;
    z-index: 100;
    padding: 10px 0;
}

.header-area .container {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.header-area .logo img {
    height: 50px;
    display: block;
}

.header-area .main-nav .nav {
    list-style: none;
    margin: 0;
    padding: 0;
    display: flex;
    gap: 20px;
}

.header-area .main-nav .nav li {
    display: inline-block;
}

.header-area .main-nav .nav li a {
    text-decoration: none;
    color: #333;
    font-size: 16px;
    padding: 10px 15px;
    transition: all 0.3s ease;
}

.header-area .main-nav .nav li a.active,
.header-area .main-nav .nav li a:hover {
    background-color: #ff5722;
    color: #fff;
    border-radius: 5px;
}

/* Utility Classes */
.container {
    width: 90%;
    max-width: 1200px;
    margin: 0 auto;
}

.row {
    display: flex;
    flex-wrap: wrap;
    align-items: center;
}

/* Responsive Styling */
@media (max-width: 768px) {
    .header-area .main-nav .nav {
        flex-direction: column;
        align-items: center;
    }
}
</style>
 -->
</head>

<body>
	
	<!-- ***** Preloader Start ***** -->
	<div>
			<div></div>
			<div></div>
			<div></div>
		
	</div>
	<!-- ***** Preloader End ***** -->


	<!-- ***** Header Area Start ***** -->
	<header class="header-area header-sticky">
		<div class="container">
			<div class="row">
				<div class="col-12">
				
					<nav class="main-nav">
						<!-- ***** Logo Start ***** -->
						<a href="admin_index" class="logo"> <img
							src="${pageContext.request.contextPath}/assets/images/logo.png">
						</a>
						<br><br>
						<!-- ***** Logo End ***** -->
						<!-- ***** Menu Start ***** -->
						<ul class="nav">
							<li class="scroll-to-section"><a href="admin_index" class="active">Home</a></li>
							
 							<li class="scroll-to-section"><a href="addProduct">Add Product</a></li>
 							<li class="scroll-to-section"><a href="product_list">Show Products</a></li>
 							<li class="scroll-to-section"><a href="customer_list">Show Customer</a></li>
 							<li class="scroll-to-section"><a href="accept_order">Orders</a></li>
 							
						</ul>
						
						<!-- ***** Menu End ***** -->
					</nav>
				</div>
			</div>
		</div>
	</header>
	<!-- ***** Header Area End ***** -->
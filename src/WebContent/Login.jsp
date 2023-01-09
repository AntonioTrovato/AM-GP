<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.*, java.util.*"%>
<%  
	Utente utente= (Utente) session.getAttribute("utente");
	if(utente != null){
		response.sendRedirect("/AM-GP/areautenti/MessaggiRicevuti.jsp");
		return;
	}

%>
<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="./css/Style.css" type="text/css" rel="stylesheet">
    
    	<title>AM-GP</title>
  	</head>
  	
	<body>
		<div id ="logoLogin">
			<img id="logoLog" src="./img/logo.png">
		</div> 
		<div id="loginForm_div">
		<span id="errorMessage2"></span>
			<form action="./LoginControl" method="post" id="loginForm">
				<p>ID Utente</p>
				<input type="text" name="userID" placeholder="ID Utente" id="userID"><br>
				<p>Password</p>
				<input type="password" name="password" placeholder="Password" id="userPass"><br>
				<input type="submit" id="loginButton" value="Accedi" onclick="checkLogin();">
				
			</form>
			
			
		</div>
		<script src="/AM-GP/js/loginController.js"></script>
</body>
</html>


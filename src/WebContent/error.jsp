<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String missingDatas = (String) request.getAttribute("missingDatas");
	%>

<!DOCTYPE html>
<html>
<head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="/AM-GP/css/Style.css" type="text/css" rel="stylesheet">
    	<title>ATTENZIONE!</title>
  	</head>
<body>

	
	
	<div id ="logoLogin">
			<img id="logoLog" src="./img/logo.png">
	</div> 
		<div id="error_div">
		<h1 id="errorH1">Ooops!</h1>
			 <p id="errorP"> <%= missingDatas %></p>
		</div>
   

<jsp:include page="/jspComponents/Footer.jsp"></jsp:include>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.*, java.util.*" %>
<!DOCTYPE html>

<%  

	Collection<?> circuiti= (Collection<?>) session.getAttribute("circuiti");
%>

<html>
	<head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="/AM-GP/css/Style.css" type="text/css" rel="stylesheet">
    	<title>Seleziona Circuito</title>
  	</head>
	</head>
	<body>
		<jsp:include page="/jspComponents/Header.jsp"></jsp:include>
		<jsp:include page="/jspComponents/Navbar.jsp"></jsp:include>

		<div id="selezionaCircuitoDiv">
		<p id="pSelezionaCircuito">Selezionare il circuito che si vuole utilizzare:</p>
		<form action="/AM-GP/SetupDispatcherControl" method="POST" id="selectCircuitoForm">
			<select id="selectCircuito" name="id">
			<%	
				if(circuiti != null && circuiti.size()>0) {
					Iterator<?> it  = circuiti.iterator();
					while(it.hasNext()) {
					Circuito circuito = (Circuito )it.next();%> 
				<option value="<%=circuito.getId()%>"><%=circuito.getNome()%></option>
				
 				<%}} %>
			</select><br>
			<input id="buttonSelectCircuito" type="submit" value="Procedi >">
		</form>

			  
			
			
		</div>
		<jsp:include page="/jspComponents/Footer.jsp"></jsp:include>
	</body>
</html>
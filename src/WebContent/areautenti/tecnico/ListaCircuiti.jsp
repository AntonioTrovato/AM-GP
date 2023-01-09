<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.*, java.util.*" %>
<!DOCTYPE html>

<%  
	Collection<Circuito> circuiti = (Collection<Circuito>) session.getAttribute("circuiti");
	if(circuiti == null) {
		response.sendRedirect("/AM-GP/Login.jsp");
	}
%>

<html>
	<head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="/AM-GP/css/Style.css" type="text/css" rel="stylesheet">
    	<title>Circuiti</title>
  	</head>
	</head>
	<body>
		<jsp:include page="/jspComponents/Header.jsp"></jsp:include>
		<jsp:include page="/jspComponents/Navbar.jsp"></jsp:include>

		
		<h1 id="h1Circuiti">CIRCUITI</h1>
		<div id="tableCircuitiDiv">
		<% if(circuiti == null){%>
		 	 	 <p>Nessun circuito presente.</p> 
		<% }else{ %>
			  <table id="tableCircuito">
			 	<tr>
			 		<th>Nome</th>
			 		<th></th>
			 	</tr>
			 <%	
				if(circuiti != null && circuiti.size()>0) {
					Iterator<?> it  = circuiti.iterator();
				while(it.hasNext()) {
					Circuito circuito = (Circuito )it.next();%>
					
				  <tr class="messaggioRiga"><td id="nomeCircuito"><%= circuito.getNome() %></td><td id="pulsanteCircuito">
				  <a href="<%=response.encodeURL("/AM-GP/ViewCircuitoControl?idCircuito="+ circuito.getId()) + "&&page=circuiti"%>">Visualizza</a></td></tr>
			<% }}}%>
			</table>
			
		</div>
		<jsp:include page="/jspComponents/Footer.jsp"></jsp:include>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.*, java.util.*" %>
<!DOCTYPE html>

<%  
	Collection<?> piloti= (Collection<?>) session.getAttribute("piloti");
	Collection<?> utenti= (Collection<?>) session.getAttribute("utenti");	
%>

<html>
	<head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="/AM-GP/css/Style.css" type="text/css" rel="stylesheet">
    	<title>Classifica</title>
  	</head>
	</head>
	<body>
		<jsp:include page="/jspComponents/Header.jsp"></jsp:include>
		<jsp:include page="/jspComponents/Navbar.jsp"></jsp:include>

		
		<h1 id="h1Classifica">CLASSIFICA</h1>
		<div id="tableClassificaDiv">
			<table id="tableSetup">
			 	<tr>
			 		<th>Pilota</th>
			 		<th>Punteggio</th>
			 		<th>Numero Vittorie</th>
			 		<th>Numero Pole</th>
			 		<th>Numero Piazzamenti</th>
			 		<th>Numero Ritiri</th>
			 	</tr>
			 <% if(piloti != null && piloti.size()>0) {
					Iterator<?> it  = piloti.iterator();
				while(it.hasNext()) {
					Pilota pilota = (Pilota )it.next();
					if(utenti != null && utenti.size()>0){
						Iterator<?> itUtenti  = utenti.iterator();
						while(itUtenti.hasNext()) {
							Utente utente = (Utente) itUtenti.next();
							if(utente.getId().equals(pilota.getId())){
					%>
					
				  <tr class="classificaRiga">
				  	<td id="pilotaClass"><%= utente.getNome() %> <%= utente.getCognome() %></td>
				  	<td id="punteggioClass"><%= pilota.getPunteggio() %></td>
				  	<td id="nVittorieClass"><%= pilota.getNumeroVittorie() %></td>
				  	<td id="nPoleClass"><%= pilota.getNumeroPole() %></td>
				  	<td id="nPiazzaClass"><%= pilota.getNumeroPiazzamenti() %></td>
				  	<td id="nRitiriClass"><%= pilota.getNumeroRitiri() %></td>				  	
				  </tr> 
			<%}}}}}%>
			</table>
			
		</div>
		<jsp:include page="/jspComponents/Footer.jsp"></jsp:include>
	</body>
</html>
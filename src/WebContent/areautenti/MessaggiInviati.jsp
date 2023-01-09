<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.*, java.util.*" %>
<!DOCTYPE html>

<%  
	Utente utente= (Utente) session.getAttribute("utente");
	if(utente == null){
		response.sendRedirect("./Login.jsp");
		return;
		}
	Mailbox mailbox = utente.getMailbox();
	
	Collection<?>  messaggiInviati=(Collection<?>) mailbox.getMessaggiInviati();
	Messaggio messaggio;
%>

<html>
	<head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="/AM-GP/css/Style.css" type="text/css" rel="stylesheet">
    	<title>Posta in Arrivo</title>
  	</head>
	</head>
	<body>
		<jsp:include page="/jspComponents/Header.jsp"></jsp:include>
		<jsp:include page="/jspComponents/Navbar.jsp"></jsp:include>
		
		<div id="navMessaggioDiv">
			<table id="tableNavMessaggio">
				<tr id="rigaUnoMessaggio"><td><a href="NuovoMessaggio.jsp">Nuovo Messaggio</a></td></tr>
				<tr id="rigaDueMessaggio"><td><a href="MessaggiRicevuti.jsp">Posta in Entrata</a></td></tr>
				<tr id="rigaTreMessaggio"><td><a href="MessaggiInviati.jsp">Posta Inviata ></a></td></tr>
				</table>
		</div>
		
		
		<div id=tableMessaggi>
		<% if(messaggiInviati.isEmpty()){%>
		   	<p>Nessun messaggio inviato.</p> 
		<% }else{ %>
			<table id="tableMessaggio">
			 	<tr>
			 		<th>Destinatario</th>
			 		<th>Oggetto</th>
			 		<th></th>
			 	</tr>
			 <%	
				if(messaggiInviati != null && messaggiInviati.size()>0) {
					Iterator<?> it  =messaggiInviati.iterator();
				while(it.hasNext()) {
					messaggio = (Messaggio)it.next();  %>
				<tr class="messaggioRiga"><td><%= messaggio.getDestinatario().getNome() %> <%= messaggio.getDestinatario().getCognome() %></td><td><%=messaggio.getOggetto() %></td><td><a href="<%=response.encodeURL("/AM-GP/ViewMessaggioControl?idMessaggio="+ messaggio.getId() + "&&tipoMessaggio=inviato")%>">Visualizza</a></td></tr>
				
			<%}}}%>
			</table>
			
		</div>
		<jsp:include page="/jspComponents/Footer.jsp"></jsp:include>
	</body>
</html>
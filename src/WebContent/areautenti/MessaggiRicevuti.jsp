<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.*, java.util.*" %>
<!DOCTYPE html>

	
<%  
	Utente utente= (Utente) session.getAttribute("utente");
	Mailbox mailbox = utente.getMailbox();
	Collection<Messaggio> messaggiRicevuti =(Collection<Messaggio>) mailbox.getMessaggiRicevuti();
	Messaggio messaggio;
%>

<html>
	<head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="/AM-GP/css/Style.css" type="text/css" rel="stylesheet">
    	<title>Posta in Entrata</title>
  	</head>
	</head>
	<body>
		<jsp:include page="/jspComponents/Header.jsp"></jsp:include>
		<jsp:include page="/jspComponents/Navbar.jsp"></jsp:include>
		
		<div id="navMessaggioDiv">
			<table id="tableNavMessaggio">
				<tr id="rigaUnoMessaggio"><td><a href="/AM-GP/areautenti/NuovoMessaggio.jsp">Nuovo Messaggio</a></td></tr>
				<tr id="rigaDueMessaggio"><td><a href="/AM-GP/areautenti/MessaggiRicevuti.jsp">Posta in Entrata ></a></td></tr>
				<tr id="rigaTreMessaggio"><td><a href="/AM-GP/areautenti/MessaggiInviati.jsp">Posta Inviata</a></td></tr>
				</table>
		</div>
		
		
		<div id=tableMessaggi>
		<% if(messaggiRicevuti.isEmpty()){%>
		 	   <p>Nessun messaggio ricevuto.</p> 
		<% }else{ %>
			 <table id="tableMessaggio">
			 	<tr>
			 		<th>Mittente</th>
			 		<th>Oggetto</th>
			 		<th></th>
			 	</tr>
			 <%if(messaggiRicevuti != null && messaggiRicevuti.size()>0) {
					Iterator<Messaggio> it  =messaggiRicevuti.iterator();
				while(it.hasNext()) {
					messaggio = (Messaggio)it.next();   %>
				  <tr class="messaggioRiga">
				  	<td><%=messaggio.getMittente().getNome()%> <%=messaggio.getMittente().getCognome() %>
				  	</td>
				  	
				  	<td><%=messaggio.getOggetto() %>
				  	</td>
				  	<td>
				 		 <a href="<%=response.encodeURL("/AM-GP/ViewMessaggioControl?idMessaggio="+ messaggio.getId() + "&&tipoMessaggio=ricevuto")%>">Visualizza</a>
				  	</td>
				  </tr>
				
			<%}}}%>
			</table>
			
		</div>
		<jsp:include page="/jspComponents/Footer.jsp"></jsp:include>
	</body>
</html>
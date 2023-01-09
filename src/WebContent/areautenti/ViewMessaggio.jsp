<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.*, java.util.*" %>
<!DOCTYPE html>

<%  
	Utente utente= (Utente) session.getAttribute("utente");
	String idMessaggio = (String)request.getAttribute("idMessaggio");
	String tipoMessaggio =(String)request.getAttribute("tipoMessaggio");
	/*if(utente == null){
		response.sendRedirect("./Login.jsp");
		return;
		}*/
	Mailbox mailbox = utente.getMailbox();
	Collection<Messaggio>  messaggiInviati= mailbox.getMessaggiInviati();
	Collection<Messaggio>  messaggiRicevuti= mailbox.getMessaggiRicevuti();
	Messaggio messaggio;
%>

<html>
	<head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="/AM-GP/css/Style.css" type="text/css" rel="stylesheet">
    	<title>Visualizza Messaggio</title>
  	</head>
	</head>
	<body>
		<jsp:include page="/jspComponents/Header.jsp"></jsp:include>
		<jsp:include page="/jspComponents/Navbar.jsp"></jsp:include>
		
		<div id="navMessaggioDiv">
			<table id="tableNavMessaggio">
				<tr id="rigaUnoMessaggio"><td><a href="./areautenti/NuovoMessaggio.jsp">Nuovo Messaggio</a></td></tr>
				<% if(tipoMessaggio.equals("ricevuto")){ %>
				<tr id="rigaDueMessaggio"><td><a href="./areautenti/MessaggiRicevuti.jsp">Posta in Entrata ></a></td></tr>
				<%}else{ %>
				<tr id="rigaDueMessaggio"><td><a href="./areautenti/MessaggiRicevuti.jsp">Posta in Entrata</a></td></tr>
				<%} %>
				<% if(tipoMessaggio.equals("inviato")){ %>
				<tr id="rigaTreMessaggio"><td><a href="./areautenti/MessaggiInviati.jsp">Posta Inviata ></a></td></tr>
				<%}else{ %>
				<tr id="rigaTreMessaggio"><td><a href="./areautenti/MessaggiInviati.jsp">Posta Inviata</a></td></tr>
				<%} %>
				</table>
		</div>
		
		<%
			if(tipoMessaggio.equals("ricevuto")){
				if(messaggiRicevuti != null && messaggiRicevuti.size()>0) {
					Iterator<?> it  =messaggiRicevuti.iterator();
					while(it.hasNext()) {
						messaggio = (Messaggio)it.next();
						String id= messaggio.getId() + "";
						if(id.equals(idMessaggio)){
			%>
		<div id=viewMessaggio>
			<p>Mittente: <%=messaggio.getMittente().getNome() %> <%=messaggio.getMittente().getCognome() %></p>
			<p>Destinatario: <%= utente.getNome() %> <%= utente.getCognome() %> </p>
			<p>Oggetto: <%=messaggio.getOggetto() %>  </p>
				<textarea id="textareaView" readonly ><%=messaggio.getCorpo() %></textarea>
		</div>
			<%}}}}
				else if(tipoMessaggio.equals("inviato")){
					if(messaggiInviati != null && messaggiInviati.size()>0) {
						Iterator<?> it = messaggiInviati.iterator();
						while(it.hasNext()) {
							messaggio = (Messaggio)it.next();
							String id= messaggio.getId() + "";
							if(id.equals(idMessaggio)){
					%>
			<div id=viewMessaggio>
			<p>Mittente: <%= utente.getNome() %> <%= utente.getCognome() %></p>
			<p>Destinatario: <%= messaggio.getDestinatario().getNome() %> <%= messaggio.getDestinatario().getCognome() %></p>
			<p>Oggetto: <%=messaggio.getOggetto() %>  </p>
			<textarea id="textareaView" readonly ><%=messaggio.getCorpo() %></textarea>
		</div>
		<%}}}}%>
		<jsp:include page="/jspComponents/Footer.jsp"></jsp:include>
	</body>
</html>
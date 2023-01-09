<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.*"%>
<!DOCTYPE html>
<%
	Utente utente = (Utente)session.getAttribute("utente");
%>
<html>
	<head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="/AM-GP/css/Style.css" type="text/css" rel="stylesheet">
    	<title>Nuovo Messaggio</title>
  	</head>
	</head>
	<body>
		<jsp:include page="/jspComponents/Header.jsp"></jsp:include>
		<jsp:include page="/jspComponents/Navbar.jsp"></jsp:include>
		
		<div id="navMessaggioDiv">
			<table id="tableNavMessaggio">
				<tr id="rigaUnoMessaggio"><td><a href="NuovoMessaggio.jsp">Nuovo Messaggio > </a></td>
				<tr id="rigaDueMessaggio"><td><a href="MessaggiRicevuti.jsp">Posta in Entrata</a></td>
				<tr id="rigaTreMessaggio" ><td><a href="MessaggiInviati.jsp">Posta Inviata</a></td>
				</table>
		</div>
		

		<div id=formNuovoMessaggioDiv>	
			<form action="/AM-GP/SendMessageControl" method="post" id="nuovoMessaggioForm">
			
			<div id="divRuolo">
			<label for="ruolo">Ruolo:</label>
			<select name="ruolo" id="ruoloMessaggio">
			<option value="" selected></option>
   			<option value="tecnico">Tecnico</option>
    		<option value="pilota">Pilota</option>
    		<option value="stratega">Stratega</option>
 			</select>
 			</div>
  			<br>
  			<div id="divDestinatario">
			<label for="destinatario" id="labelDestinatarioNuovoMess">Destinatario:</label>
			<span id="dynamicSelect"><select id="destinatariMessaggio" hidden></select></span>
 			<label for="checkNuovoMessaggio">Invia a tutti</label>
 			<input type="checkbox" id="checkNuovoMessaggio" name="checkNuovoMessaggio" value="tutti"></div>
 			<br>
 			<div id="divOggetto">
 			<label for="oggetto">Oggetto:</label>
 			<input type="text" id="oggettoNuovoMessaggio" name="oggettoNuovoMessaggio"> </div><br>
 			<div id="divCorpo">
    		<textarea style="resize:none"rows="20" cols="70" id="corpoNuovoMessaggio" name="corpoNuovoMessaggio"></textarea><br>
 			</div>
 			<%  if(utente instanceof Tecnico){ %>
 			<div id="divCaricaFile">
    		<input type ="file">
 			</div>
 			<%} %>
 			
  			<input id="buttonNuovoMessaggio" type="submit" value="INVIA">
  			
			</form>
			<span id="errorMessage2" style="background-color: #cb2929;
		color: #FFFFFF;
		font-size: 12px;
		font-family: Arial;
		padding: 10px 15px;
		box-shadow: 5px 5px black;
		display: none"
		></span>
		</div>
		<script src="/AM-GP/js/nuovoMessaggioFormController.js"></script>
		<script src="/AM-GP/js/dynamicSelect.js"></script>
		<jsp:include page="/jspComponents/Footer.jsp"></jsp:include>
	</body>
</html>
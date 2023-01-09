<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="/AM-GP/css/Style.css" type="text/css" rel="stylesheet">
    	<title>Gestione Setup</title>
  	</head>
	</head>
	<body>
		<jsp:include page="/jspComponents/Header.jsp"></jsp:include>
		<jsp:include page="/jspComponents/Navbar.jsp"></jsp:include>
		<div id="gestioneSetupDiv">
			<h1>GESTIONE SETUP</h1>
			<p>Crea un nuovo file o carica un file .stp per poterlo modificare </p>
			
				<div id="nuovoSetup"><a href="/AM-GP/SelezionaCircuitoControl">Nuovo Setup</a></div>
				<div id="caricaSetup"><a href=#>Carica Setup</a></div>	
		</div>
		
		<jsp:include page="/jspComponents/Footer.jsp"></jsp:include>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.*, java.util.*" %>
<!DOCTYPE html>
<%  
	Setup setup=(Setup) request.getAttribute("setup");
	if(setup == null){
		
	}
%>
<html>
	<head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="/AM-GP/css/Style.css" type="text/css" rel="stylesheet">
    	<title>Modifica Setup</title>
  	</head>
	</head>
	<body>
		<jsp:include page="/jspComponents/Header.jsp"></jsp:include>
		<jsp:include page="/jspComponents/Navbar.jsp"></jsp:include>
		<div  id="h1GestioneSetup">
			<h1>Modifica Setup</h1>
			</div>
			<div id="containerGestioneSetup">
			<span id="errorMessage2" style="background-color: #cb2929;
		color: #FFFFFF;
		font-size: 12px;
		font-family: Arial;
		padding: 10px 15px;
		box-shadow: 5px 5px black;
		display: none"
		></span>
				<form id="formGestioneSetup" action="/AM-GP/UploadSetupControl" method="POST">
					<div id="containerLabel">
						<div>
							<label for="CAA">Carico Areodinamico Anteriore:&emsp;&emsp;</label><input  class=".range" type="text" min="1" max="10" value="<%=setup.getCaricoAerodinamicoAnteriore()%>"  id="CAA" name="caricoAnt" placeholder="min:1 - max:10"><br>
						</div>
						<div>
							<label for="CAP">Carico Areodinamico Posteriore:&emsp;&ensp;</label><input  class=".range" type="text" min="1" max="10" value="<%=setup.getCaricoAerodinamicoPosteriore() %>"  id="CPP" name="caricoPost" placeholder="min:1 - max:10"><br>
						</div>
						<div>
							<label for="CampA">Campanatura Anteriore:&emsp;&emsp;&emsp;&emsp;&emsp;</label><input  class=".range" type="text" min="-5" max="5" value="<%=setup.getCampanaturaAnteriore() %>"  id="CampA" name="campanAnt"  placeholder="min:-5 - max:5"><br>
						</div>
						<div>
							<label for="CampP">Campanatura Posteriore:&emsp;&emsp;&emsp;&emsp;&ensp;</label><input  class=".range" type="text" min="-5" max="5" value="<%= setup.getCampanaturaPosteriore()%>" id="CampP" name="campanPost"  placeholder="min:-5 - max:5"><br>
						</div>
						<div>
							<label for="ConvA">Convergenza Anteriore:&emsp;&emsp;&emsp;&emsp;&emsp;</label><input  class=".range" type="text" min="-1" max="1" value="<%=setup.getConvergenzaAnteriore() %>" id="ConvA" name="converAnt" placeholder="min:-1 - max:1"><br>
						</div>
						<div>
							<label for="ConvP">Convergenza Posteriore:&emsp;&emsp;&emsp;&emsp;&ensp;</label><input  class=".range" type="text" min="-1" max="1" value="<%=setup.getConvergenzaPosteriore()%>" id="ConvP" name="converPost" placeholder="min:-1 - max:1"><br>
						</div>
						<div>
							<label  for="PressF">Pressione Freni:&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;</label><input  class=".range"  type="text" min="0" max="100" value="<%=setup.getPressioneFreni() %>"  id="PressF" name="pressFren" placeholder="min:0% - max:100%"><br>
						</div>
						<div>
							<label for="BAP">Barra Antirollio Posteriore:&emsp;&emsp;&emsp;&emsp;</label><input    class= ".range" type="text" min="1" max="10" value="<%=setup.getBarraAntirollioPosteriore()%>" id="BAP" name="barrPost" placeholder="min:1 - max:10"><br>
						</div>
						<div>
							<label for="BAA">Barra Antirollio Anteriore:&emsp;&emsp;&emsp;&emsp;&ensp;</label><input   class=".range" type="text" min="1" max="10" value="<%= setup.getBarraAntirollioAnteriore()%>"  id="BAA" name="barrAnt" placeholder="min:1 - max:10"><br>
						</div>
					</div>
					<div id="buttonGroupModSetup">
						<input id="buttonSalva" type="submit" name="salva"  value="SALVA">
					</div>
				</form>
			</div>
		<script src="/AM-GP/js/nuovoSetupController.js"></script>
		<jsp:include page="/jspComponents/Footer.jsp"></jsp:include>
	</body>
</html>
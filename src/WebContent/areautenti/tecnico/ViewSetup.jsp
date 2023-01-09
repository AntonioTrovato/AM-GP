<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.*, java.util.*" %>
<!DOCTYPE html>
<%  

	Tecnico tecnico = (Tecnico)session.getAttribute("utente");
	Collection<?> listaSetup= (Collection<?>) tecnico.getSetupList();
	if(listaSetup == null) {
		response.sendRedirect(response.encodeRedirectURL("./ViewCircuitoControl"));
	return;
}
%>
<html>
	<head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="/AM-GP/css/Style.css" type="text/css" rel="stylesheet">
    	<title>Setup</title>
  	</head>
	</head>
	<body>
		<jsp:include page="/jspComponents/Header.jsp"></jsp:include>
		<jsp:include page="/jspComponents/Navbar.jsp"></jsp:include>
		<%
					
		if(listaSetup != null && listaSetup.size() > 0) {	
			Iterator<?> it  = listaSetup.iterator();
			while(it.hasNext()) {
				Setup setup = (Setup)it.next();	
				int idSetup = Integer.parseInt((String)request.getAttribute("idSetup"));
				int id= setup.getId();
				if(id==idSetup){					

			
		%>
		<h1 id="h1ViewSetup">SETUP  n.<%=setup.getId()%></h1>
		<div id="containerSetup">
			<div id="pViewSetup">
			<p style="font-weight:bold">Carico Areodinamico Anteriore: <span style="font-weight:normal" ><%=setup.getCaricoAerodinamicoAnteriore() %></span></p>
			<p style="font-weight:bold">Carico Areodinamico Posteriore: <span style="font-weight:normal" ><%=setup.getCaricoAerodinamicoPosteriore() %></span></p>
			<p style="font-weight:bold">Campanatura Anteriore: <span style="font-weight:normal" ><%=setup.getCampanaturaAnteriore() %></span></p>
			<p style="font-weight:bold">Campanatura Posteriore: <span style="font-weight:normal" ><%=setup.getCampanaturaPosteriore() %></span></p>
			<p style="font-weight:bold">Convergenza Anteriore: <span style="font-weight:normal" ><%=setup.getConvergenzaAnteriore()%></span></p>
			<p style="font-weight:bold">Convergenza Posteriore: <span style="font-weight:normal" ><%=setup.getConvergenzaPosteriore() %></span></p>
			<p style="font-weight:bold">Pressione Freni: <span style="font-weight:normal" ><%=setup.getPressioneFreni() %></span> </p>
			<p style="font-weight:bold">Barra Antirollio Posteriore: <span style="font-weight:normal" ><%=setup.getBarraAntirollioPosteriore() %></span></p>
			<p style="font-weight:bold">Barra Antirollio Anteriore: <span style="font-weight:normal" ><%= setup.getBarraAntirollioAnteriore()%></span></p>
			<p style="font-weight:bold">Circuito: <span style="font-weight:normal" ><%= setup.getCircuito().getNome() %> <a href="<%=response.encodeURL("ViewCircuitoControl?idCircuito="+ setup.getCircuito().getId())+"&&page="+idSetup %>" >Visualizza</a></span></p>
			</div>
		</div>
		<%}}} %>
		<div id="pulsanteRitorno">
			<p><a href="/AM-GP/areautenti/tecnico/ListaSetup.jsp">←</a></p>
		</div>
		<jsp:include page="/jspComponents/Footer.jsp"></jsp:include>
	</body>
</html>
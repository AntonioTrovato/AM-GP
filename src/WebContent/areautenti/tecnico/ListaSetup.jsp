<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.*, java.util.*" %>
<!DOCTYPE html>

<%  
	Tecnico tecnico = (Tecnico) session.getAttribute("utente");
	Collection<Setup> listaSetup= (Collection<Setup>) tecnico.getSetupList();
	String error = (String)request.getAttribute("error");
	if(listaSetup == null && error == null) {
		response.sendRedirect(response.encodeRedirectURL("./ListaSetupControl"));
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

		
		<h1 id="h1SetupList">Lista Setup</h1>
		<div id="tableSetupDiv">
		<% if(listaSetup.isEmpty()){%>
		 	 	 <p>Nessun setup presente.</p> 
		<% }else{ %>
			<table id="tableSetup">
			 	<tr>
			 		<th>CIRCUITO</th>
			 		<th>DATA</th>
			 		<th></th>
			 		<th></th>
			 		<th></th>
			 	</tr>
			 <%
				if(listaSetup != null && listaSetup.size() >0) {
					Iterator<Setup> it  = listaSetup.iterator();
				while(it.hasNext()) {
					Setup setup = (Setup)it.next(); 
					int id= setup.getId(); %>
					
				  <tr class="setupRiga">
				  <td id="idSetup"><%= setup.getCircuito().getNome() %></td>
				  <td id="dataSetup"><%= setup.getDate() %></td>
				  <td id="pulsanteViewSetup"><a id="linkSetup" href="<%=response.encodeURL("/AM-GP/ViewSetupControl?idSetup="+ id)%>">Visualizza</a></td>
				  <td id="rigModificaSetup"><a id="modificaSetup"  href="<%=response.encodeURL("/AM-GP/ModificaSetupControl?idSetup="+ id) %>">Modifica</a></td>
				  <td id="eliminaSetupTD"><a id="eliminaSetup"  href="<%=response.encodeURL("/AM-GP/DeleteSetupControl?idSetup="+ id)%>"><i class="far fa-trash-alt"></i></a></td>

				  </tr> 
			<%}}}%>
			</table>
			
		</div>
		<jsp:include page="/jspComponents/Footer.jsp"></jsp:include>
	</body>
</html>
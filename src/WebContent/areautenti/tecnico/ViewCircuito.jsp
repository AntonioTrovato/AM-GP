<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.*, java.util.*" %>
<!DOCTYPE html>
<%  

	Collection<?> listaCircuiti= (Collection<?>) request.getAttribute("circuiti");
	Collection<?> curve= (Collection<?>) request.getAttribute("curve");
	Collection<?> rettilinei= (Collection<?>) request.getAttribute("rettilinei");
	String error = (String)request.getAttribute("error");
	String pag = (String)request.getAttribute("page");
	if(listaCircuiti == null && rettilinei == null && curve == null && error == null) {
		response.sendRedirect(response.encodeRedirectURL("./ViewCircuitoControl"));
	return;
	}
%>

<html>
	<head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="/AM-GP/css/Style.css" type="text/css" rel="stylesheet">
    	<title>Circuito</title>
  	</head>
	</head>
	<body>
		<jsp:include page="/jspComponents/Header.jsp"></jsp:include>
		<jsp:include page="/jspComponents/Navbar.jsp"></jsp:include>
		<%
	
		if(listaCircuiti != null && listaCircuiti.size() > 0) {	
			Iterator<?> it  = listaCircuiti.iterator();
			while(it.hasNext()) {
				Circuito circuito = (Circuito)it.next();	
				String idCircuito = (String)request.getAttribute("idCircuito");
				String id= circuito.getId() + "";
				
				if(id.equals(idCircuito)){
			
		%>
		<h1 id="h1ViewCircuito">CIRCUITO: <%circuito.getId(); %></h1>
		<div id="containerCircuito">
			<div id="pViewCircuito">
			<p style="font-weight:bold">Sede: <span style="font-weight:normal" ><%=circuito.getSede() %> </span> </p>
			<p style="font-weight:bold">Lunghezza: <span style="font-weight:normal" > <%=circuito.getLunghezza() %></span> </p>
			<p style="font-weight:bold">Meteo: <span style="font-weight:normal" > <%=circuito.getMeteo() %></span></p>
			<p style="font-weight:bold">Tempo di percorrenza medio per giro: <span style="font-weight:normal" > <%= circuito.getTpm() %></span> secondi </p>
			<p style="font-weight:bold">Record di percorrenza medio per giro: <span style="font-weight:normal" > <%=circuito.getRpm() %> </span> secondi</p>
			<p style="font-weight:bold">Umidità: <span style="font-weight:normal" ><%=circuito.getUmidita() %></span>%</p>
			<p style="font-weight:bold">Curve: <%if(curve.size()<=0) %><span style="font-weight:normal" >nessuna curva</span></p>
			<%
			
		 if(curve != null && curve.size() > 0) {	
				Iterator<?> itCurve  = curve.iterator();
				while(itCurve.hasNext()) {
					Curva curva = (Curva)itCurve.next();	
			 %>
			<p style="font-weight:bold">- Nome:<span style="font-weight:normal" > <%=curva.getNome() %></span>   Angolo: <span style="font-weight:normal" ><%=curva.getAngolo() %></span></p>
			<%}} %>
			<p style="font-weight:bold">Rettilinei: <%if(rettilinei.size()<=0) %><span style="font-weight:normal" >nessun rettilineo</span></p>
			<%
		
			if(rettilinei != null && rettilinei.size() > 0) {	
				Iterator<?> itRettilinei  = rettilinei.iterator();
				while(itRettilinei.hasNext()) {
					Rettilineo rettilineo = (Rettilineo)itRettilinei.next();	
			 %>
			<p style="font-weight:bold">- Nome: <span style="font-weight:normal" ><%=rettilineo.getNome() %></span>   Lunghezza:<span style="font-weight:normal" > <%=rettilineo.getLunghezza()%></span></p>
			<%}} %>
		
			</div>
				<img src="./getPicture?id=<%=circuito.getId() %>">
		</div>
		<%}}} %>
		<div id="pulsanteRitorno">
		<%if(pag.equals("circuiti")){ %>
			<p><a href="/AM-GP/areautenti/tecnico/ListaCircuiti.jsp">←</a></p>
			<%}else{ %>
			<p><a href="<%=response.encodeURL("ViewSetupControl?idSetup="+ pag)%>">←</a></p>
			<%} %>
			
		
		</div>
		<jsp:include page="/jspComponents/Footer.jsp"></jsp:include>
	</body>
</html>
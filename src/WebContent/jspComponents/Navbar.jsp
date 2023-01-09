<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.*" %>
<!DOCTYPE html>
	
<html>
	<head>
		<meta charset="UTF-8">
 		<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
   	 	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.css">
   		<link rel="stylesheet" href="/AM-GP/css/Style.css">
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<title>AM-GP</title>
	</head>
	
	<body>
 
		<nav>
			<div id= "navSandwich"><span class="toggle"><i class="fa fa-bars"></i></span></div>
			<div id=navDiv>
			<%
		Utente utente =(Utente) session.getAttribute("utente");
			if(utente instanceof Tecnico){
		%>	
		
				
					<ul class="topNav"> 
      					<li><a href="/AM-GP/areautenti/MessaggiRicevuti.jsp">CASELLA DI POSTA</a></li>
      					<li><a href="/AM-GP/areautenti/tecnico/SceltaSetup.jsp">GESTIONE SETUP</a></li>
      					<li><a href="/AM-GP/areautenti/tecnico/ListaSetup.jsp">SETUP</a></li>
              			<li><a href="/AM-GP/areautenti/tecnico/ListaCircuiti.jsp">CIRCUITI</a></li>
              			<li><a href="/AM-GP/LogoutControl">LOGOUT</a></li>
      			</ul>
      		<% }else if(utente instanceof Pilota){%>
 			 		<ul class="topNav"> 
      					<li><a href="/AM-GP/areautenti/MessaggiRicevuti.jsp">CASELLA DI POSTA</a></li>
      					<li><a href="/AM-GP/areautenti/pilota/Classifica.jsp">CLASSIFICA</a></li>
      					<li><a href="/AM-GP/LogoutControl">LOGOUT</a></li>
      				</ul> 
 				
      			<%} %>
      		</div>
      		</nav>
      		
      
   <script>

 	$('.toggle').click(function(){
 		if($('.topNav').css('display') == 'block'){
 			$('.topNav').css("display", "none");
 		}else{
 			$('.topNav').css("display", "block");
 		}
  	});
 	
 	
 	$(window).resize(function(){
 		 var width = $(document).width();
 		if (width <= 768) {
 			i=1;
 	    	$('.topNav').css("display", "none");
 		}else if(width<= 1120 && width>= 768){
 			$('.topNav').css("display", "none");
 	    }else {
 	    	$('.topNav').css("display", "block");
 	   
 		}});
 		
 		


   </script>

      		
      		   		
</html>
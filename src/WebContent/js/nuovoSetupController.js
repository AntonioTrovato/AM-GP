var formGestioneSetup= document.getElementById("formGestioneSetup");
var caa= document.getElementById("CAA");
var cap= document.getElementById("CPP");
var CampA= document.getElementById("CampA");
var CampP=document.getElementById("CampP");
var ConvA=document.getElementById("ConvA");
var ConvP=document.getElementById("ConvP");
var PressF=document.getElementById("PressF");
var bap=document.getElementById("BAP");
var baa=document.getElementById("BAA");
var errorMessage2=document.getElementById("errorMessage2");
var buttonSalva= document.getElementById("buttonSalva");

formGestioneSetup.addEventListener("input", function(){
	
	if((caa.value < 1) || (caa.value > 10) || (caa==null) || (caa.value=="")){
		errorMessage2.style.display = "inline";
		errorMessage2.textContent="Carico Aereodinamico Anteriore è fuori dal range"; 
		buttonSalva.setAttribute("disabled", true);
		
		return;
	}
	
	if((cap.value < 1) || (cap.value > 10) || (cap==null) || (cap.value=="")){
		errorMessage2.style.display = "inline";
		errorMessage2.textContent="Carico Aereodinamico Posteriore fuori dal range"; 
		buttonSalva.setAttribute("disabled", true);
		
		return;
	}
	
	
	if((CampA.value < -5) || (CampA.value > 5) || (CampA==null) || (CampA.value=="")){
		errorMessage2.style.display = "inline";
		errorMessage2.textContent="Campanatura Anteriore fuori dal range"; 
		buttonSalva.setAttribute("disabled", true);
		
		return;
	}
	
	if((CampP.value < -5) || (CampP.value > 5) || (CampP==null) || (CampP.value=="")){
		errorMessage2.style.display = "inline";
		errorMessage2.textContent="Campanatura Posteriore fuori dal range"; 
		buttonSalva.setAttribute("disabled", true);
		
		return;
	}
	
	if((ConvA.value < -1) || (ConvA.value > 1) || (ConvA==null) || (ConvA.value=="")){
		errorMessage2.style.display = "inline";
		errorMessage2.textContent="Convergenza Anteriore fuori dal range"; 
		buttonSalva.setAttribute("disabled", true);
		
		return;
	}
	
	if((ConvP.value < -1) || (ConvP.value > 1) || (ConvP==null) || (ConvP.value=="")){
		errorMessage2.style.display = "inline";
		errorMessage2.textContent="Convergenza Posteriore fuori dal range"; 
		buttonSalva.setAttribute("disabled", true);
		
		return;
	}
	
	if((PressF.value < 0) || (PressF.value > 100) || (PressF==null) || (PressF.value=="")){
		errorMessage2.style.display = "inline";
		errorMessage2.textContent="Pressione dei freni fuori dal range"; 
		buttonSalva.setAttribute("disabled", true);
		
		return;
	}
	
	if((bap.value < 1) || (bap.value > 10) || (bap==null) || (bap.value=="")){
		errorMessage2.style.display = "inline";
		errorMessage2.textContent="Barra Antirollio Posteriore fuori dal range"; 
		buttonSalva.setAttribute("disabled", true);
		
		return;
	}
	
	if((baa.value < 1) || (baa.value > 10) || (baa==null) || (baa.value=="")){
		errorMessage2.style.display = "inline";
		errorMessage2.textContent="Barra Antirollio Anteriore fuori dal range"; 
		buttonSalva.setAttribute("disabled", true);
		
		return;
	}
	
	errorMessage2.style.display="none";
	buttonSalva.removeAttribute("disabled");
})
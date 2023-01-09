var nuovoMessaggioForm= document.getElementById("nuovoMessaggioForm");
var ruolo=document.getElementById("ruoloMessaggio");
var corpoNuovoMessaggio=document.getElementById("corpoNuovoMessaggio");
var oggettoNuovoMessaggio=document.getElementById("oggettoNuovoMessaggio");
var destinatariMessaggio=document.getElementById("destinatariMessaggio");
var errorMessage2=document.getElementById("errorMessage2");
var buttonNuovoMessaggio= document.getElementById("buttonNuovoMessaggio");

nuovoMessaggioForm.addEventListener("input", function(){
	
	if(ruolo.value != "tecnico" && ruolo.value !="pilota"){
		errorMessage2.style.display="inline";
		errorMessage2.textContent="Il ruolo scelto non è corretto"; //controllare se prende le accentate
		buttonNuovoMessaggio.setAttribute("disabled", true);
		
		return;
	}
	
	if(oggettoNuovoMessaggio.value=="" || oggettoNuovoMessaggio==null){
		errorMessage2.style.display="inline";
		errorMessage2.textContent="L'oggetto del messaggio è vuoto! Non puoi inviare un messaggio con un oggetto vuoto";
		buttonNuovoMessaggio.setAttribute("disabled", true);
		
		return;
	}
	
	if(oggettoNuovoMessaggio.value.length>30){
		errorMessage2.style.display="inline";
		errorMessage2.textContent="L'oggetto del messaggio è troppo lungo!";
		buttonNuovoMessaggio.setAttribute("disabled", true);
		
		return;
	}
	
	if(destinatariMessaggio.value="" && destinatariMessaggio==null){
		errorMessage2.style.display="inline";
		errorMessage2.textContent="Il destinatario è vuoto! Non puoi inviare un messaggio con un destinatario vuoto";
		buttonNuovoMessaggio.setAttribute("disabled", true);
		
		return;
	}
	
	if(corpoNuovoMessaggio.value.length > 700){
		errorMessage2.style.display="inline";
		errorMessage2.textContent="Il messaggio è troppo lungo!";
		buttonNuovoMessaggio.setAttribute("disabled", true);
		
		return;
	}
	
	errorMessage2.style.display="none";
	buttonNuovoMessaggio.removeAttribute("disabled");

});
ruoloElement = document.getElementById("ruoloMessaggio");
dynamicSelectSpan = document.getElementById("dynamicSelect");
var ruoloDestinatario;

ruoloElement.addEventListener("change", function() {
	if(this.value == "tecnico") {
		ruoloDestinatario = "tecnico";
	}else if(this.value == "pilota") {
		ruoloDestinatario = "pilota";
	}else if(this.value == "stratega"){
		ruoloDestinatario = "stratega";
	}else {
		return;
	}
	ajaxRequest(this.value)
});

function ajaxRequest(ruolo) {
	var xmlhttp = new XMLHttpRequest();
	var url = "/AM-GP/DynamicSelectControl?ruolo="+ruolo;
	
	xmlhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	        var destinatari = JSON.parse(this.responseText);
	        showDestinatari(destinatari);
	    }
	};
	
	xmlhttp.open("GET", url, true);
	xmlhttp.send();
}

function showDestinatari(destinatari) {
	document.getElementById("destinatariMessaggio").remove();
	if(destinatari=="") {
		element = "<select id='destinatariMessaggio' name='destinatari'>"+
		"<option value=''>Nessun destinatario</option></select>";
		dynamicSelectSpan.innerHTML += element;
	}
	
	destinatariElement = "<select id='destinatariMessaggio' name='destinatari'>";
	var i;
	
	for(i = 0; i < destinatari.length; i++) {
		destinatariElement = destinatariElement + "<option value='"+destinatari[i].id+"'>"+
		destinatari[i].nome+" "+destinatari[i].cognome+"</option>";
	}
	
	destinatariElement + destinatariElement + "</select>";
	dynamicSelectSpan.innerHTML += destinatariElement;
}
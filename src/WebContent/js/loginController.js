var errorMessage2 = document.getElementById("errorMessage2");
var loginForm = document.getElementById("loginForm");
var loginButton = document.getElementById("loginButton");
var userID = document.getElementById("userID");
var userPass = document.getElementById("userPass");

var userIDRegex = new RegExp("^[A-Za-z0-9]{14}$");
var userPassRegex = new RegExp("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}");

loginForm.addEventListener("input", function() {
	if((userID.value == null) || (userID.value.length != 14) || (userIDRegex.exec(userID.value)==null)) {
		errorMessage2.style.display="inline";
		errorMessage2.textContent="Il formato dell'id non è corretto"; //controllare se prende le accentate
		loginButton.setAttribute("disabled", true);
		
		return;
	}
	
	if((userPass.value == null) || (userPass.value.length < 8) || (userPassRegex.exec(userPass.value)==null)) {
		errorMessage2.style.display="inline";
		errorMessage2.textContent="Il formato della password non è corretto"; //controllare se prende le accentate
		loginButton.setAttribute("disabled", true);
		
		return;
	}
	
	errorMessage2.style.display="none";
	loginButton.removeAttribute("disabled");
})
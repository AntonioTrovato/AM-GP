function checkLogin(){
	 var userPassword=document.getElementById("userPass");
	 var passFormat =/^[0-9a-zA-Z]{14}$/
	 if(userPass.value.match(passFormat))
	 {
		 return true;
	 }
	 else
	 {
		 alert("FORMATO USER ERRATO!");
		 event.preventDefault();
		userPass.focus();
		 return false;
	 }
}

	
 
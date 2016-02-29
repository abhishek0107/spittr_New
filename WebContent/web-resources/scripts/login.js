function validateLogin(){
	if(document.getElementById("user-email").value==""){
		alert("Email is mandatory.");
		return false;
	}
	if(document.getElementById("user-pw").value==""){
		alert("Email is mandatory.");
		return false;
	}
	return true;
}

function validateSignup(){
	if(document.getElementById("user-fname").value==""){
		alert("Name is mandatory.");
		return false;
	}
	if(document.getElementById("usreml").value==""){
		alert("Email is mandatory.");
		return false;
	}
	if(document.getElementById("password").value==""){
		alert("password is mandatory.");
		return false;
	}
	if(document.getElementById("user-pw-repeat").value==""){
		alert("Please confirm password");
		return false;
	}
	return true;
}
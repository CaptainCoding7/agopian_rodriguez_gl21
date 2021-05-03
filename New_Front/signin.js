// sign in submition	
		
		
function putServerData(url, data, success){

    $.ajax({
		type: 'PUT',	
        url: url, 
		data: data,
		contentType : 'application/json',
        dataType: "json"
    }).done(success);
}


function callDone(result){
	
		
	if(JSON.parse(result)==true){
		console.log("Account successfully created");
		localStorage.setItem('user', JSON.stringify(newUser));
		document.location.href = "home.html";
	}
	else{
		console.log("Account creation failed")	;	
		alert("Mail already used !");

		document.location.href = "Sign-in.html";
	}
}
		

var newUser;

$(document).ready(function() {
	
	
	$("#butAddUser").click(function() {
		
		console.log("create user");

		newUser = {
			mail : $("#Email").val(),
			pwd : $("#Password").val(),
			firstName : $("#FirstName").val(),
			lastName : $("#LastName").val(),
			phoneNumber : $("#PhoneNumber").val(),
			livingLocation : $("#livLoc").val(),
			bookedFlightsList : null,
			birthday : "1999-04-19"
		};
		
		putServerData("ws/user/createuser",JSON.stringify(newUser),callDone);
		
	});
});
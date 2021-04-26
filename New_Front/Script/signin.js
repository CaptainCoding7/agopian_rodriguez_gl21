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
	var templateExample = _.template($('#templateExample').html());
	
	var html = templateExample({
		//"attribute":JSON.stringify(result[0].flightID)
		"attribute":JSON.stringify(result)
	});
	//https://makitweb.com/return-json-response-ajax-using-jquery-php/
	$("#result").append(html);
}

		


$(document).ready(function() {
	
	
	$("#butAddUser").click(function() {
		
		console.log("create user");

		var newUser = {
			mail : $("#Email").val(),
			pwd : $("#Password").val(),
			firstName : $("#FirstName").val(),
			lastName : $("#LastName").val(),
			phoneNumber : $("#PhoneNumber").val(),
			livingLocation : $("#livLoc").val(),
			bookedFlightsList : null,
			birthday : "1999-04-19"
		};
		
		putServerData("ws/passenger/createuser",JSON.stringify(newUser),callDone);
		
	});
})
function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

function postServerData(url, data, success){

    $.ajax({
		type: 'POST',	
        url: url,
		data: data,
		contentType : 'application/json',
        dataType: "json"
    }).done(success);
}

function callDone(result){
	
		
	//https://makitweb.com/return-json-response-ajax-using-jqueryif-php/
	//if((html.textContent=html.textContent.replace(/[^a-zA-Z0-9.\/]/g, "")) == "true"){
	if(result!=null){
		localStorage.setItem('user', JSON.stringify(result));

		alert("You have logged in.");
		document.location.href = "home.html";
		let test = localStorage.getItem('user');
		console.log(test);
	}
	else
	{
		alert("Something wrong happened during the connection \n Your Email or Password is incorrect");
		location.reload();
		document.location.href = "Log-in.html";
	}
}


$(function(){

	$("#loginButton").click(function(){				

	var user = {
		email : $("#email").val(),
		pwd : $("#password").val()
		}
		
	if($("#email").val() == "")
		{
			console.log("email is null");
			return false;
		}
		
	if($("#password").val() == "")
		{
			console.log("password is null");
			return false;
		}
		
	postServerData("ws/user/login",JSON.stringify(user),callDone);
	
	});

});
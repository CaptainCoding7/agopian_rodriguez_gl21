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

function putServerData(url, data, success){

    $.ajax({
		type: 'PUT',	
        url: url, 
		data: data,
		contentType : 'application/json',
        dataType: "json"
    }).done(success);
}

function deleteServerData(url, success){

    $.ajax({
		type: 'DELETE',	
        url: url, 
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


$(function(){

	$("#butFlightsList").click(function(){

		var data = {
			plane : "Cessna 172",
			price : 50,
			destination : "Amsterdam",
			seats : 0
			//depDate : "2020-12-03T10:15:30"
		}
		var plane = "Cessa 172";
		
		var dataJson = JSON.stringify(data);
		//getServerData("ws/flight/flightsList/Cessna 172/50/Amsterdam/0",callDone);
		postServerData("ws/flight/flightsList",dataJson,callDone);
	});

	$("#butFlightInfo").click(function(){
		getServerData("ws/flight/flightInfo/2",callDone);
	});

	$("#butAddFlight").click(function(){
		var data = {
	        id: 1
	    };
		putServerData("ws/flight/addflight",JSON.stringify(data),callDone);
	});

	$("#butDeleteFlight").click(function(){

		deleteServerData("ws/flight/deleteflight/1",callDone);
	});

////////////////////////////////////////  PASSENGER  /////////////////

	$("#butAddUser").click(function(){
		var newUser = {
			mail : "eefefgg@geg",
			pwd : "eeeee",
			firstName : "Paul",
			lastName : "Agopian",
			phoneNumber : "0782653889",
			livingLocation : "Alfortville",
			passengerFlightsList : null,
			birthday : "1999-04-19"
		};
		putServerData("ws/passenger/createuser",JSON.stringify(newUser),callDone);
	});


	$("#butInfoUser").click(function(){				

		getServerData("ws/passenger/getuserinfo/11",callDone);

	});

});

		//contentType : "text/plain; charSet=UTF-8",

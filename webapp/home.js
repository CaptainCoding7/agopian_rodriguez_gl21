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
		"attribute":JSON.stringify(result)
	});

	$("#result").append(html);
}


$(function(){

	
	$("#butFlightsList").click(function(){

		var data = {
			plane : "Cessna 172",
			price : 50,
			destination : "Amsterdam",
			seats : 0
		}
		var plane = "Cessa 172";
		

		getServerData("ws/flight/flightsList/Cessna 172/50/Amsterdam/0",callDone);
		//getServerData("ws/flight/flightsList/data",callDone);
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

	$("#butEditUser").click(function(){				
		var data = {
	        id: 2
	    };
		var id="totototo";

		var dataJson = JSON.stringify(data);
		var idJson = JSON.stringify(id);
        //console.log(dataJson);
		postServerData("ws/passenger/edituser",idJson,callDone);

	});


	
});

		//contentType : "text/plain; charSet=UTF-8",

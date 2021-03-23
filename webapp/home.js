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
		getServerData("ws/ufly/flightsList",callDone);
	});

	$("#butFlightInfo").click(function(){
		getServerData("ws/ufly/flightInfo/2",callDone);
	});

	$("#butAddFlight").click(function(){
		var data = {
	        id: 1
	    };
		putServerData("ws/ufly/addflight",JSON.stringify(data),callDone);
	});

	$("#butEditUser").click(function(){				
		var data = {
	        id: 2
	    };
		var id="totototo";

		var dataJson = JSON.stringify(data);
		var idJson = JSON.stringify(id);
        //console.log(dataJson);
		postServerData("ws/ufly/edituser",idJson,callDone);

	});

	$("#butDeleteFlight").click(function(){

		deleteServerData("ws/ufly/deleteflight/1",callDone);
	});
	
});

		//contentType : "text/plain; charSet=UTF-8",

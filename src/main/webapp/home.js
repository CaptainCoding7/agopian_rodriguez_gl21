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
		//contentType : "text/plain; charSet=UTF-8",
		contentType: application/json,
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
	
	$("#button1").click(function(){
		getServerData("ws/ufly/passengerflightslist",callDone);
	});

	$("#button2").click(function(){
		getServerData("ws/ufly/aircraftInfo/1",callDone);
	});

	$("#button3").click(function(){				
		var data = {
	        id: 1
	    };
		var dataJson = JSON.stringify(data);
        //console.log(dataJson);
		postServerData("ws/ufly/edituser",data,callDone);

	});
	
});


function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
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
		getServerData("ws/example/passengerflightslist",callDone);
	});
	$("#button2").click(function(){
		getServerData("ws/example/aircraftInfo",callDone);
	});
});
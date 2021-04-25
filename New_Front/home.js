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
	
	for (let i = 0; i < result.length; i++) {
	
		let departure = templateExample({
			"attribute":JSON.stringify(result[i].departureAirport)
		});
		
		let arrival = templateExample({
			"attribute":JSON.stringify(result[i].destination)
		});	//https://makitweb.com/return-json-response-ajax-using-jquery-php/
		
		let price = templateExample({
			"attribute":JSON.stringify(result[i].pricePerPassenger)
		});
		
		let seats = templateExample({
			"attribute":JSON.stringify(result[i].availableSeats)
		});
		
		let title = templateExample({
			"attribute":JSON.stringify(result[i].flightTitle)
		});
		
		let img = templateExample({
			"attribute":JSON.stringify(result[i].flightImg)
		});
		
		// Display the element in the page
		let newFlight = document.createElement("li"); //creation of the element to insert in the list
		newFlight.className = "display"
		
		let imgDisplay = document.createElement("img");
		img.src = "D:\Documents\EIDD\2A\Genie logiciel\agopian_rodriguez_gl21-main_cloned\agopian_rodriguez_gl21\pic01.jpg";
		img.alt = "Image Of the Travel";
		newFlight.appendChild(imgDisplay);
		
		let displayPrice = document.createElement("p"); // display the price of the flight
		displayPrice.innerHTML = price + " per passenger";
		newFlight.appendChild(displayPrice);//insertion in the tag
		
		let titleDisplay = document.createElement("h1");
		titleDisplay.innerHTML = title;
		newFlight.appendChild(titleDisplay);//insertion in the tag
		
		let journey = document.createElement("p");
		journey.innerHTML = "departure : " + departure + "<br>" + "arrival : " + arrival;
		newFlight.appendChild(journey);//insertion in the tag
		
		let seatDisplay = document.createElement("p");
		seatDisplay.innerHTML = "Nb of places : " + seats;
		newFlight.appendChild(seatDisplay);//insertion in the tag
		
		document.querySelector("#list-result").appendChild(newFlight);//insert the new flight in the list		
	}
	document.querySelector("#results").style.display = 	"grid";
	
}

/*
function callDone(result){
	var templateExample = _.template($('#templateExample').html());
	
	let html = templateExample({
			"attribute":JSON.stringify(result[0].flightImg)
	});
	
	$("#results").append(html);
	
	document.querySelector("#results").style.display = 	"flex";
	
}	
*/
$(function(){

	$("#butFlightsList").click(function(){

		var data = {
			departure : $("#departure").val(),
			plane : $("#plane").val(),
			price : $("#price").val(),
			destination : $("#destination").val(),
			seats : parseInt($("#nbOfSeats").val()),
			//depDate : "2020-12-03T10:15:30"
		}
		
		var dataTest = {
			departure : "Paris",
			plane : "Cessna 172",
			price : 50,
			destination : "Amsterdam",
			seats : 0
			//depDate : "2020-12-03T10:15:30"
		}
		
		console.log($("#price").val());
		
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


		/*

*/

	$("#butInfoUser").click(function(){				

		getServerData("ws/passenger/getuserinfo/11",callDone);

	});

});
